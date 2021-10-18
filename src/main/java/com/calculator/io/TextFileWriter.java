package com.calculator.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class TextFileWriter implements FileWriter {

    private BufferedWriter writer;
    private String file;

    public TextFileWriter(String textFile) {
        file = textFile;
    }

    @Override
    public String getFileName() {
        return file;
    }

    @Override
    public void writeFile(String num) throws IOException {

        writer = new BufferedWriter(new java.io.FileWriter(file, true));

        writer.write(new Date() + "\n");
        writer.write(num);
        writer.write("\n------------------------\n");

        writer.close();
    }
}
