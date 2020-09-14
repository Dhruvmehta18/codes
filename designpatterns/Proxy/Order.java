import java.util.List;

public class Order {
    private List<Item> items;

    public Order(List<Item> items){
        this.items.addAll(items);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public int getTotalOrderSize(){
        return this.items.size();
    }

    public float getTotalPrize(){
        float totalPrize = 0;
        for (Item item : items) {
            totalPrize += item.getDiscountedPrize();
        }
        return totalPrize;
    }

    public boolean removeItemAtIndex(int index){
        this.items.remove(index);
        return true;
    }
}
