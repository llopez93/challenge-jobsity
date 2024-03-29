package challenge.jobsity.model.parser;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.TenPinConstants;
import challenge.jobsity.model.frame.Roll;

/**
 * A class to represent the format of the line read in file
 */
public class DataEntry {

    private Player player;
    private Roll roll;

    public DataEntry() {
    }

    /**
     * Convert a String and set the properties of the DataEntry class.
     * @param value String to convert.
     * @throws InvalidEntryFormatException If the format of the String not match with the specifitacion
     * of method checkFormat( String value ).
     */
    public void parseValue(String value) throws InvalidEntryFormatException{
        if ( this.checkFormat(value) ){
            String[] valueArray = value.split(" ");
            this.player = new Player(valueArray[0]);
            this.setRoll( valueArray[1] );
        }else
            throw new InvalidEntryFormatException("La entrada no posee un formato valido. Por ejemplo: Lisa 5");

    }

    /**
     * Review the format of the string, that must have a word (a-z) follow by an space and a number minor
     * than 11 or a letter "F" or "f". And in the end a new line.
     * @param value String to check the format.
     * @return True if the format is ok, false if not.
     */
    public boolean checkFormat( String value ){
        if ( value.matches("^[a-zA-Z]+?\\s[\\d+|fF]+$") ){
            String pinFalls = value.split(" ")[1];
            return pinFalls.equalsIgnoreCase(TenPinConstants.FOUL) || Integer.parseInt(pinFalls) < 11;
        }
        return false;
    }

    private void setRoll(String roll) {
        if (roll.equalsIgnoreCase(TenPinConstants.FOUL))
            this.roll = new Roll(0,true);
        else
            this.roll = new Roll(Integer.parseInt(roll),false);
    }

    public Player getPlayer() {
        return player;
    }

    public Roll getRoll() {
        return roll;
    }
}
