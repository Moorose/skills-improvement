import data.DataReader;
import dataparser.DataParser;
import queue.HandmadeQueue;
import service.Service;

import java.io.File;
import java.util.List;

public class Main {
    /**
     * Реализовать структуру данных - очередь.
     * Методы очереди:
     * - Добавление в очередь
     * - Удаление из очереди
     * - Поиск по критерию
     * Решаемая задача:
     * Имеется файл действительных чисел и некоторое число N. Используя очередь,
     * вывести в output сначала все элементы,
     * строго меньшие числа N, а затем все остальные элементы.
     * Результат:
     * 1. Реализованная структура данных и алгоритм решения задачи
     * 2. Провести асимптотический анализ реализованного алгоритма
     **/

    static final int N = 10;

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        List<HandmadeQueue<Integer>> data = dataReader.getData();

        Service service = new Service();

        data.forEach(d -> {
            System.out.println(d);
            String output = service.getOutputData(d, N);
            System.out.println(output);
            System.out.println();
        });

    }

}
