
    import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            List<Phone> phones = new ArrayList<>();
            phones.add(new Phone("Samsung Galaxy S22Fe", 1050));
            phones.add(new Phone("Apple iPhone 14", 1100));
            phones.add(new Phone("Xiaomi Redmi Note 11 Pro", 625));
            phones.add(new Phone("Pixel 7", 700));
            phones.stream().sorted(new PhoneComparator()).forEach(p ->
                    System.out.printf("Price without discount: %s - %f$\n", p.getName(), p.getPrice()));
            System.out.println();

            System.out.println("Enter season name:");
            String nameSeason = new Scanner(System.in).nextLine();

            phones.stream().sorted(new PhoneComparator()).forEach(p -> System.out.printf(nameSeason +
                    " price: %s - %.2f$\n", p.getName(), p.getSeasonPrice(nameSeason)));

        }
        static class PhoneComparator implements Comparator<Phone> {

            @Override
            public int compare(Phone a, Phone b) {
                if (a.getPrice() > b.getPrice()) {
                    return 1;
                } else if (a.getPrice() == b.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
    }

