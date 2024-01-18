package com.example.demo2;

import java.util.ArrayList;

public class Model {
    private ArrayList<Subscriber> subs; // list of subscribers
    private ArrayList<Entity> entities; // list of circles

    public Model() {
        subs = new ArrayList<Subscriber>();
        entities = new ArrayList<Entity>();
    }

    public void addEntity(double x, double y) {
        // add new circle to list of circles and notify subscribers
        entities.add(new Entity(x,y));
        notifySubscribers();
    }

    public void addSubscriber(Subscriber sub)
    {
        // add new subscriber to list of subscribers
        subs.add(sub);
    }

    void notifySubscribers() {
        // for each subscriber, call the modelChanged method
        subs.forEach(sub -> sub.modelChanged(entities));
    }

    public boolean contains(double x, double y) {
        for (Entity entity : entities) {
            if (entity.contains(x, y)) return true;
        }
        return false;
    }

    public Entity whichHit(double x, double y) {
        for (Entity entity : entities) {
            if (entity.contains(x, y)) return entity;
        }
        return null;
    }

    public void move(Entity selected, double dX, double dY) {
        // TODO
    }
}
