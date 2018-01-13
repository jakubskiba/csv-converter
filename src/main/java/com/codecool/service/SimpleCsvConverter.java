package com.codecool.service;

import com.codecool.model.CsvContainer;
import com.codecool.model.OutputFormat;
import com.codecool.model.ParsedArguments;
import com.codecool.view.OutputFormatter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleCsvConverter {
    private FileReader fileReader;
    private OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void convert(ParsedArguments parsedArguments) throws IOException {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(parsedArguments.getOutputFormat());
        Boolean hasHeaders = parsedArguments.getOthersArguments().contains("-headers");
        CsvParser csvParser = new CsvParser(hasHeaders, ",");
        CsvContainer csvContainer = csvParser.parse(fileReader.readData(parsedArguments.getFile()));
        outputFormatter.printToConsole(csvContainer);
    }
}
