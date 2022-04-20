import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.ENGLISH);

        List<Immovables> values = new ArrayList<Immovables>();
        values.add(new Flat("Квартира 1", null, "Екатеринбург, ул. Пушкина, д. 5, кв. 125", 45.6f, 30000.00f, 5.5F, 2));
        values.add(new Flat("Квартира 2", "Площадь 1905 года", "Екатеринбург, ул. Ленина, д. 1, кв. 11", 172.1F, 150000.00F, 8.9F, 7));
        values.add(new Flat("Квартира 3", "Проспект комонавтов", "Екатеринбург, ул. Ильича, д. 5, кв. 42", 93.4F, 40000.00F, 10.0F, 4));
        values.add(new Flat("Квартира 4", "Геологическая", "Екатеринбург, ул. 8 марта, д. 22, кв. 72", 59.4F, 70000.00F, 8.0F, 3));
        values.add(new CommercialPremises("Коммерческая неджвижимость 1", "Динамо", "Екатеринбург, ул. Свердлова, д. 15", 1045.4F, 400000.00F, 8.0F, "Торговая"));
        values.add(new CommercialPremises("Коммерческая неджвижимость 2", null, "Екатеринбург, ул. 8 марта, д. 15", 2045.4F, 700000.00F, 10.0F, "Офисное"));
        values.add(new CommercialPremises("Коммерческая неджвижимость 3", "Динамо", "Екатеринбург, ул. Кольцовский тракт, д. 158", 10852.5F, 700000.00F, 6.6F, "Складсое"));
        values.add(new CommercialPremises("Коммерческая неджвижимость 4", "Проспект космонавтов", "Екатеринбург, ул. Ильича, д. 41", 1342.1F, 900000.00F, 10.0F, "Производственное"));


        int numMenu = 0;
        while (numMenu != 5) {
            Menus.MyMenu();
            numMenu = scr.nextInt();
            switch (numMenu) {
                case 1:
                    Menus.MenuFlat();
                    int numMenuFlat = scr.nextInt();
                    if (numMenuFlat == 1) {
                        System.out.println("Введи наименование!");
                        String name = scr.next();
                        System.out.println("Введи Станцию метро!");
                        String underground = scr.next();
                        System.out.println("Введи Адрес");
                        String address = scr.next();
                        System.out.println("Введи метраж квартиры(разделитель точка)");
                        float square = scr.nextFloat();
                        System.out.println("Введи цену аренды(разделитель точка)");
                        float price = scr.nextFloat();
                        System.out.println("Введи оценку(разделитель точка)");
                        float rating = scr.nextFloat();
                        System.out.println("Введи количество комнат");
                        int numberOfRooms = scr.nextInt();
                        values.add(new Flat(name, underground, address, square, price, rating, numberOfRooms));
                    }
                    if (numMenuFlat == 2) {
                        System.out.println("Введи наименование квартиры для удаления");
                        String search = scr.next();
                        values.removeIf(x->x.getName().equals(search) && x instanceof Flat);
                    }
                    if (numMenuFlat==3){
                        values.stream().filter(x-> x.getClassName()=="Квартиры").sorted(Comparator.comparing(Immovables::getPrice)).forEach(System.out::println);
                    }
                    if (numMenuFlat==4){
                        values.stream().filter(x-> x.getClassName()=="Квартиры").sorted(Comparator.comparing(Immovables::getPrice).reversed()).forEach(System.out::println);
                    }
                    if (numMenuFlat==5){
                        Map<String, List<Immovables>> groupByUnderground = values.stream().filter(x-> x.getClassName()=="Квартиры").collect(Collectors.groupingBy(y -> y.getUnderground()!=null ? y.getUnderground():"Метро нет"));
                        groupByUnderground.forEach((k, v) -> {
                            System.out.println(k);
                            for (Immovables immovables : v) {
                                System.out.println(immovables);
                            }
                        });
                    }
                    if (numMenuFlat==6){
                        values.stream().filter(x-> x.getClassName()=="Квартиры").max(Comparator.comparing(Immovables::getRating)).ifPresent(System.out::println);
                    }
                    if (numMenuFlat==7){
                        values.stream().filter(x-> x.getClassName()=="Квартиры").forEach(System.out::println);
                    }
                    break;
                case 2:
                    Menus.MenuCommercialPremises();
                    int numMenuCP = scr.nextInt();
                    if (numMenuCP == 1) {
                        System.out.println("Введи наименование!");
                        String name = scr.next();
                        System.out.println("Введи Станцию метро!");
                        String underground = scr.next();
                        System.out.println("Введи Адрес");
                        String address = scr.next();
                        System.out.println("Введи метраж коммерческого помещения(разделитель точка)");
                        float square = scr.nextFloat();
                        System.out.println("Введи цену аренды(разделитель точка)");
                        float price = scr.nextFloat();
                        System.out.println("Введи оценку(разделитель точка)");
                        float rating = scr.nextFloat();
                        System.out.println("Введи тип коммерческого помещения");
                        String typeRoom = scr.next();
                        values.add(new CommercialPremises(name, underground, address, square, price, rating, typeRoom));
                    }
                    if (numMenuCP == 2) {
                        System.out.println("Введи наименование Коммерческого помещения для удаления");
                        String search = scr.next();
                        values.removeIf(x->x.getName().equals(search) && x instanceof CommercialPremises);
                    }
                    if (numMenuCP==3){
                        values.stream().filter(x-> x.getClassName()=="Коммерческие помещения").sorted(Comparator.comparing(Immovables::getPrice)).forEach(System.out::println);
                    }
                    if (numMenuCP==4){
                        values.stream().filter(x-> x.getClassName()=="Коммерческие помещения").sorted(Comparator.comparing(Immovables::getPrice).reversed()).forEach(System.out::println);
                    }
                    if (numMenuCP==5){
                        Map<String, List<Immovables>> groupByUnderground = values.stream().filter(x-> x.getClassName()=="Коммерческие помещения").collect(Collectors.groupingBy(y -> y.getUnderground()!=null ? y.getUnderground():"Метро нет"));
                        groupByUnderground.forEach((k, v) -> {
                            System.out.println(k);
                            for (Immovables immovables : v) {
                                System.out.println(immovables);
                            }
                        });
                    }
                    if (numMenuCP==6){
                        values.stream().filter(x-> x.getClassName()=="Коммерческие помещения").max(Comparator.comparing(Immovables::getRating)).ifPresent(System.out::println);
                    }
                    if (numMenuCP==7){
                        values.stream().filter(x-> x.getClassName()=="Коммерческие помещения").forEach(System.out::println);
                    }
                    break;
                case 3:
                    values.clear();
                    break;
                case 4:
                    Map<?, List<Immovables>> groupByType = values.stream().collect(Collectors.groupingBy(Immovables::getClassName));
                    groupByType.forEach((k, v) -> {
                        System.out.println(k);
                        for (Immovables immovables : v) {
                            System.out.println(immovables);
                        }
                    });
                    break;
            }
        }
        System.out.println("До свидания!");
    }
}
