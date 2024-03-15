public class RangedWeapon extends Weapons {
        private int remainingUses;

        public RangedWeapon(int remainingUses) {
                this.remainingUses = remainingUses;
        }


        @Override
        public String useWeapon() {
                if (remainingUses > 0) {
                        System.out.println("Shooting with RangedWeapon!");
                        remainingUses--;
                } else {
                        System.out.println("RangedWeapon out of uses!");
                }
        }

        public int remainingUses() {
                return remainingUses;
        }
}