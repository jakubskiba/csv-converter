import java.io.File;

public class SimpleCsvConverter {
    public void convert(File file) {
        convert(file, OutputFormat.TABLE);
    }

    public void convert(File file, OutputFormat outputFormat) {
        System.out.println("I convert CSV to output format");
    }
}
