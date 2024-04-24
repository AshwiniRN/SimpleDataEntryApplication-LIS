package com.ashnadagoud.simpledataentryapplication.controller;

import com.ashnadagoud.simpledataentryapplication.model.DataModel;
import com.ashnadagoud.simpledataentryapplication.utility.FileUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;
@Controller
public class DataController {

    //Home page with data entry form
    @GetMapping("/")
    public String dataEntryForm(Model model){
        model.addAttribute("dataModel", new DataModel());
        return "data-entry";
    }

    //Page to view the entered records
    @PostMapping("/submit")
    public String submitData(@ModelAttribute DataModel dataModel, Model model) throws IOException {
        List<DataModel> prevRecords = FileUtility.readFile();
        model.addAttribute("data", prevRecords);
        FileUtility.saveToFile(dataModel);
        model.addAttribute("dataModel", dataModel);
        return "confirmation-page";
    }
}
