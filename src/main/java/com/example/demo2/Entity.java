package com.example.demo2;

public class Entity {
    private double x; // x location of circle
    private double y; // y location of circle

    private double r;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
        this.r = 10;
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public boolean contains(double mx, double my) {
        return dist(mx,my,x,y) <= r;
    }

    private double dist(double x1, double y1, double x2, double y2) {
        //return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return Math.hypot(x2-x1,y2-y1);
    }

    public void move(double dX, double dY) {
        this.x += dX;
        this.y += dY;
        }
}
