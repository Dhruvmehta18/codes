import java.util.UUID;

public class Item {
    private String title;
    private float prize;
    private String uuid;
    private float discount;

    public Item(String title, float prize, float discount){
        this.title=title;
        this.prize = prize;
        this.discount = discount;
        this.uuid= UUID.fromString(title).toString();
    }

    public String getTitle() {
        return this.title;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void changePrize(int changedPrize){
        this.prize = changedPrize;
    }

    public float getOriginalPrize(){
        return this.prize;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        if (discount<0||discount>1) {
            return;
        }
        this.discount = discount;
    }

    public float getDiscountedPrize(){
        return this.getOriginalPrize() * (1-this.getDiscount());
    }
}
