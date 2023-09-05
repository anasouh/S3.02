package main;

import java.util.Random;

public enum MonstreType {
    A("Monstre A"),
    B("Monstre B"),
    C("Monstre C"),
    D("Monstre D");

    private String name;

    private MonstreType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MonstreType random() {
        double val = new Random().nextDouble();
        if (val < 0.25) return A;
        else if (val < 0.5) return B;
        else if (val < 0.75) return C;
        return D;
    }
}
