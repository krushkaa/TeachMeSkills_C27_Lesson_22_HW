package org.example;

import org.example.model.Sonnet;
import org.example.parser.DomParser;
import org.example.parser.SaxParser;
import org.example.writer.FileWrite;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        Sonnet sonnet = null;
        String path;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose 1 for DOM parser or 2 for SAX parser: ");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            sonnet = DomParser.parseXml("resource.xml");
            path = sonnet.getAuthor().getFirstName() + "_" + sonnet.getAuthor().getLastName() + "_" + sonnet.getTitle() + ".txt";
            FileWrite.writeSonnetFile(path, sonnet);
        } else if (userChoice.equals("2")) {
            SaxParser parserXml = new SaxParser();
            sonnet = parserXml.parse();
            path = sonnet.getAuthor().getFirstName() + "_" + sonnet.getAuthor().getLastName() + "_" + sonnet.getTitle() + ".txt";
            FileWrite.writeSonnetFile(path, sonnet);

        } else {
            System.out.println("Incorrect number");
        }

        System.out.println("SONNET " + sonnet);
    }
}
