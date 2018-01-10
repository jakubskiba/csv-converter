import java.io.File;
import java.util.Arrays;

public class ConverterApplication {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No input file defined!");
        } else {
            ParsedArguments parsedArguments = parseArgs(args);
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
