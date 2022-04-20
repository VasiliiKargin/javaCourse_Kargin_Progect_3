import java.util.*;
import java.util.stream.Collectors;

public class Logic {
    public static void logic(List<Immovables> values){
        Scanner scr = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.ENGLISH);

        int numMenu = 0;
        while (numMenu != 5) {
            Menus.MyMenu();
            numMenu = scr.nextInt();
            switch (numMenu) {
                case 1:
                    Menus.MenuFlat();
                    int numMenuFlat = scr.nextInt();
                    if (numMenuFlat == 1) {
                        values=addval(numMenu,values);
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
                        values=addval(numMenu,values);
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
    public static List<Immovables> addval(int numMenu,List<Immovables> values){
        Scanner scr = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.ENGLISH);
        System.out.println("Введи наименование!");
        String name = scr.next();
        System.out.println("Введи Станцию метро!");
        String underground = scr.next();
        System.out.println("Введи Адрес");
        String address = scr.next();
        System.out.println("Введи метраж (разделитель точка)");
        float square = scr.nextFloat();
        System.out.println("Введи цену аренды(разделитель точка)");
        float price = scr.nextFloat();
        System.out.println("Введи оценку(разделитель точка)");
        float rating = scr.nextFloat();
        if (numMenu==1) {
            System.out.println("Введи количество комнат");
            int numberOfRooms = scr.nextInt();
            values.add(new Flat(name, underground, address, square, price, rating, numberOfRooms));
        }
        else {
            System.out.println("Введи тип коммерческого помещения");
        String typeRoom = scr.next();
        values.add(new CommercialPremises(name, underground, address, square, price, rating, typeRoom));
        }
        return values;
    }
}
