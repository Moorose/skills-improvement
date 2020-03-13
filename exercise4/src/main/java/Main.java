import directionallist.OneWayList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
//        AddService.writeData();

        MockController controller = new MockController();
        OneWayList<People> people = controller.getPeople();
        OneWayList<String> professions = controller.getProfessions();

        System.out.println(people.toString());
        System.out.println(professions.toString());

    }

}
