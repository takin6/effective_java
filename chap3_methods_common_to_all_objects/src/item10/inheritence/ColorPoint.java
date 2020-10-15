package item10.inheritence;

import item10.Color;
import item10.Point;


public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x,y);
        this.color = color;
    }

    // Broken - violates symmetry!  (Page 41)
    // The problem with this method is that you might get different results when comparing a point to a color point and vice versa.
    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        // First equals function violates symmetry (Page 42)
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // Second equals function violates transitivity (Page 42)
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n",
                p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}


//So what’s the solution?
// It turns out that this is a fundamental problem of equivalence relations in object-oriented languages.
// There is no way to extend an instantiable class and add a value component while preserving the equals contract