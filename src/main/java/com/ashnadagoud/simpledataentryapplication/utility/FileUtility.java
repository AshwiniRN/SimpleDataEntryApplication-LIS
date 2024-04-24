package com.ashnadagoud.simpledataentryapplication.utility;

import com.ashnadagoud.simpledataentryapplication.model.DataModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    private static final String COMMA = ",";
    private static final String FILE_PATH = "src/main/resources/data.csv";
    private FileUtility() {}

    //Reads a csv file
    public static List<DataModel> readFile() throws IOException {
        createFileIfMissing();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            List<DataModel> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA);
                DataModel dataModel = new DataModel();
                dataModel.setName(values[0]);
                dataModel.setAge((values[1]));
                dataModel.setTitle(values[2]);
                if(values.length > 3) {
                    dataModel.setHometown(values[3]);
                }
                result.add(dataModel);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds a new record to the csv file
    public static void saveToFile(DataModel newData) throws IOException {
        createFileIfMissing();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(newData.getName() + COMMA +
                    newData.getAge() + COMMA +
                    newData.getTitle() + COMMA +
                    newData.getHometown());
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException("Error while writing to file", e);
        }
    }

    //creates data.csv if the file does not exist
    private static void createFileIfMissing() throws IOException {
        File newFile = new File(FILE_PATH);
        newFile.createNewFile();
    }
}
