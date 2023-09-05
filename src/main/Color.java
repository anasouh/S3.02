package main;

public enum Color {
    //Suppression de couleurs
    RESET("\033[0m"),

    //Couleurs classiques
    BLACK("\033[0;30m"),    // Noir
    RED("\033[0;31m"),      // Rouge
    GREEN("\033[0;32m"),    // Vert
    YELLOW("\033[0;33m"),   // Jaune
    BLUE("\033[0;34m"),     // Bleu
    PURPLE("\033[0;35m"),   // Violet
    CYAN("\033[0;36m"),     // Cyan
    WHITE("\033[0;37m"),    // Blanc

    // Gras
    BLACK_BOLD("\033[1;30m"),   // Noir
    RED_BOLD("\033[1;31m"),     // Rouge
    GREEN_BOLD("\033[1;32m"),   // Vert
    YELLOW_BOLD("\033[1;33m"),  // Jaune
    BLUE_BOLD("\033[1;34m"),    // Bleu
    PURPLE_BOLD("\033[1;35m"),  // Violet
    CYAN_BOLD("\033[1;36m"),    // Cyan
    WHITE_BOLD("\033[1;37m"),   // Blanc

    // Souligné
    BLACK_UNDERLINED("\033[4;30m"),     // Noir
    RED_UNDERLINED("\033[4;31m"),       // Rouge
    GREEN_UNDERLINED("\033[4;32m"),     // Vert
    YELLOW_UNDERLINED("\033[4;33m"),    // Jaune
    BLUE_UNDERLINED("\033[4;34m"),      // Bleu
    PURPLE_UNDERLINED("\033[4;35m"),    // Violet
    CYAN_UNDERLINED("\033[4;36m"),      // Cyan
    WHITE_UNDERLINED("\033[4;37m"),     // Blanc

    // Fond
    BLACK_BACKGROUND("\033[40m"),   // Noir
    RED_BACKGROUND("\033[41m"),     // Rouge
    GREEN_BACKGROUND("\033[42m"),   // Vert
    YELLOW_BACKGROUND("\033[43m"),  // Jaune
    BLUE_BACKGROUND("\033[44m"),    // Bleu
    PURPLE_BACKGROUND("\033[45m"),  // Violet
    CYAN_BACKGROUND("\033[46m"),    // Cyan
    WHITE_BACKGROUND("\033[47m"),   // Blanc

    // Haute intensité
    BLACK_BRIGHT("\033[0;90m"),     // Noir
    RED_BRIGHT("\033[0;91m"),       // Rouge
    GREEN_BRIGHT("\033[0;92m"),     // Vert
    YELLOW_BRIGHT("\033[0;93m"),    // Jaune
    BLUE_BRIGHT("\033[0;94m"),      // Bleu
    PURPLE_BRIGHT("\033[0;95m"),    // Violet
    CYAN_BRIGHT("\033[0;96m"),      // Cyan
    WHITE_BRIGHT("\033[0;97m"),     // Blanc

    // Gras haute intensité
    BLACK_BOLD_BRIGHT("\033[1;90m"),    // Noir
    RED_BOLD_BRIGHT("\033[1;91m"),      // Rouge
    GREEN_BOLD_BRIGHT("\033[1;92m"),    // Vert
    YELLOW_BOLD_BRIGHT("\033[1;93m"),   // Jaune
    BLUE_BOLD_BRIGHT("\033[1;94m"),     // Bleu
    PURPLE_BOLD_BRIGHT("\033[1;95m"),   // Violet
    CYAN_BOLD_BRIGHT("\033[1;96m"),     // Cyan
    WHITE_BOLD_BRIGHT("\033[1;97m"),    // Blanc

    // Fond haute intensité
    BLACK_BACKGROUND_BRIGHT("\033[0;100m"),     // Noir
    RED_BACKGROUND_BRIGHT("\033[0;101m"),       // Rouge
    GREEN_BACKGROUND_BRIGHT("\033[0;102m"),     // Vert
    YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),    // Jaune
    BLUE_BACKGROUND_BRIGHT("\033[0;104m"),      // Bleu
    PURPLE_BACKGROUND_BRIGHT("\033[0;105m"),    // Violet
    CYAN_BACKGROUND_BRIGHT("\033[0;106m"),      // Cyan
    WHITE_BACKGROUND_BRIGHT("\033[0;107m");     // Blanc

    private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
