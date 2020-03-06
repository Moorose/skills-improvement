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
        String palindrome = "Мёд - сладкий вязкий продукт, который вырабатывают пчёлы и родственные насекомые. Мед я - как яд ем. Пчелиный мёд представляет собой частично переваренный в зобе медоносной пчелы нектар.";

        Service service = new Service(false);
        System.out.println(service.getPalindrome(palindrome));

        List<String> data = new ArrayList();

        data.add("абввба");
        data.add("абвба");
        data.add("фывафвыафыва");
        data.add("123321");
        data.add("12321");
        data.add("123456798739");
        data.add("aaaaa");
        data.add("абв123321вба");
        data.add("абв12321вба");
        data.add("а1б2в3в2б1а");

        data.stream().map(service::getPalindrome).forEach(System.out::println);
    }
}
