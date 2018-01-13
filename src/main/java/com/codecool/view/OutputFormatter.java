package com.codecool.view;

import com.codecool.model.CsvContainer;

import java.util.List;

public interface OutputFormatter {
    void printToConsole(CsvContainer csvContainer);
}
