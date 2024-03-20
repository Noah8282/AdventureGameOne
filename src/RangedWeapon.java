public class RangedWeapon extends Weapon {
        //Adds an attribute that is specific to RangedWeapon



        //Constructor for RangedWeapon with longName, shortName, and useName
        public RangedWeapon(String longName, String shortName, String useName) {
                // Calling the superclass constructor with longName and shortName
                super(longName, shortName, 1);
                // Initializing the useName attribute
                setUseName(useName);

        }
        // Constructor for RangedWeapon with only longName
        public RangedWeapon(String longName) {
                // Calling the superclass constructor with longName
                super(longName,1);
                // Default Name for useName if not provided
                setUseName("ammo");
        }


}