package day5;

import helperFunctions.HelperFunctions;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlchemicalReduction {

    HelperFunctions helperFunctions = new HelperFunctions();
    File polymer = helperFunctions.loadFile("src/day5/polymer.txt");
    StringBuilder unitTypes = helperFunctions.getCharacterStringFromFile(polymer);
    List<Integer> scanOutcomes = new ArrayList<>();

    public void scanOnePolymer() {
        scanOutcomes.clear();
        scanPolymer(unitTypes);
        System.out.println("5A) Remaining units after all reactions: " + unitTypes.length());
    }

    public void scanPolymer(StringBuilder specificUnits) {
        boolean anotherIteration = true;

        while(anotherIteration) {
            int reactions = 0;
            for (int i = 0; i < specificUnits.length() - 1; i++) {
                int firstType = specificUnits.charAt(i);
                int secondType = specificUnits.charAt(i + 1);

                if (Math.abs(firstType - secondType) == 32) {
                    specificUnits.delete(i, (i + 2));
                    reactions += 1;
                }
                if (i == specificUnits.length() - 2) {
                    if (reactions == 0) {
                        anotherIteration = false;
                    }
                }
            }
        }
        scanOutcomes.add(specificUnits.length());
    }

    public void findShortestPolymer() {
        scanOutcomes.clear();
        for (int i = 65; i <= 90; i++) {
            removeSpecificUnitAndScan(i);
        }
        System.out.println("5B) Length of the shortest polymer: " + Collections.min(scanOutcomes));
    }

    public void removeSpecificUnitAndScan(int unit) {
        StringBuilder specificUnits = new StringBuilder(unitTypes);
        for (int i = 0; i < specificUnits.length(); i++) {
            int type = specificUnits.charAt(i);
            if (type == unit | type == (unit+32)) {
                specificUnits.deleteCharAt(i);
                i -= 1;
            }
        }
        scanPolymer(specificUnits);
    }
}
