package com.codecool.view;

import com.codecool.model.CsvContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class XmlOutputFormatter implements OutputFormatter {
    private String defaultRowName;
    private String defaultElementName;
    public XmlOutputFormatter() {
        this("row", "element");
    }

    public XmlOutputFormatter(String defaultRowName, String defaultElementName) {
        this.defaultRowName = defaultRowName;
        this.defaultElementName = defaultElementName;
    }

    @Override
    public void printToConsole(CsvContainer data) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        String xmlRoot;
        if(data.getHeaders().size() > 0) {
            xmlRoot = generateXmlRows(data.getRows(), data.getHeaders());
        } else {
            xmlRoot = generateXmlRows(data.getRows());
        }
        System.out.println(generateTag("rows", xmlRoot, 0));

    }

    private String generateXmlRows(List<String[]> rows) {
        return rows.stream()
                    .map(this::generateRow)
                    .map(xmlRow -> generateTag(defaultRowName, xmlRow, 1))
                    .collect(Collectors.joining());
    }

    private String generateXmlRows(List<String[]> rows, List<String> headers) {
        return rows.stream()
            .map(element -> generateRow(element, headers))
            .map(xmlRow -> generateTag(defaultRowName, xmlRow, 1))
            .collect(Collectors.joining());
    }


    private String generateRow(String[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String element : elements) {
            stringBuilder.append(generateTag(defaultElementName, element, 2));
        }
        return stringBuilder.toString();
    }

    private String generateRow(String[] elements, List<String> headers) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator headersIterator = headers.iterator();
        for(String element : elements) {
            String name = headersIterator.hasNext() ? headersIterator.next().toString() : defaultElementName;
            stringBuilder.append(generateTag(name, element, 2));
        }
        return stringBuilder.toString();
    }

    private String generateTag(String name, String content, Integer indentLevel) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(generateIndent(indentLevel));
        stringBuilder.append("<");
        stringBuilder.append(name);
        stringBuilder.append(">");

        stringBuilder.append(generateIndent(indentLevel+1));
        stringBuilder.append(content);

        stringBuilder.append(generateIndent(indentLevel));
        stringBuilder.append("</");
        stringBuilder.append(name);
        stringBuilder.append(">");

        return stringBuilder.toString();
    }

    public String generateIndent(Integer indentLevel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for(int i = 0; i < indentLevel; i++){
            stringBuilder.append("\t");
        }

        return stringBuilder.toString();
    }
}