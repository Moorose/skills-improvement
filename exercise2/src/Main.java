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
        Service service = new Service(true);
        String str = "Дан текст. Вывести в алфавитном порядке все слова, содержащие наибольшее количество гласных букв.";

        List<String> result = service.getWords(str);
        System.out.println("result: ");
        for (String s: result) {
            System.out.println(s);
        }
    }
}
