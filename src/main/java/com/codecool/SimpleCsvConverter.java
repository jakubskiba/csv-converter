package com.codecool;

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
        this.outputFormatterFactory.createByFormat(outputFormat);
        System.out.println("I convert CSV to output format");
    }
}
