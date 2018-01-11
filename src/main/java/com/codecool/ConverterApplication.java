package com.codecool;

import com.codecool.model.OutputFormat;
import com.codecool.model.ParsedArguments;
import com.codecool.service.FileReader;
import com.codecool.service.OutputFormatterFactory;
import com.codecool.service.SimpleCsvConverter;

import java.io.File;

public class ConverterApplication {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No input file defined!");
        } else {
            ParsedArguments parsedArguments = parseArgs(args);
            SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(new FileReader(), new OutputFormatterFactory());
            simpleCsvConverter.convert(parsedArguments.getFile(), parsedArguments.getOutputFormat());
        }

    }

    private static ParsedArguments parseArgs(String[] args) {
        if (args.length == 1) {
            return new ParsedArguments(OutputFormat.TABLE, getFile(args[0]));
        } else {
            return new ParsedArguments(getOutputFormat(args[0]), getFile(args[1]));
        }
    }

    private static OutputFormat getOutputFormat(String outputFormat) {
        return OutputFormat.valueOf(outputFormat.toUpperCase());
    }

    private static File getFile(String filePath) {
        return new File(filePath);
    }
}
