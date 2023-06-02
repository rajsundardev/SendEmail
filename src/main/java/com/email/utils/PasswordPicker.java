package com.email.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PasswordPicker {

    public String readFile() {
        String filename = "src\\main\\resources\\password.txt";

        String output = "";
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            output = stream.collect(Collectors.joining());

        } catch (IOException ie) {
            ie.getMessage();
        }
        return output;
    }

}
