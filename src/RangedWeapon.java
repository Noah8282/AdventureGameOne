public class RangedWeapon extends Weapons {

        public RangedWeapon(String shortName, String longName, int damage, int remainingUses) {
                super(shortName, longName, damage, remainingUses);
        }

        public RangedWeapon(String longName, int damage, int remainingUses) {
                super(longName, damage, remainingUses);
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


}