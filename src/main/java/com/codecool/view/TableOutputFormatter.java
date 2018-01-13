package com.codecool.view;

import com.codecool.model.CsvContainer;

import java.util.List;

public class TableOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer csvContainer) {
        System.out.println("print table");
    }
}
