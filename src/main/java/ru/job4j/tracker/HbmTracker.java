package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
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
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            rsl = session.createQuery(
                            "UPDATE Item i SET i.name = :fName, i.created = :fCreated WHERE i.id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            rsl = session.createQuery(
                            "DELETE Item i WHERE i.id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Transaction transaction = null;
        List<Item> rsl = new ArrayList<>();
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Query<Item> query = session.createQuery("from Item", Item.class);
            rsl = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        Transaction transaction = null;
        List<Item> rsl = new ArrayList<>();
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "from Item i WHERE i.name = :fName", Item.class)
                    .setParameter("fName", key);
            rsl = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Transaction transaction = null;
        Item rsl = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "from Item i WHERE i.id = :fId", Item.class)
                    .setParameter("fId", id);
            rsl = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rsl;
    }
}
