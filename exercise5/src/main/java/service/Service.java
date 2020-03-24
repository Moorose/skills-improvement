package service;

import queue.HandmadeQueue;

import java.util.function.Predicate;

public class Service {


    public String getOutputData(HandmadeQueue<Integer> data, int n) {
        StringBuffer output = new StringBuffer();
        Integer number = null;
        Predicate<Integer> predicate = x -> x < n;
        while ((number = data.getByCriteria(predicate)) != null) {
            output.append(number);
            output.append(' ');
        }
            output.append("|");
        while ((number = data.pop()) != null) {
            output.append(' ');
            output.append(number);
        }
        return output.toString();
    }

}
