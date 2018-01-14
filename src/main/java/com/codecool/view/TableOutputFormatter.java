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
        Integer cellAmount = getCellAmount(csvContainer);
        Integer cellWidth = getCellWidth(csvContainer);
        Integer lineWidth = cellWidth * cellAmount + cellAmount;

        printSeparator(lineWidth);

        printHeader(csvContainer, cellWidth, lineWidth);
        printRows(csvContainer, cellWidth);

        printSeparator(lineWidth);
    }

    private void printRows(CsvContainer csvContainer, Integer cellWidth) {
        for(String[] row : csvContainer.getRows()) {
            printRow(Arrays.asList(row), cellWidth);
        }
    }

    private void printHeader(CsvContainer csvContainer, Integer cellWidth, Integer lineWidth) {
        Boolean hasHeaders = csvContainer.getHeaders().size() > 0;
        if(hasHeaders){
            printRow(csvContainer.getHeaders(), cellWidth);
            printSeparator(lineWidth);
        }
    }

    private Integer getCellWidth(CsvContainer csvContainer) {
        return csvContainer.getRows().stream()
                                    .mapToInt(this::findMaxLength)
                                    .max()
                                    .getAsInt();
    }

    private Integer getCellAmount(CsvContainer csvContainer) {
        Boolean hasHeaders = csvContainer.getHeaders().size() > 0;
        return hasHeaders ? csvContainer.getHeaders().size() : csvContainer.getRows().get(0).length;
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
