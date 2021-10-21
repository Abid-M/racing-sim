public class Track {
    //three instance variables
    //position of user, the count of the botvehicle, how much pitstops used.
    private int position;
    private int whichBotRacer;
    private int pitstopCount;
    
    //constructor
    public Track(int position) {
        this.position = position;
        whichBotRacer = 0;
        pitstopCount = 0;
    }
    
    //getters and setter
    public int getPosition() {
        return position;
    }
    public int getWhichBotRacer() {
        return whichBotRacer;
    }
    public int getPitstopCount() {
        return pitstopCount;
    }
    
    public void incrementPosition() {
        position++;
    }
    public void decrementPosition() {
        position--;
    }
    
    public void incrementBotRacer() {
        whichBotRacer++;
    }
    public void decrementBotRacer() {
        whichBotRacer--;
    }
    
    public void incrementPitstopCount() {
        pitstopCount++;
    }
}
