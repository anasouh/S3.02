package main;

import java.util.Random;

public enum MonstreType {
    Magicien("Magicien"), // mana upgradée
    Guerrier("Guerrier"), // atk upgradée
    Defense("Defense"), // défense upgradée
    MiniBoss("MiniBoss"); // tout upgradé

    private String name;
    
    private MonstreType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MonstreType random() {
        double val = new Random().nextDouble();
        if (val < 0.35) return Magicien; //35% de chance d'avoir un magicien
        else if (val < 0.70) return Guerrier; //35% de chance d'avoir un guerrier
        else if (val < 0.95) return Defense; //25% de chance d'avoir un defense
        return MiniBoss; //5% de chance d'avoir un boss
    }
}
