package day2;

import helperFunctions.HelperFunctions;

import java.io.File;
import java.util.List;

public class InventoryManagementSystem {

    HelperFunctions helperFunctions = new HelperFunctions();
    File file = helperFunctions.loadFile("src/day2/boxIDs.txt");
    List<String> boxIDs = helperFunctions.getStringArrayFromFile(file);

    public void scanBoxesForDuplicates() {
        int totalDoubles = countDoubles(boxIDs, 2);
        int totalTriples = countDoubles(boxIDs, 3);
        int checksum = totalDoubles * totalTriples;
        System.out.println("2A) Checksum is: " + checksum);
    }

    public int countDoubles(List<String> boxIDs, int howMany) {
        int boxIDsWithDoubles = 0;
        for (int i = 0; i < boxIDs.size(); i++) {
            if (findDuplicates(boxIDs.get(i), howMany)) {
                boxIDsWithDoubles += 1;
            }
        }
        return boxIDsWithDoubles;
    }

    public boolean findDuplicates(String boxID, int howMany) {
        boolean duplicate = false;
        int occurences;

        for (int i = 0; i < boxID.length(); i++) {
            occurences = 0;
            char character = boxID.charAt(i);
            for (int j = 0; j < boxID.length(); j++) {
                if (boxID.charAt(j) == character) {
                    occurences += 1;
                }
            }
            if (occurences == howMany) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    public void findCommonLetters() {
        int commonCharacters;
        int uncommonCharacters;

        // Pick the string to compare to the rest of the strings
        LOOP:
        for (int i = 0; i < boxIDs.size(); i++) {

            // Loop over all the strings
            for (int j = 0; j < boxIDs.size(); j++) {
                uncommonCharacters = 0;
                commonCharacters = 0;

                // Compare two strings character for character
                for (int k = 0; k < boxIDs.get(i).length(); k++) {

                    if (boxIDs.get(i).charAt(k) == boxIDs.get(j).charAt(k)) {
                        commonCharacters += 1;
                    } else {
                        uncommonCharacters += 1;
                    }
                    if (commonCharacters == 25 && uncommonCharacters == 1) {
                        String finalString = deleteUncommonCharacter(i, j);
                        System.out.println("2B) Common letters between the two correct box IDs: " + finalString);
                        break LOOP;
                    }
                }
            }
        }
    }

    public String deleteUncommonCharacter(int ID1, int ID2) {
        StringBuilder finalString = new StringBuilder(boxIDs.get(ID1));

        // Loop character for character over the two boxIDs
        for (int i = 0; i < boxIDs.get(ID1).length(); i++) {
            if (boxIDs.get(ID1).charAt(i) != boxIDs.get(ID2).charAt(i)) {
                finalString.deleteCharAt(i);
            }
        }

        return finalString.toString();
    }
}
