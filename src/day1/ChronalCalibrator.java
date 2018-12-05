package day1;

import helperFunctions.HelperFunctions;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChronalCalibrator {

    HelperFunctions helperFunctions = new HelperFunctions();
    File iterations = helperFunctions.loadFile("src/day1/iterations.txt");
    List<Integer> iterationList = helperFunctions.getListOfNumbersFromFile(iterations);

    public void frequencyAfterFirstLoopOfIterations() {
        int frequency = 0;
        for (int i = 0; i < iterationList.size(); i++) {
            frequency += iterationList.get(i);
        }
        System.out.println("1A) Frequency after first loop of iterations: " + frequency);
    }

    public void findFirstDuplicate() {
        int frequency = 0;
        final Set<Integer> set = new HashSet<>();
        boolean noDuplicateNumbers = true;

        while (noDuplicateNumbers) {
            for (int i = 0; i < iterationList.size(); i++) {
                frequency += iterationList.get(i);
                if (!set.add(frequency)) { // the add method of set returns false if a value already exists
                    noDuplicateNumbers = false;
                    System.out.println("1B) First duplicate: " + frequency);
                    break;
                }
            }
        }
    }
}
