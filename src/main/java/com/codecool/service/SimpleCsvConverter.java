package com.codecool.service;

import com.codecool.exceptions.ArgumentsSyntaxException;
import com.codecool.model.CsvContainer;
import com.codecool.model.ParsedArguments;
import com.codecool.view.OutputFormatter;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleCsvConverter {
    private FileReader fileReader;
    private OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(ParsedArguments parsedArguments) throws FileNotFoundException, ArgumentsSyntaxException {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(parsedArguments.getOutputFormat());

        List<String> lines = fileReader.readData(parsedArguments.getFile());

        CsvContainer csvContainer = parse(lines, parsedArguments.hasHeaders(), parsedArguments.getDelimiter());

        outputFormatter.printToConsole(csvContainer);
    }

    public CsvContainer parse (List<String> lines, Boolean hasHeaders, String delimiter) {
        List<String> headers = new LinkedList<>();
        List<String[]> rows = new LinkedList<>();
        Iterator<String> iterator = lines.iterator();

        if(hasHeaders) {
            headers = Arrays.asList(iterator.next().split(delimiter));
        }

        iterator.forEachRemaining(line -> rows.add(line.split(delimiter)));

        return new CsvContainer(rows, headers);
    }
}
