package com.codecool.view;

import com.codecool.CsvContainer;

public class JsonOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("print json");
    }
}