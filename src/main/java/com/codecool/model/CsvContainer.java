package com.codecool.model;

import java.util.List;

public class CsvContainer {
    private List<String[]> rows;
    private List<String> headers;

    public CsvContainer(List<String[]> rows, List<String> headers) {
        this.rows = rows;
        this.headers = headers;
    }

    public List<String[]> getRows() {
        return rows;
    }

    public List<String> getHeaders() {
        return headers;
    }
}
