package com.codecool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

    public List<String[]> parse (List<String> lines) {
        List<String[]> data = new ArrayList<>();

        for(String line : lines) {
            data.add(line.split(delimiter));
        }

        return data;
    }

}
