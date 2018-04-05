package ru.atom.geometry;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Bar implements Collider {
    public static void main(String[] args) {
        Bar bar = new Bar(0,0,100,100);
        Point point = bar.getMidlePoint();
        System.out.println(point.getX());
        System.out.println(point.getY());
    }
    private Point firstConer;
    private Point secondConer;

    Bar (int x1, int y1, int x2, int y2) {
        int absolutex1 = (x1>x2) ? x2:x1;
        int absolutey1 = (y1>y2) ? y2:y1;
        int absolutex2 = (x1>x2) ? x1:x2;
        int absolutey2 = (y1>y2) ? y1:y2;
        this.firstConer = new Point(absolutex1,absolutey1);
        this.secondConer = new Point(absolutex2,absolutey2);
    }
    public Point getThirdConer () {
        return new Point(firstConer.getX(), secondConer.getY());
    }
    public Point getFirstConer() {
        return firstConer;
    }
    public Point getSecondConer() {
        return secondConer;
    }
    public Point getFortgConer () {
        return new Point(secondConer.getX(), firstConer.getY());
    }
    public Point getMidlePoint () {
        return new Point (((secondConer.getX()+firstConer.getX())/2),((secondConer.getY()+firstConer.getY())/2));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar= (Bar) o;
        if (this.firstConer.equals(bar.firstConer) && this.secondConer.equals(bar.secondConer))
            return true;
        else return false;
    }
    @Override
    public boolean isColliding(Collider other) {
        if (other.getClass() == getClass()) {
            Bar bar = (Bar) other;
            if (this.equals(other))
                return true;
            if ( this.isColliding(bar.firstConer)| this.isColliding(bar.secondConer)| this.isColliding(bar.getFortgConer())| this.isColliding(bar.getThirdConer()) | this.isColliding(bar.getMidlePoint())) {
                return true;
            } else {

                return false;
            }
        }
        if (other.getClass() == Point.class) {
            Point point = (Point) other;
            if ((this.firstConer.getX()<=point.getX()&& this.secondConer.getX()>=point.getX()) && (this.firstConer.getY()<=point.getY()&& this.secondConer.getY()>=point.getY()))
                return true;
            else
                return false;
        }
        return false;
    }
}
