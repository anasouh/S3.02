package main;

public enum Societe{
    UberEats(1.4, 1.2, 0.5, 0.6, 1), //Guerrier
    Deliveroo(0.8, 0.9, 1.5, 1.1, 1.2),//Magicien
    KingDelivery(1.2, 0.65, 1, 1.5, 1.6),//Voleur
    Indépendant(1, 1, 1, 1, 1); //Vierge

    private double atkMult;
    private double defMult;
    private double manaMult;
    private double stealthMult;
    private double speedMult;

    private Societe(double atkMult, double defMult, double manaMult, double stealthMult, double speedMult){
        this.atkMult = atkMult;
        this.defMult = defMult;
        this.manaMult = manaMult;
        this.stealthMult = stealthMult;
        this.speedMult = speedMult;
    }

    public double getAtkMult(){
        return this.atkMult;
    }

    public double getDefMult(){
        return this.defMult;
    }

    public double getManaMult(){
        return this.manaMult;
    }

    public double getStealthMult(){
        return this.stealthMult;
    }

    public double getSpeedMult(){
        return this.speedMult;
    }
}