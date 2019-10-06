package challenge.jobsity.model.parser;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.model.Player;

public class DataEntry {

    private Player player;
    private Integer pinFalls;

    public DataEntry() {
    }

    public DataEntry(Player player, Integer pinFalls) {
        this.player = player;
        this.pinFalls = pinFalls;
    }

    public void parseValue(String value) throws InvalidEntryFormatException{
        if ( this.checkFormat(value) ){
            String[] valueArray = value.split(" ");
            this.player = new Player(valueArray[0]);
            this.pinFalls = valueArray[1].equalsIgnoreCase("f")? 0 : Integer.parseInt(valueArray[1]);

        }else
            throw new InvalidEntryFormatException("La entrada no posee un formato valido. Por ejemplo: Lisa 5");

    }

    public boolean checkFormat( String value ){
        if ( value.matches("^[a-zA-Z]+?\\s[\\d+|fF]+$") ){
            String pinFalls = value.split(" ")[1];
            return pinFalls.equalsIgnoreCase("f") || Integer.parseInt(pinFalls) < 11;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getPinFalls() {
        return pinFalls;
    }
}
