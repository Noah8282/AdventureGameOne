public class RangedWeapon extends Weapons {
        private final String useName;


        public RangedWeapon(String shortName, String longName, int damage, int remainingUses) {
                super(shortName, longName, damage, remainingUses);
                useName = "ammo";
        }

        public RangedWeapon(String longName, int damage, int remainingUses) {
                super(longName, damage, remainingUses);
                useName = "ammo";
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
        public String useName() {
                return useName;
        }
}