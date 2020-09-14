import java.util.Hashtable;

// It is a real subject class
class WareHouse implements IOrder{
    private Hashtable<String, Integer> stock;
    private String address;
    private static final int DEFAULT_STOCK = 0;

    @Override
    public void fullFillOrder(Order order, String address) {
        this.address = address;
        for (Item item : order.getItems()) {
            this.stock.replace(item.getUuid(), stock.get(item.getUuid())-1);
        }
        System.out.println(this.address+"will get order. the total prize is="+ order.getTotalPrize());
    }
    
    public int checkInverntory(Item item){
        return stock.getOrDefault(item.getUuid(), DEFAULT_STOCK);
    }
}