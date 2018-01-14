package com.codecool.model;

import java.io.File;

public class ParsedArguments {
    private OutputFormat outputFormat;
    private File file;
    private Boolean hasHeaders;
    private String delimiter;

    public ParsedArguments(OutputFormat outputFormat, File file, Boolean hasHeaders, String delimiter) {
        this.outputFormat = outputFormat;
        this.file = file;
        this.hasHeaders = hasHeaders;
        this.delimiter = delimiter;
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public File getFile() {
        return file;
    }

    public Boolean hasHeaders() {
        return hasHeaders;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
