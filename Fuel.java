public class Fuel extends Pitstop {
    private int litres;
    
    public Fuel(String type) {
        super(type, 0);
        
        double randLitres = Math.random() * 10;
        //random generated litres of fuel.
        if (randLitres < 6) {
            litres = 3;
            super.setWeight(1);
        }
        else if (randLitres < 8) {
            litres = 4;
            super.setWeight(2);
        } else {
            litres = 5;
            super.setWeight(3);
        }
    }
    
    //when user fills up fuel, updates fuel in vehicle class 
    public int getLitres() { 
        return litres;
    }  
    
    public boolean overtaken() {
        //overriden method, chance to get overtaken when applying pitstop, depending on how much litres.
        if (this.getLitres() >= 4) {
            return true;
        } else {
            return false;
        }
    }
    
    //overriden method
    public String getDescription() {
        super.getDescription();
        return "Fuel tank with " + getLitres() + " Litres";
    }
}