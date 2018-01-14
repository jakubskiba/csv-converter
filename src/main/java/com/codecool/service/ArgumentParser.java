package com.codecool.service;

import com.codecool.exceptions.InvalidArgumentsSyntaxException;
import com.codecool.model.OutputFormat;
import com.codecool.model.ParsedArguments;

import java.io.File;
import java.util.List;

public class ArgumentParser {
    private final String DEFAULT_DELIMITER = ",";

    public ParsedArguments parseArgs(List<String> args) throws InvalidArgumentsSyntaxException {
        OutputFormat outputFormat;
        File file;
        Boolean hasHeaders;
        String delimiter;

        switch (args.size()) {
            case 0:
                throw new InvalidArgumentsSyntaxException("No input file defined!");
            case 1:
                outputFormat = OutputFormat.TABLE;
                file = getFile(args.get(0));
                break;
            default:
                outputFormat = getOutputFormat(args.get(0));
                file = getFile(args.get(1));
                break;
        }

        hasHeaders = args.indexOf("-headers") > 0;

        delimiter = DEFAULT_DELIMITER;
        Integer indexOfDelimiterFlag = args.indexOf("-delimiter");
        if(indexOfDelimiterFlag > 0 && args.size() >= indexOfDelimiterFlag + 1) {
            delimiter = args.get(indexOfDelimiterFlag + 1);
        }

        return new ParsedArguments(outputFormat, file, hasHeaders, delimiter);
    }

    private OutputFormat getOutputFormat(String outputFormat) {
        return OutputFormat.valueOf(outputFormat.toUpperCase());
    }

    private File getFile(String filePath) {
        return new File(filePath);
    }

}
