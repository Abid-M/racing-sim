public class Vehicle {
    private String driverName;
    private String vehicleType;
    
    private int speed;
    private int engineSize;
    
    private double fuel = 10; //not max fuel, can go over. But default 10 to start with.
    
    //constructor
    public Vehicle (int speed, int engineSize, String driverName, String vehicleType) {
        this.speed = speed;
        this.engineSize = engineSize;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
    }
    
    //getters
    public String getType() {
        return vehicleType;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public int getEngineSize() {
        return engineSize;
    }
    
    //set new engine size
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
    
    
    public Boolean overtake (Vehicle v) {
        //random number between 1-100
        double rnd = Math.random() * 100;
        
        //Even though engine size may be greater, chance still to overtake 20%.
        if (this.getEngineSize() > v.getEngineSize() || rnd < 80) {
            return true;
        }
        else if (this.getEngineSize() < v.getEngineSize() || rnd > 80) {
            return false;
        } 
        else {
         return false;
        }
    }
    
    public double getFuel() {
        return fuel;
    }
    
    public void setFuel() {
        fuel = fuel - 1;
    }
    
    public void setFuel(int litres) { //method overloading
        this.fuel = this.fuel + litres;
    }
    
    public void emptyFuel() {
        fuel = 0;
    }
    
    //overriden method.
    public String inRace() {
        return "A vehicle of type of";
    }
}
