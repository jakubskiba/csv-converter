package com.codecool.service;

import com.codecool.model.OutputFormat;
import com.codecool.model.CsvContainer;
import com.codecool.view.OutputFormatter;

import java.io.File;

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

    public void convert(File file) {
        convert(file, OutputFormat.TABLE);
    }

    public void convert(File file, OutputFormat outputFormat) {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        CsvContainer csvContainer = this.fileReader.readData(file);
        outputFormatter.printToConsole(csvContainer);
    }
}
