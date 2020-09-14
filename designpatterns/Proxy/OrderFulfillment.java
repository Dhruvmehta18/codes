import java.util.List;

public class OrderFulfillment implements IOrder {

    private List<WareHouse> warehouses;
    private static final String STOCK_AVAILABLE = "Ok so the stock is available";
    private static final String STOCK_UNAVAILABLE = "Oh No!! The stocks are gone for the vacation.Come after some time";

    @Override
    public void fullFillOrder(Order order, String address) {
        for (Item item : order.getItems()) {
            for (WareHouse wareHouse : warehouses) {
                boolean isAvailable = wareHouse.checkInverntory(item) > 0;
                System.out.println(isAvailable ?  STOCK_AVAILABLE : STOCK_UNAVAILABLE );
            }
        }
    }
    
}
