import java.util.Comparator;
interface SeasonPrice {
    double calcPrice(double discount, double price);
}
public class Phone {
    private String name;
    private double price;

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public double getDiscount(int discount, SeasonPrice func) {
        return func.calcPrice(discount, price);
    }

    public double getSeasonPrice(String season) {
        switch (season) {
            case "winter":
                return getDiscount(10, (discount, currPrice) -> {
                    return currPrice - discount * 5;
                });
            case "summer":
                return getDiscount(10, (discount, currPrice) -> {
                    return currPrice * (1 - (discount / 100));
                });
            default:
                return price;
        }
    }
}





