public class Motorbike extends Vehicle {
    private int acceleration;
    
    public Motorbike (String driverName) {
        super(175, 5, driverName, "Motorbike");
        
        double acc = Math.random() * 100;
        //random acceleration chance.
        if (acc < 30) {
            acceleration = 0;
        }
        else if (acc < 70) {
            acceleration = 5;
        } else {
            acceleration = 10;
        }
    }
    
    //getter method
    public int getAcceleration() {
        return acceleration;
    }
    
    //overriden method, checks the accerleration and changes speed accordingly.
    public int getSpeed() {
        if (getAcceleration() == 0) {
            return super.getSpeed();
        }
        else if (getAcceleration() == 5) {
            return super.getSpeed() + 10;
        }
        else if (getAcceleration() == 10) {
            return super.getSpeed() + 15;
        } else {
            return 0;
        }
    }
    
    //overriden method
    public String inRace() { 
        super.inRace();
        return "motorbike with an engine size of " + this.getEngineSize() + " with speed of " + this.getSpeed();
    }
}
