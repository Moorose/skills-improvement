import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Задача 1
     * Реализовать алгоритм для следующей задачи:
     * Дана строка длины N. Найти длину максимальной подстроки в
     * которой каждый последующий символ больше предыдущего в лексикографическом порядке.
     * Результат:
     * 1. Реализованный алгоритм (ссылка на репозиторий, другое)
     * 2. Провести асимптотический анализ реализованного алгоритма
     **/
    public static void main(String[] args) {

        String str = "абвабг сст икл гдеаб пр абвгеж вг абвг абвгеж";

        Service service = new Service();

        System.out.println("result: " + service.getSubString(str));
    }

}
