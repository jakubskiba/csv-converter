package com.codecool;

import com.codecool.model.OutputFormat;
import com.codecool.model.ParsedArguments;
import com.codecool.service.FileReader;
import com.codecool.service.OutputFormatterFactory;
import com.codecool.service.SimpleCsvConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterApplication {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No input file defined!");
        } else {
            ParsedArguments parsedArguments = parseArgs(Arrays.asList(args));
            SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(new FileReader(), new OutputFormatterFactory());
            try {
                simpleCsvConverter.convert(parsedArguments);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static ParsedArguments parseArgs(List<String> args) {
        if (args.size() == 1) {
            return new ParsedArguments(OutputFormat.TABLE, getFile(args.get(0)), new ArrayList<>());
        } else {
            return new ParsedArguments(getOutputFormat(args.get(0)), getFile(args.get(1)), args.subList(1, args.size()));
        }
    }

    private static OutputFormat getOutputFormat(String outputFormat) {
        return OutputFormat.valueOf(outputFormat.toUpperCase());
    }

    private static File getFile(String filePath) {
        return new File(filePath);
    }
}
