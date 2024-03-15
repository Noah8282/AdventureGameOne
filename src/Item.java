import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item {
    //Description of the item
    private String longName;
    //Short name for the item (one word)
    private String shortName = "";
    //A list of possible shortnames, which can be iterated through if no shortname has been provided.
    private ArrayList<String> keywords;

    public Item(String shortName, String longName) {
        //Sets short and long name for manual implementation.
        this.longName = longName;
        this.shortName = shortName;
    }

    public Item(String longName) {
        //Sets longname
        this.longName = longName;
        //Sets arraylist of possible shortnames/keywords
        keywords = new ArrayList<>(List.of("lamp", "sword", "axe", "bow", "helmet", "chestplate", "leggings", "boots",
                "chestplate", "bone","steak","pork","apple","beans","potato", "bread", "banana"));
        //Takes the long name and splits each word into an array
        String[] wordsInLongName = longName.split(" ");
        //Iterations through each keyword
        for (String kw : keywords) {
            //Iteration through each word from the item description/long name
            for (int i = 0; i < wordsInLongName.length; i++) {
                //Checks if a keyword from the list matches a word from the item description.
                // If yes it sets the keyword to the short name.
                if (wordsInLongName[i].equalsIgnoreCase(kw)) {
                    shortName = kw;
                    break;
                }
                //Checks if the shortname isn't blank. If so, break the outer loop. No need to further iterate through.
                if(!shortName.isBlank()) {
                    break;
                }
            }
        }
        //If the loop has done a full iteration through keywords, and shortname has not been set, it is not a valid short name.
        //Illegal Exception is thrown to encourage the developer to manually insert the short-and longName.
        if (shortName.isBlank()) {
            throw new IllegalStateException("I can't recognise the description. Please define the short- and longName");
        }

    }

    //Getter for longName
    public String getLongName() {
        return longName;
    }

    //Getter for shortname.
    public String getShortName() {
        return shortName;
    }
}
