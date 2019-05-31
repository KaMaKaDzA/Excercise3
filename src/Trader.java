/*
* there is ambiguity in the task.
* carrying no more than one good can be regarded as no more than one piece of goods,
* or as no more than one type of goods. I choose second option.
* */
import java.util.ArrayList;

public class Trader{
    private String name;
    private double money;
    private String good = "";
    private int goodCount = 0;

    Trader(String name, double Money){
        this.name = name;
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double money){
        this.money = money;
    }

    public String getGood(){
        return good;
    }
    public void setGood(String good){
        this.good = good;
    }

    public int getGoodCount(){
        return goodCount;
    }

    public void setGoodCount(int goodCount){
        this.goodCount=goodCount;
    }

    public String buy(ArrayList<Town> towns, Town currentTown){
        String[] compareRezult = comparePrices(towns,currentTown);
        for (int i=0; i<currentTown.getGoods().size(); i++)
            if (currentTown.getGoods().get(i).getName().equals(compareRezult[1])){
                good=currentTown.getGoods().get(i).getName();
                goodCount = howMuchIcanBuy(currentTown.getGoods().get(i).getPrice());
                System.out.println("Bought "+goodCount+" "+good+"\n");
                break;
            }
            return compareRezult[0];
    }

    private String[] comparePrices(ArrayList<Town> towns, Town currentTown){
        Goods nextGood;
        Town nextTown= new Town();
        Goods order=currentTown.getGoods().get(0);
        double currentPricce;
        for (int i = 0; i<towns.size(); i++){
            if (towns.get(i).getName()==currentTown.getName())                                                          //if it's not current town
                continue;
            for (int j=0; j<currentTown.getGoods().size(); j++){                                                        //check and compare all prices
                currentPricce = currentTown.getGoods().get(j).getPrice();
                nextGood = towns.get(i).getGoods().get(j);
                if (currentPricce<=money){                                                                              //if u have enought money
                    if((nextGood.getPrice()-currentPricce)*howMuchIcanBuy(currentPricce)>order.getPrice()){
                        order=nextGood;
                        nextTown=towns.get(i);
                    }
                }
            }
        }
        return new String[]{nextTown.getName(), order.getName()};
    }

    private int howMuchIcanBuy(double price){

        return (int)(money/price);
    }

    public void sell(Town currentTown){
        money=money+currentTown.getGoodsByName(good).getPrice()*goodCount;
        good="";
        goodCount=0;
    }
}
