package com.dydko.date1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Files123Test {

    private String directory = "C:/temp";

    @Test
    public void dateTest1() throws IOException {
        List<File> fileList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files
                .newDirectoryStream(Paths.get(directory))) {
            for (Path path : stream) {
                //if (!Files.isDirectory(path)) {
                    fileList.add(path.toFile());
                //}
            }
        }

        fileList.forEach(System.out::println);
    }
}