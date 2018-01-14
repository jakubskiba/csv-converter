package com.codecool.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<String> lines;
    public List<String> readData(File file) throws FileNotFoundException {
        this.lines = new LinkedList<>();
        if (file.exists() && file.canRead()) {
            loadLines(new Scanner(file));
        } else {
            throw new FileNotFoundException("File not found: " + file.getPath());
        }

        return this.lines;
    }

    private void loadLines(Scanner scanner) {
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
    }
}
