import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    /**
     * Реализовать структуру данных - однонаправленный список.
     * Методы списка:
     * - Сравнение значений списка
     * - Удаление из списка
     * - Добавление в список
     * Решаемая задача:
     * В списке A хранится информация о людях (фамилия, имя, отчество, профессия). Имеется список В, содержащий
     * перечень профессий. Удалить из списка А тех людей, чья профессия не указана в списке В.
     * Результат:
     * 1. Реализованная структура данных и алгоритм решения задачи
     * 2. Провести асимптотический анализ реализованного алгоритма
     **/
    public static void main(String[] args) throws IOException {
        File filePath = new File("./exercise4/res/testdata.json");

        TestData testData = new TestData("Alexey", "Blagoy");

        DataParser<TestData> dataParser = new DataParser();
        dataParser.writeData(filePath, testData);
        TestData response = dataParser.readData(filePath, TestData.class);
        System.out.println(response);

    }

}
