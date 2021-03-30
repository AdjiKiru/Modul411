package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    public static List<List<String>> loadFromCSV(String filepath) throws IOException {
        List<List<String>> arrayList = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = in.readLine()) != null) {
                String[] values = line.split(";");
                arrayList.add(Arrays.asList(values));
            }
        }
        return arrayList;
    }
    public static String[][] loadFromCSV2D(String filepath) throws IOException {
        List<List<String>> arrayList = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = in.readLine()) != null) {
                String[] values = line.split(";");
                arrayList.add(Arrays.asList(values));
            }
        }

        String[][] array = new String[arrayList.size()][];
        for(int i = 0; i < arrayList.size(); i++){
            List<String> row = arrayList.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        //TODO Auto-generated method stub
        String filepath = "./test.csv";
        //Array
        List<List<String>> test = loadFromCSV(filepath);
        System.out.println(test);

        //2D Array
        String[][] test2D = loadFromCSV2D(filepath);
        for(int i = 0; i < test2D.length; i++){
            for(int j = 0; j < test2D[i].length; j++){
                System.out.println(test2D[i][j]);
            }
            System.out.println();
        }
    }
}
