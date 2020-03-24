package data;

import dataparser.DataParser;
import queue.HandmadeQueue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {

    public List<HandmadeQueue<Integer>> getData() {
        List<HandmadeQueue<Integer>> handmadeQueues = new ArrayList<>();
        File filePath = new File("./exercise5/res/numbers.txt");

        String readString = DataParser.readString(filePath);
        String[] strings = readString.split("\n");
        for (String string : strings) {
            String[] numbersStr = string.split(" ");
            HandmadeQueue<Integer> numbers = new HandmadeQueue<>();
            Arrays.stream(numbersStr)
                    .map(Integer::parseInt)
                    .forEach(numbers::push);
            handmadeQueues.add(numbers);
        }
        return handmadeQueues;
    }

}
