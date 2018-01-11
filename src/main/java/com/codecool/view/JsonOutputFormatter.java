package view;

public class JsonOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("print json");
    }
}