import java.io.File;

public class ParsedArguments {
    OutputFormat outputFormat;
    File file;

    public ParsedArguments(OutputFormat outputFormat, File file) {
        this.outputFormat = outputFormat;
        this.file = file;
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public File getFile() {
        return file;
    }

}
