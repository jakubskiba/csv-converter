package com.codecool.view;

import java.util.List;

public class JsonOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(List<String[]> data) {
        System.out.println("print json");
    }
}