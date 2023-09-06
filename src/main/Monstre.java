package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Monstre extends Personnage {
  private int danger;
  private MonstreType type;
  private static Random random = new Random();
  private static String noms = "Blanche graisse et les 7 daleux,La belle au bras pendant,Ali kebab et les 40 violeurs";
  private static List<String> lstNoms = new ArrayList<>(Arrays.asList(noms.split(",")));

  public Monstre(String name, int pv, int physAtk, int mana, int def, int speed) {
    // Spécifique au boss
    super(name, pv, physAtk, mana, def, speed);
    this.type = MonstreType.Boss;
  }

  public Monstre()// Nom aleatoir
  {
    super(generNom(), 100, (random.nextInt(7) + 15), 100, (random.nextInt(10) + 5), (random.nextInt(30) + 20));
    this.danger = random.nextInt(100); // si le danger du monstre est + grand que le stealth du Livreur alors il voit
    // le Livreur
    this.type = MonstreType.random();
    if (this.type.equals(MonstreType.Magicien))
      this.mana *= 1.5;
    else if (this.type.equals(MonstreType.Guerrier))
      this.physAtk *= 1.5;
    if (this.type.equals(MonstreType.Kim_Jung_Un))
      this.def *= 1.5;
    else if (this.type.equals(MonstreType.MiniBoss)) {
      this.mana *= 1.5;
      this.physAtk *= 1.5;
      this.def *= 1.5;
      this.danger *= 1.5;
    } else {
      this.hp = 200;
      this.physAtk = 30;
      this.mana = 100;
      this.speed = 100;
      this.def = 25;
    }
  }

  public Monstre(String name) { // monstre random
    super(name, 100, (random.nextInt(7) + 15), 100, (random.nextInt(10) + 5), (random.nextInt(30) + 20));
    this.danger = random.nextInt(70); // si le danger du monstre est + grand que le stealth du Livreur alors il voit
    // le Livreur
    this.type = MonstreType.random();
    if (this.type.equals(MonstreType.Magicien))
      this.mana *= 1.5;
    if (this.type.equals(MonstreType.Guerrier))
      this.physAtk *= 1.3;
    if (this.type.equals(MonstreType.Kim_Jung_Un))
      this.def *= 1.3;
    if (this.type.equals(MonstreType.MiniBoss)) {
      this.mana *= 1.5;
      this.physAtk *= 1.3;
      this.def *= 1.3;
      this.danger *= 1.7;
    }
  }

  public void dire(String replique) {
    switch (this.getType()) {
      case Magicien:
        System.out.println("Par le pouvoir des tenebres; " + replique);
        break;
      case Kim_Jung_Un:
        System.out.println("Tank, " + replique);
        break;
      case Guerrier:
        System.out.println("SPARTIAT !, " + replique);
        break;
      case MiniBoss:
        System.out.println("Gnegne " + replique);
        break;
      default:
        System.out.println(replique);

    }
  }

  private static String generNom() {
    if (lstNoms.size() > 0) {
      Random rnd = new Random();
      int rndIndex = rnd.nextInt(lstNoms.size());
      String res = lstNoms.get(rndIndex);
      lstNoms.remove(rndIndex);
      return res;
    }
    return "null";
  }

  public int getDanger() {
    return danger;
  }

  public String getName() {
    return type.getName();
  }

  public void attaquer(Personnage p) {
    double PROBA_SORT = 0;

    if (this.mana >= 20) {
      if (this.type == MonstreType.Magicien)
        PROBA_SORT = 0.75;
      else if (this.type == MonstreType.MiniBoss)
        PROBA_SORT = 0.5;
      else if (this.type == MonstreType.Boss)
        PROBA_SORT = 0.25;
      else
        PROBA_SORT = 0.3;
    }
    if (new Random().nextDouble() < PROBA_SORT) {
      this.lancerSort(p);
    } else {
      this.frapper(p);
    }
  }

  @Override
  public void interagir(Personnage truc) {
    Livreur l = (Livreur) truc;
    MonstreType type = this.getType();
    if (type.equals(MonstreType.Guerrier))
    {
      dire("Petit livreur " + l.getSociete().toString() + " ,nourris moi ou bats toi !!!", Color.RED);
    }
    else if (type.equals(MonstreType.Kim_Jung_Un))
    {
      dire("NOURRIS L'EMPEREUR !!!");
    }
    else if (type.equals(MonstreType.Magicien))
    {
      dire("J'ai une faim tenebreuse, un Kebab ou un sort ?");
    }
    else dire("COMBAT !!!");

  }

  public MonstreType getType() {
    return this.type;
  }

<<<<<<< HEAD

=======
  public void afficheImage()
  {
      MonstreType type = this.getType();
>>>>>>> 056b75bea91678c471f385c8406befea2b0a77b7

    //CAS MAGIC
    if (type.equals(MonstreType.Magicien)) {
      System.out.println(Color.BLUE + " /\\\n" +
              "                            /  \\\n" +
              "                           |    |\n" +
              "                         --:'''':--\n" +
              "                           :'_' :\n" +
              "                           _:\"\":\\___\n" +
              "            ' '      ____.' :::     '._\n" +
              "           . *=====<<=)           \\    :\n" +
              "            .  '      '-'-'\\_      /'._.'\n" +
              "                             \\====:_ \"\"\n" +
              "                            .'     \\\\\n" +
              "                           :       :\n" +
              "                          /   :    \\\n" +
              "                         :   .      '.\n" +
              "                         :  : :      :\n" +
              "                         :__:-:__.;--'\n" +
              "                          '-'   '-'" + Color.RESET);
    }

<<<<<<< HEAD
        //CAS MAGIC
        if (type.equals(MonstreType.Magicien))
        {
            System.out.println(Color.BLUE+
                    "                             /\\\n" +
                    "                            /  \\\n" +
                    "                           |    |\n" +
                    "                         --:'''':--\n" +
                    "                           :'_' :\n" +
                    "                           _:\"\":\\___\n" +
                    "            ' '      ____.' :::     '._\n" +
                    "           . *=====<<=)           \\    :\n" +
                    "            .  '      '-'-'\\_      /'._.'\n" +
                    "                             \\====:_ \"\"\n" +
                    "                            .'     \\\\\n" +
                    "                           :       :\n" +
                    "                          /   :    \\\n" +
                    "                         :   .      '.\n" +
                    "                         :  : :      :\n" +
                    "                         :__:-:__.;--'\n" +
                    "                          '-'   '-'"+Color.RESET);
        }

        //CAS GUERRIER
        if (type.equals(MonstreType.Guerrier))
        {
            System.out.println(Color.RED+"/ \\\n" +
                    "  | |\n" +
                    "  |.|\n" +
                    "  |.|\n" +
                    "  |:|      __\n" +
                    ",_|:|_,   /  )\n" +
                    "  (Oo    / _I_\n" +
                    "   +\\ \\  || __|\n" +
                    "      \\ \\||___|\n" +
                    "        \\ /.:.\\-\\\n" +
                    "         |.:. /-----\\\n" +
                    "         |___|::oOo::|\n" +
                    "         /   |:<_T_>:|\n" +
                    "        |_____\\ ::: /\n" +
                    "         | |  \\ \\:/\n" +
                    "         | |   | |\n" +
                    "         \\ /   | \\___\n" +
                    "         / |   \\_____\\\n" +
                    "         `-'"+Color.RESET);
        }
        //MINI BOSS
        if (type.equals(MonstreType.MiniBoss))
        {
            System.out.println(Color.CYAN_BOLD+"_________________________ \n" +
                    "|<><><>     |  |    <><><>|\n" +
                    "|<>         |  |        <>|\n" +
                    "|           |  |          |\n" +
                    "|  (______ <\\-/> ______)  |\n" +
                    "|  /_.-=-.\\| \" |/.-=-._\\  | \n" +
                    "|   /_    \\(o_o)/    _\\   |\n" +
                    "|    /_  /\\/ ^ \\/\\  _\\    |\n" +
                    "|      \\/ | / \\ | \\/      |\n" +
                    "|_______ /((( )))\\ _______|\n" +
                    "|      __\\ \\___/ /__      |\n" +
                    "|--- (((---'   '---))) ---|\n" +
                    "|           |  |          |\n" +
                    "|           |  |          |\n" +
                    ":           |  |          :     \n" +
                    " \\<>        |  |       <>/      \n" +
                    "  \\<>       |  |      <>/       \n" +
                    "   \\<>      |  |     <>/       \n" +
                    "    `\\<>    |  |   <>/'         \n" +
                    "      `\\<>  |  |  <>/'         \n" +
                    "        `\\<>|  |<>/'         \n" +
                    "          `-.  .-`           \n" +
                    "            '--'"+Color.RESET);
        }
=======
      //CAS GUERRIER
      if (type.equals(MonstreType.Guerrier))
      {
          System.out.println(Color.RED+"/ \\\n" +
                  "  | |\n" +
                  "  |.|\n" +
                  "  |.|\n" +
                  "  |:|      __\n" +
                  ",_|:|_,   /  )\n" +
                  "  (Oo    / _I_\n" +
                  "   +\\ \\  || __|\n" +
                  "      \\ \\||___|\n" +
                  "        \\ /.:.\\-\\\n" +
                  "         |.:. /-----\\\n" +
                  "         |___|::oOo::|\n" +
                  "         /   |:<_T_>:|\n" +
                  "        |_____\\ ::: /\n" +
                  "         | |  \\ \\:/\n" +
                  "         | |   | |\n" +
                  "         \\ /   | \\___\n" +
                  "         / |   \\_____\\\n" +
                  "         `-'"+Color.RESET);
      }
      //MINI BOSS
      if (type.equals(MonstreType.MiniBoss))
      {
          System.out.println(Color.CYAN_BOLD+"_________________________ \n" +
                  "|<><><>     |  |    <><><>|\n" +
                  "|<>         |  |        <>|\n" +
                  "|           |  |          |\n" +
                  "|  (______ <\\-/> ______)  |\n" +
                  "|  /_.-=-.\\| \" |/.-=-._\\  | \n" +
                  "|   /_    \\(o_o)/    _\\   |\n" +
                  "|    /_  /\\/ ^ \\/\\  _\\    |\n" +
                  "|      \\/ | / \\ | \\/      |\n" +
                  "|_______ /((( )))\\ _______|\n" +
                  "|      __\\ \\___/ /__      |\n" +
                  "|--- (((---'   '---))) ---|\n" +
                  "|           |  |          |\n" +
                  "|           |  |          |\n" +
                  ":           |  |          :     \n" +
                  " \\<>        |  |       <>/      \n" +
                  "  \\<>       |  |      <>/       \n" +
                  "   \\<>      |  |     <>/       \n" +
                  "    `\\<>    |  |   <>/'         \n" +
                  "      `\\<>  |  |  <>/'         \n" +
                  "        `\\<>|  |<>/'         \n" +
                  "          `-.  .-`           \n" +
                  "            '--'"+Color.RESET);
      }
>>>>>>> 056b75bea91678c471f385c8406befea2b0a77b7


  }

<<<<<<< HEAD

=======
    
>>>>>>> 056b75bea91678c471f385c8406befea2b0a77b7
}