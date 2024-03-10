import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item {
    private String longName;
    private String shortName = "";
    private ArrayList<String> keywords;

    public Item(String shortName, String longName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    public Item(String longName) {
        this.longName = longName;
        keywords = new ArrayList<>(List.of("lamp","sword","axe","bow","helmet","chestplate","leggings","boots","chestplate","bone"));
        String[] wordsInLongName = longName.split(" ");
        for (String kw : keywords) {
            for (int i = 0; i < wordsInLongName.length; i++) {
                if(wordsInLongName[i].equalsIgnoreCase(kw)) {
                    shortName = kw;
                }
            }
        }

        if(shortName.isBlank()) {
            throw new IllegalStateException("I can't recognise the description. Please define the short- and longName");
        }

    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }



}

