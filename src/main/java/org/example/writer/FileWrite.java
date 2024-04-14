package org.example.writer;

import org.example.model.Sonnet;

import java.io.IOException;
import java.io.FileWriter;

public class FileWrite {
    public static void writeSonnetFile(String path, Sonnet sonnet) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            sonnet.getLines().stream().forEach(elem -> {
                try {
                    fileWriter.write(elem.getLine());
                    fileWriter.write("\n");
                } catch (IOException e) {
                    System.out.println("Errors");
                }
            });
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }
}
