package com.codecool.view;

import com.codecool.model.CsvContainer;

import java.util.List;

public class JsonOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(CsvContainer csvContainer) {
        List<String[]> rows =  csvContainer.getRows();
        List<String> headers = csvContainer.getHeaders();
        String json;
        if (headers.size() == 0) {
            json = getArrayOfArrays(rows);
        } else {
            json = getArrayOfObject(rows, headers);
        }
        System.out.println(json);
    }

    private String getArrayOfObject(List<String[]> rows, List<String> headers) {
        return generateArray(rows.stream()
                .map(row -> generateObject(row, headers))
                .toArray(String[]::new));
    }

    private String getArrayOfArrays(List<String[]> rows) {
        return generateArray(rows.stream()
                .map(row -> generateArray(row))
                .toArray(String[]::new));
    }

    private String generateArray(String[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < elements.length; i++) {
            stringBuilder.append(getValue(elements[i]));
            if (i < elements.length - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private String generateObject(String[] elements, List<String> headers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (int i = 0; i < elements.length; i++) {
            if(headers.size() > i) {
                stringBuilder.append(getValue(headers.get(i)));
            } else {
                stringBuilder.append(getValue(String.valueOf(i)));
            }
            stringBuilder.append(": ");
            stringBuilder.append(getValue(elements[i]));
            if (i < elements.length - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private String generateString(String value) {
        return "\"" + value + "\"";
    }

    private boolean isObject(String value) {
        return (value.length() >= 2 &&value.charAt(0) == '{' && value.charAt(value.length() - 1) == '}');
    }

    private boolean isArray(String value) {
        return (value.length() >= 2 &&value.charAt(0) == '[' && value.charAt(value.length() - 1) == ']');
    }

    private boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isNull(String value) {
        return value.isEmpty() || value.equalsIgnoreCase("null");
    }

    private boolean isTrue(String value) {
        return value.equalsIgnoreCase("true");
    }

    private boolean isFalse(String value) {
        return value.equalsIgnoreCase("false");
    }

    private String getValue(String element) {
        if (isArray(element) || isObject(element) || isTrue(element) ||
                isFalse(element) || isNumber(element)) {
            return element;
        } else if (isNull(element)) {
            return "null";
        } else {
            return generateString(element);
        }
    }


}