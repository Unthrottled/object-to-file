package io.acari;

import io.acari.repositories.ProgrammerRepository;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        Path fileToWrite = Paths.get("programmers.data");
        if(Files.notExists(fileToWrite)){
            Files.createFile(fileToWrite);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(
                Files.newOutputStream(fileToWrite, StandardOpenOption.TRUNCATE_EXISTING))) {
            ProgrammerRepository programmerRepository = ProgrammerRepository.newProgrammerRepository();
            programmerRepository.getProgrammers().forEach(programmer -> {
                try {
                    out.writeObject(programmer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
