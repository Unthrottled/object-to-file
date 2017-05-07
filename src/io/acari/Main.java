package io.acari;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path fileToWrite = Paths.get("bikeFile.data");
        if(!Files.exists(fileToWrite)){
            try {
                Files.createFile(fileToWrite);
            } catch (IOException e) {
                System.err.println("Unable to create file in current working directory.");
                System.err.println(e.getMessage());
            }
        }

    }
}
