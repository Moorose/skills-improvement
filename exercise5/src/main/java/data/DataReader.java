package data;

import dataparser.DataParser;
import queue.HandmadeQueue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DataReader {

    public HandmadeQueue<Integer> getData() {
        File filePath = new File("./exercise5/res/numbers.txt");

        String readString = DataParser.readString(filePath);
        String[] numbersStr = readString.split(" ");
        HandmadeQueue<Integer> numbers = new HandmadeQueue<>();
        Arrays.stream(numbersStr)
                .map(Integer::parseInt)
                .forEach(numbers::push);
        return numbers;
    }

}
