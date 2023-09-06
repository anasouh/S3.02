package main;

public enum ItemType {
    ARME,
    ARMURE,
    ACCESSOIRE;

    public static boolean estArme(Item item){
        return item.getType().equals(ItemType.ARME);
    }

    public static boolean estArmure(Item item){
        return item.getType().equals(ItemType.ARMURE);
    }

    public static boolean estAccessoire(Item item){
        return item.getType().equals(ItemType.ACCESSOIRE);
    }
}
