package com.codecool.service;

import com.codecool.model.CsvContainer;
import com.codecool.model.CsvRow;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CsvParser {
    private Boolean hasHeader;
    private String delimiter;

    public CsvParser() {
        this(true, ",");
    }

    public CsvParser(Boolean hasHeader, String delimiter) {
        this.hasHeader = hasHeader;
        this.delimiter = delimiter;
    }

    public CsvContainer parse(List<String> lines) {
        CsvContainer csvContainer = new CsvContainer();

        for (int i = 0; i < lines.size(); i++) {
            List<String> splitLine = splitLine(lines.get(i));
            Consumer<List<String>> lineConsumer = this.hasHeader && i == 0 ? csvContainer::setHeaders : csvContainer::createRow;
            lineConsumer.accept(splitLine);
        }

        return csvContainer;
    }

    private List<String> splitLine(String line) {
        return Arrays.asList(line.split(delimiter));
    }


}
