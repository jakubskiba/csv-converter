package com.codecool.service;

import com.codecool.exceptions.InvalidArgumentsSyntaxException;
import com.codecool.model.OutputFormat;
import com.codecool.model.ParsedArguments;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArgumentParser {
    public ParsedArguments parseArgs(List<String> args) throws InvalidArgumentsSyntaxException {
        OutputFormat outputFormat;
        File file;
        List<String> otherArguments;
        Boolean hasHeaders;
        String delimiter;

        switch (args.size()) {
            case 0:
                throw new InvalidArgumentsSyntaxException("No input file defined!");
            case 1:
                outputFormat = OutputFormat.TABLE;
                file = getFile(args.get(0));
                otherArguments = new ArrayList<>();
                break;
            default:
                outputFormat = getOutputFormat(args.get(0));
                file = getFile(args.get(1));
                otherArguments = args.subList(1, args.size());
                break;
        }

        hasHeaders = hasFlag(otherArguments, "-headers");
        delimiter = ",";

        return new ParsedArguments(outputFormat, file, hasHeaders, delimiter);
    }

    private OutputFormat getOutputFormat(String outputFormat) {
        return OutputFormat.valueOf(outputFormat.toUpperCase());
    }

    private File getFile(String filePath) {
        return new File(filePath);
    }

    private boolean hasFlag(List<String> arguments, String flag) {
        return arguments.stream()
                        .filter(argument -> argument.equals(flag))
                        .findAny()
                        .isPresent();
    }
}
