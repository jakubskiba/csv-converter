package com.codecool.service;

import com.codecool.model.CsvContainer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    public CsvContainer parse (List<String> lines) {
        List<String> headers = new LinkedList<>();
        List<String[]> rows = new LinkedList<>();
        Iterator<String> iterator = lines.iterator();

        if(hasHeader) {
            headers = Arrays.asList(iterator.next().split(delimiter));
        }

        iterator.forEachRemaining(line -> rows.add(line.split(delimiter)));

        return new CsvContainer(rows, headers);
    }


}
