package com.codecool;

import com.codecool.view.JsonOutputFormatter;
import com.codecool.view.OutputFormatter;
import com.codecool.view.TableOutputFormatter;
import com.codecool.view.XmlOutputFormatter;

public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormat outputFormat) {
        switch (outputFormat) {
            case TABLE:
                return new TableOutputFormatter();

            case XML:
                return new XmlOutputFormatter();

            case JSON:
                return new JsonOutputFormatter();

            default:
                throw new IllegalArgumentException();
        }
    }
}
