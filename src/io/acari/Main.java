package io.acari;

import io.acari.pojo.ExternalizableProgrammer;
import io.acari.pojo.Programmer;
import io.acari.repositories.ProgrammerRepository;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        ProgrammerRepository programmerRepository = ProgrammerRepository.newProgrammerRepository();
        readWriteObject(programmerRepository.getProgrammers(), Programmer.class);
        readWriteObject(programmerRepository.getProgrammers().map(ExternalizableProgrammer::new), ExternalizableProgrammer.class);
    }

    private static <T> void readWriteObject(Stream<T> objectStream, Class<T> tClass) throws IOException {
        String simpleName = tClass.getSimpleName();
        Path fileToWrite = Paths.get(simpleName + ".data");
        if (Files.notExists(fileToWrite)) {
            Files.createFile(fileToWrite);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(
                Files.newOutputStream(fileToWrite, StandardOpenOption.TRUNCATE_EXISTING))) {
            objectStream.forEach(object -> {
                try {
                    out.writeObject(object);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }


        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(fileToWrite, StandardOpenOption.READ))) {
            List<T> programmers = new LinkedList<>();
            try {
                while (true) {
                    programmers.add((T) in.readObject());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException ignored) {
            }
            System.out.format("%d %s read from file!\n", programmers.size(), simpleName);
        }
    }
}
