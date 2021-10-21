public class Rover extends Vehicle {
    private boolean changeTires; //tyres need to be changed for rovers.
    
    public Rover(String driverName) {
        super(125, 15, driverName, "Rover");
        changeTires = false; //default false.
    }
    
    public boolean getChangeTires(){
        return changeTires;
    } 
    
    //every time overtakes, chance for changetires to be true
    public void setChangeTires() {
        changeTires = true;
    }
    
    //tires are repaired.
    public void resetTires() {
        changeTires = false;
    }
    
    //overriden method, if tires set to true, speed decreased drastically.
    public int getSpeed() {
        if (getChangeTires() == true) {
            return super.getSpeed() - 100;
        }        
        else {
            return super.getSpeed();
        }
    }
 
    //overriden method, everytime tries to overtake a vehicle, random chance that tyres may need changing.
    public Boolean overtake (Vehicle v) {
        double rnd = Math.random() * 10;
        if (rnd > 7) {
            this.setChangeTires(); //set to true
        }
        
        return super.overtake(v);
    }

    ////overriden method
    public String inRace() { 
        super.inRace();
        return "rover with an engine size of " + this.getEngineSize() + " with speed of " + this.getSpeed();
    }
}
