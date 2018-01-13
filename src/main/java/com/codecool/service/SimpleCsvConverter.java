package com.codecool.service;

import com.codecool.model.OutputFormat;
import com.codecool.view.OutputFormatter;

import java.io.File;
import java.io.IOException;
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

    public void convert(File file) {
        convert(file, OutputFormat.TABLE);
    }

    public void convert(File file, OutputFormat outputFormat) {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        try {
            List<String[]> data = this.fileReader.readData(file);
            outputFormatter.printToConsole(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
