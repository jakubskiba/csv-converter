package com.codecool.view;

import com.codecool.model.CsvContainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TableOutputFormatter implements OutputFormatter {
    private String horizontalLine;
    private String verticalLine;

    public TableOutputFormatter() {
        this("▬", "▮");
    }

    public TableOutputFormatter(String horizontalLine, String verticalLine) {
        this.horizontalLine = horizontalLine;
        this.verticalLine = verticalLine;
    }

    @Override
    public void printToConsole(CsvContainer csvContainer) {
        Boolean hasHeaders = csvContainer.getHeaders().size() > 0;

        Integer cellAmount = hasHeaders ? csvContainer.getHeaders().size() : csvContainer.getRows().get(0).length;

        Integer cellWidth = csvContainer.getRows().stream()
                                                    .mapToInt(this::findMaxLength)
                                                    .max()
                                                    .getAsInt();

        Integer lineWidth = cellWidth * cellAmount + cellAmount;

        printSeparator(lineWidth);
        if(hasHeaders){
            printRow(csvContainer.getHeaders(), cellWidth);
            printSeparator(lineWidth);
        }

        for(String[] row : csvContainer.getRows()) {
            printRow(Arrays.asList(row), cellWidth);
        }

        printSeparator(lineWidth);
    }

    private void printSeparator(int size) {
        System.out.print(verticalLine);
        for (int i = 0; i < size - 1; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(verticalLine);
    }

    private void printRow(List<String> row, Integer cellSize) {
        System.out.print(verticalLine);
        System.out.print(row.stream()
                .map(element -> String.format("%" + cellSize +"s", element))
                .collect(Collectors.joining(verticalLine)));
        System.out.println(verticalLine);
    }

    private Integer findMaxLength(String[] row) {
        Integer max = 0;
        for(String element : row) {
            if(element.length() > max) {
                max = element.length();
            }
        }

        return max;
    }
}
