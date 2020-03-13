import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * Задача 3
     * Реализовать алгоритм для следующей задачи:
     * Дана строка длины N. Найти подстроку-палиндром с максимальной длиной.
     * Результат:
     * 1. Реализованный алгоритм (ссылка на репозиторий, другое)
     * 2. Провести асимптотический анализ реализованного алгоритма
     */
    public static void main(String[] args) {

        Service serviceWithTrim = new Service(true);
        Service serviceWithoutTrim = new Service(false);
        List<String> data1 = new ArrayList();
        List<String> data2 = new ArrayList();

        data1.add("Мёд - сладкий вязкий продукт. Мед я - как яд ем. Пчелиный мёд представляет собой частично переваренный нектар.");

        data2.add("");
        data2.add("(***-%--+&+&+--%-***)");
        data2.add("продуктмедякакядемпчелиныймёд");
        data2.add("абвба");
        data2.add("абввба");
        data2.add("123321");
        data2.add("12321");

        System.out.println("serviceWithTrim");
        data1.stream().map(serviceWithTrim::getPalindrome).forEach(System.out::println);
        System.out.println("serviceWithoutTrim");
        data2.stream().map(serviceWithoutTrim::getPalindrome).forEach(System.out::println);
    }
}
