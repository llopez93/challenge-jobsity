package challenge.jobsity.parser;

import challenge.jobsity.model.parser.DataEntry;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for DataEntry class.
 */
public class DataEntryTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void checkValidTextLine() {
        DataEntry entry = new DataEntry();

        Assert.assertTrue(entry.checkFormat("Homero 5") &&
                entry.checkFormat("Homero F") &&
                entry.checkFormat("Homero f") &&
                entry.checkFormat("Homero 10") &&
                entry.checkFormat("Homero 0"));
    }

    @Test
    public void checkInvalidTextLine() {
        DataEntry entry = new DataEntry();

        Assert.assertFalse(entry.checkFormat("Homero asd") ||
                entry.checkFormat("Homero") ||
                entry.checkFormat("") ||
                entry.checkFormat("123 asd") ||
                entry.checkFormat("Marge 11") ||
                entry.checkFormat("Hom2er  123"));
    }
}
