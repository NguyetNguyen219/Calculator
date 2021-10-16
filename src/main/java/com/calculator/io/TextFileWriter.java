package com.calculator.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

import static java.lang.System.exit;

public class TextFileWriter implements FileWriter {

    private BufferedWriter writer;
    String file;

    public TextFileWriter(String textFile) {
        file = textFile;
    }

    @Override
    public void writeFile(String num) throws IOException {

        writer = new BufferedWriter(new java.io.FileWriter(file));

        writer.write(new Date() + "\n\n");
        writer.write(num);

        writer.close();
    }
}
