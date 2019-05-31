import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class MakeMoney {
    private static double trip(ArrayList<Town> towns, Trader trader){
        Town currentTown = cooseTown(towns);
        System.out.println("First town: "+currentTown.getName());
        String nextTown = trader.buy(towns,currentTown);

        while(towns.size()>1) {

            for (int i = 0; i<towns.size();i++){
                if (towns.get(i).getName().equals(currentTown.getName()))
                    towns.remove(i);
            }
            System.out.println("Next town: "+nextTown);
                for (Town t:towns)
                    if (t.getName().equals(nextTown))
                        currentTown=t;
                trader.sell(currentTown);
            if (towns.size()>1)
                nextTown=trader.buy(towns,currentTown);

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
        goods.removeAll(goods);

        goods.add(new Goods("Salt", 35));
        goods.add(new Goods("Fish", 50));
        goods.add(new Goods("Cloth", 40));
        goods.add(new Goods("Copper", 60));
        goods.add(new Goods("Furs", 45));
        Town Reval = new Town(goods,"Reval");
        towns.add(Reval);
        goods.removeAll(goods);

        goods.add(new Goods("Salt", 62));
        goods.add(new Goods("Fish", 15));
        goods.add(new Goods("Cloth", 18));
        goods.add(new Goods("Copper", 82));
        goods.add(new Goods("Furs", 54));
        Town Bergen = new Town(goods,"Bergen");
        towns.add(Bergen);
        goods.removeAll(goods);
        System.out.println("\nTrader "+Mike.getName()+" got "+trip(towns,Mike));

    }
}
