package com.ashnadagoud.simpledataentryapplication.controller;

import com.ashnadagoud.simpledataentryapplication.model.DataModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {

    private static final String COMMA_DELIMITER = ",";
    private final String FILE_PATH = "src/main/resources/data.csv";
    private List<DataModel> data = new ArrayList<>();

    @GetMapping("/")
    public String dataEntryForm(Model model){
        model.addAttribute("dataModel", new DataModel());
        return "data-entry";
    }

    @PostMapping("/submit")
    public String submitData(DataModel dataModel, Model model){
        if (dataModel.getName().isEmpty() || dataModel.getTitle().isEmpty() ){
            model.addAttribute("Error", "Name and Title are required");
            return "data-entry";
        }
        data.clear();
        data.add(dataModel);
        saveToFile(data);
        model.addAttribute("dataModel", dataModel);
        // Read all data from the file
        model.addAttribute("data", readFile());
        return "confirmation-page";
    }

    private List<DataModel> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            List<DataModel> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                    DataModel dataModel = new DataModel();
                    dataModel.setName(values[0]);
                    dataModel.setAge(Integer.parseInt(values[1]));
                    dataModel.setTitle(values[2]);
                    dataModel.setHometown(values[3]);
                    result.add(dataModel);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveToFile(List<DataModel> newData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            for (DataModel dataModel : newData) {
                writer.write(dataModel.getName() + COMMA_DELIMITER +
                        dataModel.getAge() + COMMA_DELIMITER +
                        dataModel.getTitle() + COMMA_DELIMITER +
                        dataModel.getHometown());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while writing to file", e);
        }
    }
}
