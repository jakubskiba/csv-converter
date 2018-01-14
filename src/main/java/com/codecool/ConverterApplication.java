package com.codecool;

import com.codecool.exceptions.ArgumentsSyntaxException;
import com.codecool.model.ParsedArguments;
import com.codecool.service.ArgumentParser;
import com.codecool.service.SimpleCsvConverter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class ConverterApplication {
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("sccContext.xml");

            ArgumentParser argumentParser = (ArgumentParser) ctx.getBean("argumentParser");
            ParsedArguments parsedArguments = argumentParser.parseArgs(Arrays.asList(args));

            SimpleCsvConverter simpleCsvConverter = (SimpleCsvConverter) ctx.getBean("simpleCsvConverter");

            simpleCsvConverter.convert(parsedArguments);

        } catch (FileNotFoundException | ArgumentsSyntaxException e) {
            System.err.println(e.getMessage());
        }

    }
}
