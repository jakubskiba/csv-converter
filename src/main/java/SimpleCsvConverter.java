import java.io.File;

public class SimpleCsvConverter {
    private FileReader fileReader;

    public SimpleCsvConverter(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void convert(File file) {
        convert(file, OutputFormat.TABLE);
    }

    public void convert(File file, OutputFormat outputFormat) {
        System.out.println("I convert CSV to output format");
    }
}
