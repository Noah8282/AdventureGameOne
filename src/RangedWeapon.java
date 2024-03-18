public class RangedWeapon extends Weapon {
        //Adds an attribute that is specific to RangedWeapon
        private final String useName;


        //Constructor for RangedWeapon with longName, shortName, and useName
        public RangedWeapon(String longName, String shortName, String useName) {
                // Calling the superclass constructor with longName and shortName
                super(longName, shortName);
                // Initializing the useName attribute
                this.useName = useName;

        }
        // Constructor for RangedWeapon with only longName
        public RangedWeapon(String longName) {
                // Calling the superclass constructor with longName
                super(longName);
                // Default Name for useName if not provided
                this.useName = "ammo";
        }

        // Constructor for RangedWeapon with longName and shortName
        public RangedWeapon(String longName, String shortName) {
                // Calling superclass constructor with shortName and longName
                super(shortName, longName);
                // Default value for useName if not provided
                this.useName = "ammo";
        }

        // Overriding the useWeapon method from the parent class
        @Override
        public String useWeapon() {
                // Checking if the remaining uses of the weapon is more than 0
                if (getRemainingUses() > 0) {
                        // Decreasing the amount of ammo after each use
                        setRemainingUses(getRemainingUses()-1);
                        // Returning message for when a ranged weapon shoots
                        return "Shooting with RangedWeapon!";
                } else {
                        // Returning message when the ranged weapon has no ammo left
                        return "RangedWeapon out of uses!";
                }
        }

        // Overriding the getUseName method from the parent class
        @Override
        public String getUseName() {
                //Returning the useName attribute
                return useName;
        }
}