import data.DataReader;
import dataparser.DataParser;
import queue.HandmadeQueue;

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
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        HandmadeQueue<Integer> data = dataReader.getData();
        System.out.println(data);
        
    }

}
