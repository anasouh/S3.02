package main;

import java.util.Random;
import java.util.function.Function;

public class Salle {
    private static int count = 0;
    public final static double PROBA_EVENT = 0.75;

    private int id;
    private String name;
    private boolean hasEvent;

    public Salle(String name) {
        this.id = count++;
        this.name = name;
        this.hasEvent = (new Random().nextDouble() < PROBA_EVENT);
    }

    public String getName() {
        return name;
    }

    public boolean hasEvent() {
        return hasEvent;
    }

    public void lancerEvent() {
        Event.aleatoire();
    }
}
