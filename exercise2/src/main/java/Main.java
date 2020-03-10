import java.util.List;

public class Main {

/**
    Задача 2
  Реализовать алгоритм для следующей задачи:
  Дан текст. Вывести в алфавитном порядке все слова, содержащие наибольшее количество гласных букв.
  Результат:
    1. Реализованный алгоритм (ссылка на репозиторий, другое)
    2. Провести асимптотический анализ реализованного алгоритма
* */

    public static void main(String[] args) {
        Service service = new Service();
        String str1 = "Дан текст. Вывести в алфавитном порядке все слова, содержащие наибольшее количество гласных букв.";
        String str2= "a aa aaa aaaa aaaaa";
        String str3 = "aaaaa aaaa aaa aa a";
        String str4 = "";

        System.out.println("result 1: ");
        service.getWords(str1).forEach(System.out::println);
        System.out.println("result 2: ");
        service.getWords(str2).forEach(System.out::println);
        System.out.println("result 3: ");
        service.getWords(str3).forEach(System.out::println);
        System.out.println("result 4: ");
        service.getWords(str4).forEach(System.out::println);
    }
}
