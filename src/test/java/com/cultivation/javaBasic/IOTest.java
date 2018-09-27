package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.TempDirectory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TempDirectory.class)
class IOTest {
    @Test
    void should_read_write_file_from_file_stream(@TempDirectory.TempDir Path dir) throws Exception {
        final String message = "Hello world!" + System.lineSeparator();
        Path filePath = dir.resolve("sample.txt");
        System.out.println(filePath);

        writeAllText(message, filePath, StandardCharsets.UTF_8);
        assertEquals(message, readAllText(filePath, StandardCharsets.UTF_8));
    }

    @SuppressWarnings({"SameParameterValue", "unused", "RedundantThrows"})
    private static void writeAllText(String message, Path filePath, Charset charset) throws IOException {
        // TODO: please implement the method to writer text to file using `PrintWriter`.
        // <--start
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(filePath.toString(), charset.name());
            printWriter.write(message);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // --end-->
    }


    @SuppressWarnings({"SameParameterValue", "unused", "RedundantThrows"})
    private static String readAllText(Path path, Charset charset) throws IOException {
        // TODO: please implement the method to read text from file using `Files` helper methods.
        // <--start
        List<String> lines;
        StringBuilder text = new StringBuilder();
        try {
            lines = Files.readAllLines(path, charset);
            lines.forEach(text::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.append(System.lineSeparator()).toString();
        // --end-->
    }

    @SuppressWarnings({"unused", "RedundantThrows"})
    @Test
    void should_be_able_to_write_and_read_binary_data_to_file(@TempDirectory.TempDir Path dir) throws Exception {
        Path filePath = dir.resolve("sample.bin");

        final int firstValue = 2018;
        final double pi = 3.14;

        // TODO: please write `firstValue` and `pi` to `filePath`
        // <--start
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath.toString()))) {
            out.writeInt(firstValue);
            out.writeDouble(pi);
        }
        // --end-->

        int actualFirstValue = 0;
        double actualPi = 0;

        // TODO: please read `actualFirstValue` and `actualPi` from `filePath`
        // <--start

        try (DataInputStream in = new DataInputStream(new FileInputStream(filePath.toString()))) {
            actualFirstValue = in.readInt();
            actualPi = in.readDouble();
        }
        // --end-->

        assertEquals(firstValue, actualFirstValue);
        assertEquals(pi, actualPi);
    }
}

/*
 * - Do you think the `PrintWriter` will close the under-laying writer when it is closed? Why?
 * - Do you think it is possible to detect encodings from a given text file?
 * - Which kind of byte sequence does Java file stream uses? Big-endian? Little-endian? Or platform dependent?
 * - Which encoding does writeUTF use?
 */
