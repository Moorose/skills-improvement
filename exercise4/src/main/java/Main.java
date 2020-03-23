import data.MockController;
import data.TestData;
import dataparser.DataParser;
import directionallist.OneWayList;
import service.People;
import service.Service;

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
//        data.AddService.writeData();

        MockController controller = new MockController();
        OneWayList<People> people = controller.getPeople();
        OneWayList<String> professions = controller.getProfessions();

        Service service = new Service();

        OneWayList<People> peopleOneWayList = service.clearListByProf(people, professions);
        System.out.println(peopleOneWayList.toString());
    }

}
