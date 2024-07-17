import java.util.*;

public class Магазин {
    public static void main(String[] args) {
        Set<Ноутбук> ноутбуки = new HashSet<>();
        ноутбуки.add(new Ноутбук("Model A", 8, 256, "Windows", "Черный"));
        ноутбуки.add(new Ноутбук("Model B", 16, 512, "Linux", "Серебристый"));
        ноутбуки.add(new Ноутбук("Model C", 32, 1024, "MacOS", "Белый"));

        Map<Integer, String> критерии = new HashMap<>();
        критерии.put(1, "ОЗУ");
        критерии.put(2, "Объем ЖД");
        критерии.put(3, "Операционная система");
        критерии.put(4, "Цвет");

        Map<String, Object> параметрыФильтрации = запроситьКритерии(критерии);
        Set<Ноутбук> отфильтрованныеНоутбуки = фильтроватьНоутбуки(ноутбуки, параметрыФильтрации);

        System.out.println("Ноутбуки, соответствующие критериям:");
        for (Ноутбук ноутбук : отфильтрованныеНоутбуки) {
            System.out.println(ноутбук);
        }
    }

    private static Map<String, Object> запроситьКритерии(Map<Integer, String> критерии) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> параметрыФильтрации = new HashMap<>();

        for (Map.Entry<Integer, String> критерий : критерии.entrySet()) {
            System.out.println("Введите минимальное значение для критерия " + критерий.getValue() + ":");
            if (критерий.getKey() == 1 || критерий.getKey() == 2) {
                параметрыФильтрации.put(критерий.getValue(), scanner.nextInt());
            } else {
                параметрыФильтрации.put(критерий.getValue(), scanner.next());
            }
        }

        return параметрыФильтрации;
    }

    private static Set<Ноутбук> фильтроватьНоутбуки(Set<Ноутбук> ноутбуки, Map<String, Object> параметрыФильтрации) {
        Set<Ноутбук> отфильтрованныеНоутбуки = new HashSet<>();

        for (Ноутбук ноутбук : ноутбуки) {
            boolean соответствует = true;

            if (параметрыФильтрации.containsKey("ОЗУ") && ноутбук.getОзу() < (int) параметрыФильтрации.get("ОЗУ")) {
                соответствует = false;
            }
            if (параметрыФильтрации.containsKey("Объем ЖД") && ноутбук.getОбъемЖД() < (int) параметрыФильтрации.get("Объем ЖД")) {
                соответствует = false;
            }
            if (параметрыФильтрации.containsKey("Операционная система") && !ноутбук.getОперационнаяСистема().equalsIgnoreCase((String) параметрыФильтрации.get("Операционная система"))) {
                соответствует = false;
            }
            if (параметрыФильтрации.containsKey("Цвет") && !ноутбук.getЦвет().equalsIgnoreCase((String) параметрыФильтрации.get("Цвет"))) {
                соответствует = false;
            }

            if (соответствует) {
                отфильтрованныеНоутбуки.add(ноутбук);
            }
        }

        return отфильтрованныеНоутбуки;
    }
}

