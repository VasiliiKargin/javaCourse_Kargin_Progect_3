import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Immovables> values = new ArrayList<Immovables>();
        values.add(new Flat("Квартира 1", null, "Екатеринбург, ул. Пушкина, д. 5, кв. 125", 45.6f, 30000.00f, 5.5F, 2));
        values.add(new Flat("Квартира 2", "Площадь 1905 года", "Екатеринбург, ул. Ленина, д. 1, кв. 11", 172.1F, 150000.00F, 8.9F, 7));
        values.add(new Flat("Квартира 3", "Проспект комонавтов", "Екатеринбург, ул. Ильича, д. 5, кв. 42", 93.4F, 40000.00F, 10.0F, 4));
        values.add(new Flat("Квартира 4", "Геологическая", "Екатеринбург, ул. 8 марта, д. 22, кв. 72", 59.4F, 70000.00F, 8.0F, 3));
        values.add(new CommercialPremises("Коммерческая неджвижимость 1", "Динамо", "Екатеринбург, ул. Свердлова, д. 15", 1045.4F, 400000.00F, 8.0F, "Торговая"));
        values.add(new CommercialPremises("Коммерческая неджвижимость 2", null, "Екатеринбург, ул. 8 марта, д. 15", 2045.4F, 700000.00F, 10.0F, "Офисное"));
        values.add(new CommercialPremises("Коммерческая неджвижимость 3", "Динамо", "Екатеринбург, ул. Кольцовский тракт, д. 158", 10852.5F, 700000.00F, 6.6F, "Складсое"));
        values.add(new CommercialPremises("Коммерческая неджвижимость 4", "Проспект космонавтов", "Екатеринбург, ул. Ильича, д. 41", 1342.1F, 900000.00F, 10.0F, "Производственное"));

        Logic.logic(values);

    }
}
