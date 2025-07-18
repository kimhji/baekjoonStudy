import java.util.Scanner;

public class Main {
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static double ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
    }

    static double dist(Point a, Point b) {
        double x = a.x - b.x;
        double y = a.y - b.y;
        return Math.sqrt(x * x + y * y);
    }

    static double getRound(double a, double b) {
        return 2 * (a + b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Point a = new Point(sc.nextDouble(), sc.nextDouble());
        Point b = new Point(sc.nextDouble(), sc.nextDouble());
        Point c = new Point(sc.nextDouble(), sc.nextDouble());

        if (ccw(a, b, c) == 0) {
            System.out.println(-1);
        } else {
            double ab = dist(a, b);
            double bc = dist(b, c);
            double ac = dist(a, c);

            double[] perimeters = new double[3];
            perimeters[0] = getRound(ab, ac);
            perimeters[1] = getRound(ab, bc);
            perimeters[2] = getRound(ac, bc);

            double maxValue = 0;
            double minValue = 40000;

            for (double p : perimeters) {
                if (p > maxValue) maxValue = p;
                if (p < minValue) minValue = p;
            }

            System.out.printf("%.14f\n", maxValue - minValue);
        }
        sc.close();
    }
}
