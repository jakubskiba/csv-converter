package com.codecool.model;

import java.util.LinkedList;
import java.util.List;

public class CsvContainer {
    private List<CsvRow> rows;
    private List<String> headers;

    public CsvContainer() {
        this.rows = new LinkedList<>();
        this.headers = new LinkedList<>();
    }

    public List<CsvRow> getRows() {
        return rows;
    }

    public void createRow(List<String> rowElements) {
        this.rows.add(new CsvRow(rowElements));
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }
}
