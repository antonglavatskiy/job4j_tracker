package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery(
                            "UPDATE Item i SET i.name = :fName, i.created = :fCreated WHERE i.id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery(
                            "DELETE Item i WHERE i.id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        return session.createQuery("from Item", Item.class).list();
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                "from Item i WHERE i.name = :fName", Item.class);
        query.setParameter("fName", key);
        return query.list();
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                "from Item i WHERE i.id = :fId", Item.class);
        query.setParameter("fId", id);
        return query.uniqueResult();
    }
}
