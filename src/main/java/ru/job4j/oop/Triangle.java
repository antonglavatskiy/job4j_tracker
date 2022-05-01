package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean exist(double ab, double bc, double ac) {
        return ab + ac > bc && ac + bc > ab && ab + bc > ac;
    }

    public double semiPerimeter(double ab, double bc, double ac) {
        double result = exist(ab, bc, ac) ? (ab + bc + ac) / 2 : -1;
        return result;
    }

    public double area() {
        double result = -1;
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = c.distance(a);
        if (this.exist(ab, bc, ac)) {
            double p = semiPerimeter(ab, bc, ac);
            result = sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return result;
    }
}
