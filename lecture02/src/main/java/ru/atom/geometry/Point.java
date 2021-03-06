package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider  {
    private int x;
    private int y;
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;
        // your code here
        if (this.x == point.x && this.y==point.y)
            return true;
        else return false;
    }

    @Override
    public boolean isColliding(Collider other) {
        return this.equals(other);
    }
}
