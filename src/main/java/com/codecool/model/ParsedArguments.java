package com.codecool.model;

import java.io.File;
import java.util.List;

public class ParsedArguments {
    private OutputFormat outputFormat;
    private File file;
    private List<String> othersArguments;

    public ParsedArguments(OutputFormat outputFormat, File file, List<String> othersArguments) {
        this.outputFormat = outputFormat;
        this.file = file;
        this.othersArguments = othersArguments;
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public File getFile() {
        return file;
    }

    public List<String> getOthersArguments() {
        return othersArguments;
    }
}
