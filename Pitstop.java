public class Pitstop {
    private String type; 
    private int weight; //either pitstop has a weight
   
    public Pitstop(String type, int weight){
        this.type = type; 
        this.weight = weight;
    }
    
    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    //overriden method, chance to get overtaken, 
    public boolean overtaken() {
        if (this.getWeight() >= 2) {
            return true;
        } else {
            return false;
        }
    }
    

    //overriden method
    public String getDescription() {
        return "Your pitstop/upgrade is: ";
    }
}