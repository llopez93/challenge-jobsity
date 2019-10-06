package challenge.jobsity.service;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.model.parser.DataEntry;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileParserService {

    public List<DataEntry> parseFile( File gameScore ) throws InvalidEntryFormatException, IOException;
}
