package com.codecool.model;

import java.util.Arrays;
import java.util.List;

public class CsvRow {
    private List<String> elementList;

    public CsvRow(String[] elements) {
        this(Arrays.asList(elements));
    }

    public CsvRow(List<String> elementList) {
        this.elementList = elementList;
    }

    public List<String> getElementList() {
        return elementList;
    }
}
