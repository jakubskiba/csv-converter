package view;

import view.OutputFormatter;

public class XmlOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("print xml");
    }
}