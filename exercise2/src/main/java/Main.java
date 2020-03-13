import java.util.ArrayList;
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

        // O(LN + N + KN^2)= O(N(L+1+KN))=O(N(L+KN))
        // Пусть L и K не существенны для сложности алгоритма
        // Тогда сложность данного алгоритма
        // O(N(L+KN))=O(N^2)

        Service service = new Service();
        ArrayList<String> data = new ArrayList<>();
        // осторожней с раскладкой
        data.add("Дан текст. Вывести в алфавитном порядке все слова, содержащие наибольшее количество гласных букв.");
        data.add("град рад огонь дом лад агат кот заря кара лом мор");
        data.add("анализ");
        data.add("ааааа ааа аа а");
        data.add("а аа ааа ааааа");

        data.forEach(t -> {
            System.out.println("Data: " + t);
            System.out.print("result: ");
            service.getWords(t).forEach(k -> System.out.print(k + " "));
            System.out.println();
        });
    }
}
