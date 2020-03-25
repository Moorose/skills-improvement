package service;

import queue.HandmadeQueue;

import java.util.function.Predicate;

public class Service {


    public String getOutputData(HandmadeQueue<Integer> data, int n) {   // O(2n^2)=>O(n^2)
        StringBuffer output = new StringBuffer();
        Integer number = null;
        Predicate<Integer> predicate = x -> x < n;
        while ((number = data.getByCriteria(predicate)) != null) {  // O(n*n)
            output.append(number);
            output.append(' ');
        }
            output.append("|");
        while ((number = data.pop()) != null) { // O(n*n)
            output.append(' ');
            output.append(number);
        }
        return output.toString();
    }

}
