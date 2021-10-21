public class Car extends Vehicle {
    private int damaged; //dont need in motorbike as small and rover as its strong built
    private int maxDamaged = 5;
    
    public Car(String driverName) {
        super(150, 10, driverName, "Car");
        damaged = 0; //default value
    }
    
    //getter methods
    public int getDamaged(){
        return damaged;
    }
    
    public int getMaxDamaged(){
        return maxDamaged;
    }
    
    //overriden method, higher the damage on car, decrease in speed.
    public int getSpeed() {
        if (getDamaged() > 2) {
            return super.getSpeed() - 50;
        }
        else if (getDamaged() > 4) {
            return super.getSpeed() - 80;
        }
        
        else {
            return super.getSpeed();
        }
    }
    
    public void setRepair() { 
        damaged = 0;
    }
    
    //overriden method
    public Boolean overtake (Vehicle v) {
    //everytime tries to overtake a vehicle, increases the damage on car
        damaged = damaged + 1;
        return super.overtake(v);
    }
    
    //overriden method
    public String inRace() { 
        super.inRace();
        return "car with an engine size of " + this.getEngineSize() + " with speed of " + this.getSpeed();
    }
}