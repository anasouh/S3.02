package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monstre extends Personnage{
    private int danger;
    private MonstreType type;
    private static Random random = new Random();
    private static List<String> lstNoms = new ArrayList<>();

    String noms = "Blanche graisse et les 7 daleux,La belle au bras pendant,Ali kebab et les 40 violeurs";

    String[] tbnoms = noms.split(",");

    private void chargNom()
    {
         for(String n : tbnoms)
    {
        lstNoms.add(n);
    }
    
    }

    public Monstre(String name, int pv, int physAtk, int magicAtk, int mana, int def, int danger){
        super(name,pv,physAtk,magicAtk,mana,def);
        this.danger = danger;
        this.type = MonstreType.random();
    }

    public Monstre()//Nom aleatoir
    {
      super(generNom(),100,(random.nextInt(24) + 1),100,(random.nextInt(24) + 1),(random.nextInt(24) + 1));
        this.danger = random.nextInt(100); //si le danger du monstre est + grand que le stealth du Livreur alors il voit le Livreur
        this.type = MonstreType.random();
        if (this.type.equals(MonstreType.Magicien)) this.mana *= 1.5;
        if (this.type.equals(MonstreType.Guerrier)) this.physAtk *= 1.5;
        if (this.type.equals(MonstreType.Defense)) this.def *= 1.5;
        if (this.type.equals(MonstreType.MiniBoss)) {
            this.mana *= 1.5;
            this.physAtk *= 1.5;
            this.def *= 1.5;
            this.danger *= 1.5;
        }
    }

    public Monstre(String name){ //monstre random
        super(name,100,(random.nextInt(24) + 1),100,(random.nextInt(24) + 1),(random.nextInt(24) + 1));
        this.danger = random.nextInt(100); //si le danger du monstre est + grand que le stealth du Livreur alors il voit le Livreur
        this.type = MonstreType.random();
        if (this.type.equals(MonstreType.Magicien)) this.mana *= 1.5;
        if (this.type.equals(MonstreType.Guerrier)) this.physAtk *= 1.5;
        if (this.type.equals(MonstreType.Defense)) this.def *= 1.5;
        if (this.type.equals(MonstreType.MiniBoss)) {
            this.mana *= 1.5;
            this.physAtk *= 1.5;
            this.def *= 1.5;
            this.danger *= 1.5;
        }
    }

    public void dire(String replique)
    {
        switch(this.getType())
        {
            case Magicien: 
              System.out.println("Par le pouvoir des tenebres; "+replique);
              break;
            case Defense:
              System.out.println("Tank, "+replique);
              break;
            case Guerrier:
              System.out.println("SPARTIAT !, "+replique);
              break;
            case MiniBoss:
              System.out.println("Gnegne "+replique);
              break;
            default: System.out.println(replique);
             
          }
    }

    private static String generNom()
    {
      Random rnd = new Random();
      int rndIndex = rnd.nextInt(lstNoms.size());
      String res = lstNoms.get(rndIndex);
      lstNoms.remove(rndIndex);
      return res;
    }

    public int getDanger() {
        return danger;
    }

    public String getName() {
        return type.getName();
    }

<<<<<<< HEAD
    public MonstreType getType()
    {return this.type;}
=======
    public MonstreType getMonstreType(){
        return type;
    }
>>>>>>> fc7b7456fe9e937572a4cfb67c98dea723cb381b

    @Override
    public String toString(){
        String result = Color.RED + super.toString();
        result = result + "Type : " + this.type + " - Danger : " + this.danger + Color.RESET;
        return result;
    }

    
}