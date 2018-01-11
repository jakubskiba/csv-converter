package com.codecool.view;

import com.codecool.CsvContainer;

public class XmlOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("print xml");
    }
}