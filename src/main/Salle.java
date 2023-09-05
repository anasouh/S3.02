package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Salle {
    // Ajouter des salles si besoin de plus de 24 
    public final static double PROBA_EVENT = 0.75;
    private final static String NAMES_LIST = """
        Chemin énigmatique,
        Passage obscure,
        Passage du croisement sourd,
        Coin mystérieux,
        Grotte silencieuse,
        Allée invisible,
        Caverne abandonnée,
        Galerie cachée,
        Antre inexplorée,
        Passage mystique,
        Grotte ombragée,
        Clairière sereine,
        Abri de nuit,
        Bosquet mystérieux,
        Ruine enfouie,
        Antre sauvage,
        Caverne oubliée,
        Marécage profond,
        Sentier tortueux,
        Terrier sombre,
        Source claire,
        Passage caché,
        Arche antique,
        Banc de brume,
        Étang marécageux,
    """;
    private static ArrayList<String> NAMES = new ArrayList<>(Arrays.asList(NAMES_LIST.split(",")));
    
    private String name;
    private boolean hasEvent;

    public Salle() {
        this.name = NAMES.remove(new Random().nextInt(NAMES.size())).strip();
        this.hasEvent = (new Random().nextDouble() < PROBA_EVENT);
    }

    public String getName() {
        return name;
    }

    public boolean hasEvent() {
        return hasEvent;
    }

    public void lancerEvent(Livreur l) {
        Event.aleatoire(l);
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Salle());
        }
    }
}