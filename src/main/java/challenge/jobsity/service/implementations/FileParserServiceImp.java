package challenge.jobsity.service.implementations;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FileParserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParserServiceImp implements FileParserService {

    @Override
    public List<DataEntry> parseFile(File gameScore) throws InvalidEntryFormatException, IOException {
        System.out.println("Parsing file...");
        ArrayList<DataEntry> entries = new ArrayList<>(0);
        Stream<String> lines = Files.lines(Paths.get(gameScore.getAbsolutePath()));
        for (String line : lines.collect(Collectors.toList())) {
            DataEntry entry = new DataEntry();
            entry.parseValue(line);
            entries.add(entry);
        }
        return entries;
    }
}
