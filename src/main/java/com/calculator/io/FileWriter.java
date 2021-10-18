package com.calculator.io;

import java.io.IOException;

public interface FileWriter {

    String getFileName();

    void writeFile(String str) throws IOException;
}
