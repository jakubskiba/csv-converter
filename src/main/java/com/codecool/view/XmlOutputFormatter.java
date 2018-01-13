package com.codecool.view;

import com.codecool.model.CsvContainer;

import java.util.List;

public class XmlOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("print xml");
    }
}