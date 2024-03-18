public class RangedWeapon extends Weapon {
        private final String useName;


        public RangedWeapon(String longName, String shortName, String useName) {
                super(longName, shortName);
                this.useName = useName;

        }
        public RangedWeapon(String longName) {
                super(longName);
                this.useName = "ammo";
        }
        public RangedWeapon(String longName, String shortName) {
                super(shortName, longName);
                this.useName = "ammo";
        }

        @Override
        public String useWeapon() {
                if (getRemainingUses() > 0) {
                        setRemainingUses(getRemainingUses()-1);
                        return "Shooting with RangedWeapon!";
                } else {
                        return "RangedWeapon out of uses!";
                }
        }

        @Override
        public String getUseName() {
                return useName;
        }
}