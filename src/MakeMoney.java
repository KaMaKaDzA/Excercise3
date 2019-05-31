import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class MakeMoney {
    private static double trip(ArrayList<Town> towns, Trader trader){
        Town currentTown = cooseTown(towns);
        System.out.println("First town: "+currentTown.getName());
        String nextTown = trader.buy(towns,currentTown);

        while(towns.size()>0) {
            trader.sell(currentTown);

            if(towns.size()>1){
                for (int i = 0; i<towns.size();i++){
                    if (towns.get(i).getName().equals(currentTown.getName()))
                        towns.remove(i);
                }
                System.out.println("Next town: "+nextTown);
                for (Town t:towns)
                    if (t.getName().equals(nextTown))
                        currentTown=t;
                nextTown=trader.buy(towns,currentTown);
            }
        }
        return trader.getMoney();
    }

    private static Town cooseTown(ArrayList<Town> towns){
        final int WISITING = 3;
        Random rnd = new Random(System.currentTimeMillis());
        return towns.get(rnd.nextInt(WISITING));
    }

    public static void main(String[] args) {
        ArrayList<Goods> goods = new ArrayList<Goods>();
        ArrayList<Town> towns = new ArrayList<Town>();
        Trader Mike = new Trader("Mike", 50);

        goods.add(new Goods("Salt", 20));
        goods.add(new Goods("Fish", 50));
        goods.add(new Goods("Cloth", 60));
        goods.add(new Goods("Copper", 36));
        goods.add(new Goods("Furs", 96));
        Town Lubeck = new Town(goods,"Lubeck");
        towns.add(Lubeck);

        goods.get(0).setPrice(35);
        goods.get(0).setPrice(50);
        goods.get(0).setPrice(40);
        goods.get(0).setPrice(60);
        goods.get(0).setPrice(45);
        Town Reval = new Town(goods,"Reval");
        towns.add(Reval);

        goods.get(0).setPrice(62);
        goods.get(0).setPrice(15);
        goods.get(0).setPrice(18);
        goods.get(0).setPrice(82);
        goods.get(0).setPrice(54);
        Town Bergen = new Town(goods,"Bergen");
        towns.add(Bergen);

        System.out.println("Trader "+Mike.getName()+" got "+trip(towns,Mike));

    }
}
