package helperFunctions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelperFunctions {

    public File loadFile(String location) {
        File file = new File(location);
        return file;
    }

    public List getListOfNumbersFromFile(File file) {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public StringBuilder getCharacterStringFromFile(File file) {
        StringBuilder inputString = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            inputString = new StringBuilder(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }

    public List<String> getStringArrayFromFile(File file) {
        List<String> boxIDs = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                boxIDs.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boxIDs;
    }
}
