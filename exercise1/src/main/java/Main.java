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

        // Данный алгоритм имеет линейную сложность О(n)
        // т.к. при любых входных данных агоритмом будет произведен
        // полный перебор

        String str1 = "абвабг сст икл гдеаб пр абвгеж вг абвг абвгеж";
        String str2 = "ббббббббббб ааааа ааа аа а";
        String str3 = "ааа ббббббббббб аааа";
        String str4 = "ааааа ааа аа ббббббббббббб";
        String str5 = " ааааа ааа аа ббббббббббб бб  ";

        Service service = new Service();

        System.out.println("result: " + service.getSubString(str1));
        System.out.println("result: " + service.getSubString(str2));
        System.out.println("result: " + service.getSubString(str3));
        System.out.println("result: " + service.getSubString(str4));
        System.out.println("result: " + service.getSubString(str5));
    }

}
