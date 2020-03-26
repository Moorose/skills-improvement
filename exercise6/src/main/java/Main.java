import dataparser.DataParser;
import setofstacks.SetOfStacks;
import setofstacks.Stack;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /**
     * Реализовать структуру данных SetOfStacks.
     * Решаемая задача:
     * Слишком высокая стопка тарелок может развалиться. Следовательно, в реальной жизни, когда высота стопки превысила
     * бы некоторое пороговое значение, мы начали бы складывать тарелки в новую стопку. Реализовать структуру
     * SetOfStacks, имитирующую реальную ситуацию. Она должна состоять из нескольких стеков, новый стек создается, как
     * только предыдущий достигнет порогового значения. Методы push() и pop() должны вести себя так же, как при работе
     * с одним стеком (то есть метод pop() должен возвращать те же значения, которые бы он возвращал при использовании
     * одного большого стека). Реализуйте функцию popAt(int index), которая осуществляет операцию pop c заданным
     * внутренним стеком.
     * Результат:
     * 1. Реализованная структура данных и алгоритм решения задачи
     * 2. Провести асимптотический анализ реализованного алгоритма
     **/
    public static void main(String[] args) {
        int stackSize = 10, setSize = 100;
        File filePath = new File("./exercise6/res/numbers.txt");
        String readString = DataParser.readString(filePath);
        String[] string = readString.replace("\n", "").split(" ");

        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(stackSize, setSize);

        Arrays.stream(string)
                .map(Integer::parseInt)
                .forEach(setOfStacks::push);

        ArrayList<Integer> popAtNumber = new ArrayList<>();
        ArrayList<Integer> popNumber= new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            popNumber.add(setOfStacks.pop());
            popAtNumber.add(setOfStacks.popAt(0));
        }
        System.out.println(popNumber);
        System.out.println(popAtNumber);
    }

}
