package models;

import java.io.Serializable;
import java.util.Objects;

public class Point implements Serializable {
    private final double x;
    private final double y;
    private final double r;
    private boolean hitArea;



    public Point(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hitArea = checkTarget(this.x, this.y, this.r);
    }

    private boolean checkTarget(double x, double y, double r){
        if (x > 0 && y > 0){
            return x <= r && y <= r/2 && 2*y <= r - x;
        }
        if (x < 0 && y < 0){
            return x >= -r && y >= -r;
        }
        if (x < 0 && y > 0){
            return ((Math.pow(x, 2)) + Math.pow(y, 2) <= Math.pow(r/2, 2));
        }
        return (x == 0 && y <= r/2 && y >= -r) || (y == 0 && x <= r/2 && x >= -r);

    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getR(){
        return r;
    }

    public boolean isinArea(){
        return hitArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && Double.compare(y, point.y) == 0 && r == point.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r);
    }

    @Override
    public String toString() {
        return "models.Point{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", isInArea=" + hitArea +
                '}';
    }
}
