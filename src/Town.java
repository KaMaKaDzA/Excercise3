import java.util.ArrayList;

public class Town {
    private String name;
    private ArrayList<Goods> goods = new ArrayList<Goods>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Goods> getGoods(){
        return goods;
    }

    public Goods getGoodsByName(String name) throws NullPointerException{
        for (Goods g:goods){
            if (g.getName().equals(name))
                return g;

        }
        throw new NullPointerException("No such goods!");
    }

    Town(ArrayList<Goods> goods, String name){
        this.goods=(ArrayList<Goods>) goods.clone();
    }

    Town(){}


}
