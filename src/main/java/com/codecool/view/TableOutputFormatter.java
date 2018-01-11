package view;

import view.OutputFormatter;

public class TableOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("print table");
    }
}
