package challenge.jobsity.service;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.model.parser.DataEntry;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileParserService {

    /**
     * Read all data from the parameter gameScore, and parse using the DataEntry object. The DataEntry class contains the necessary validations for the file data.
     * @param gameScore File to retrieve the data
     * @return A list of DataEntry.
     * @throws InvalidEntryFormatException If the format in the file don´t match with the specifitacions in DataEntry.
     * @throws IOException If the file can be accessed.
     */
    List<DataEntry> parseFile( File gameScore ) throws InvalidEntryFormatException, IOException;
}
