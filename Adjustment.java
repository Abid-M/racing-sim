public class Adjustment extends Pitstop {
    private int engineUpgrade;
    
    public Adjustment(String type) {
        super(type, 0);
        
        double randAdjust= Math.random() * 10;
        //random generated engine upgrade.
        if (randAdjust < 6) {
            engineUpgrade = 10;
            super.setWeight(1);
        }
        else if (randAdjust < 7) {
            engineUpgrade = 20;
            super.setWeight(2);
        } else {
            engineUpgrade = 30;
            super.setWeight(3);
        }
    }
    
    //getter method
    public int getEngineUpgrade() {
        return engineUpgrade;
    }
    
    public boolean overtaken() {
        //overriden method, chance to get overtaken when applying pitstop, depending on which upgrade.
        if (this.getEngineUpgrade() >= 20) {
            return true;
        } else {
            return false;
        }
    }
    
    //method overriden.
    public String getDescription() {
        super.getDescription();
        return "Engine Upgrade of " + getEngineUpgrade();
    }
}