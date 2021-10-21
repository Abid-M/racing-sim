import java.util.Scanner;
import java.util.Random;
import java.lang.Math; 

public class Racing {
    private static Scanner scanner = new Scanner(System.in);    
    
    public static void main (String[] args) {
        System.out.println("Welcome to a racing simulator!");
        
        Vehicle userPlayer = createUser();
        Vehicle [] botRacers = racers(); //array of vehicle type with the racers.
        
        for (int i=0; i < botRacers.length; i++) { 
            //Prints out all the bot racers with their descriptions.
            System.out.println("Bot Racer " + (i+1) + ": " + botRacers[i].inRace()); //dynamic binding - polymorphism
        }
        
        beginRace(userPlayer, botRacers);
    }
    
    public static Vehicle createUser(){ 
        String driverName;
        String choice;
        
        System.out.println("Please enter your driver name? ");
        driverName = scanner.nextLine();
        
        System.out.println("\nWelcome "+ driverName);
        
        boolean exit = false;
        Vehicle userPlayer = new Vehicle(0,0,"","");
        while (!exit) {
            System.out.println("Which vehicle would you like? \n\nEnter C for Car, M for Motorbike or R for rover");
            choice = scanner.nextLine();
            
            if (choice.equals("C")) {
                userPlayer = new Car(driverName); //substitution principle
                exit = true;
            }
            else if (choice.equals("M")) {
                userPlayer = new Motorbike(driverName); //substitution principle
                exit = true;
            }
            else if (choice.equals("R")) {
                userPlayer = new Rover(driverName); //substitution principle
                exit = true;
            } else {
                System.out.println("\nInvalid choice");
            }
        }
        return userPlayer;
    }
    
    public static Vehicle [] racers() {
        int numberOfRacers;
        System.out.println("\nEnter number of bot racers: ");
        numberOfRacers = Integer.parseInt(scanner.nextLine());
        
        Vehicle [] botRacers = new Vehicle [numberOfRacers]; //creates array of botracers with an input being the size of the array.
        
        for (int i = 0; i < botRacers.length; i++) {
            //random element to pick which subtype instanceof to create of the vehicle type array
            double randomise = Math.random() * 10;
            if (randomise <= 3) {
                botRacers[i] = new Car(""); //substitution principle
            }
            else if (randomise <= 6) {
                botRacers[i] = new Motorbike(""); //substitution principle
            } else {
                botRacers[i] = new Rover(""); //substitution principle
            }
        }
        return botRacers; //return statement
    }
    
    public static Pitstop createPitstop() {
        Pitstop pitstop = new Pitstop("",0);
        
        double chance = Math.random() * 3;
        //Randomises change to create either two of the pitstops.
        if (chance <= 1.5) {
            pitstop = new Fuel("Fuel"); //substitution principle
        }
        else if (chance <= 3) {
            pitstop = new Adjustment("Adjustment"); //substitution principle
        } 
        
        return pitstop;
    }
   
    
    public static void beginRace(Vehicle userPlayer, Vehicle [] botRacers) {
       Random rand = new Random();
       int pitstopAmount = rand.nextInt(7-2) + 2;
       //random number generated for the amount of pitstops during game (between 2-6)
       Pitstop [] pitstops = new Pitstop[pitstopAmount];
       for (int i = 0; i < pitstopAmount; i++){
           pitstops[i] = createPitstop();
       }

       Track track = new Track(botRacers.length); //track variable declared with type of track.
       
       System.out.println("\nYou start in position " + track.getPosition()); //User starts in the last position.
       while (userPlayer.getFuel() != 0 && track.getPosition()!=1) {  
           //Checks which subtype of Vehicle, the userPlayer is.
           if (userPlayer instanceof Car) {
               Car output = (Car)userPlayer; //casting
               System.out.println("Your car has " + output.getDamaged() + " damage due to overtaking");
               System.out.println(userPlayer.getFuel() + " fuel remaining");
               
               System.out.println("\nWould you like to repair your car? Y or N ");
               System.out.println("If you repair your car, you will be behind by two positions.");
               String userInput = scanner.nextLine();
               
               if (userInput.equals("Y")) {
                   System.out.println("Your car has been repaired!"); output.setRepair();
                   
                   //cant change if already in last position.-2/
                   if (track.getPosition() < (botRacers.length-2)) {  
                   //two positions behind, due to repairing
                   track.incrementPosition(); 
                   track.incrementPosition();
                   //overtaken bot vehicles.
                   track.decrementBotRacer();
                   track.decrementBotRacer();                     
                   }
               }
               
               if (output.getDamaged() == output.getMaxDamaged()) {
                   userPlayer.emptyFuel(); //When damage reaches max, fuel is set to 0, exits loop. forfeits race.
               }
           }
           else if (userPlayer instanceof Motorbike) {
               Motorbike output = (Motorbike)userPlayer; //casting
               System.out.println("Your Motorbike has " + output.getAcceleration() + " acceleration");
               System.out.println(userPlayer.getFuel() + " fuel remaining");
           }
           else if (userPlayer instanceof Rover) {
               Rover output = (Rover)userPlayer; //casting
               System.out.println("Your Rover change tyres is: " + output.getChangeTires());
               System.out.println(userPlayer.getFuel() + " fuel remaining");
               
               if (output.getChangeTires() == true) {
                   System.out.println("Your tyres have been repaired, however you have been overtaken");
                   output.resetTires(); //sets changetires back to false
                   
                   if (track.getPosition() != botRacers.length) {
                       //cant change if already in last position.
                       track.incrementPosition(); //calls instance method in track class, and position++, as overtaken.
                       track.decrementBotRacer(); //calls instance method in track class, botracer--, as still needs to overtake previous.
                   }
                   
                   System.out.println("Position: " + track.getPosition()); //prints out current position.
               }
           }
           
           //calls an instance method in the track class, which is for the index of the botRacers array. vvv

           System.out.println("Would you like to overtake? Y or N");
           String optionOvertake = scanner.nextLine();
           
           if (optionOvertake.equals("Y")) {
               boolean overtaked = userPlayer.overtake(botRacers[track.getWhichBotRacer()]); //if overtaken or not //dynamic binding depends on which subtype
               
               //random chance to overtake if overtaked was false originally.
               if (userPlayer.getSpeed() > botRacers[track.getWhichBotRacer()].getSpeed()) { //dynamic getspeed method called depending on which subtype.
                   double changeChance = Math.random() * 10;
                   if (changeChance > 8) {
                       overtaked = true; 
                   }
               }
               
               if (overtaked == true) {
                   track.decrementPosition(); 
                   userPlayer.setFuel(); //decrements fuel for overtaking.
                   
                   System.out.println("\nYou have overtaken and now in position: " + track.getPosition()); 
                   if(track.getPosition() == 1) {
                       break; //first position, have succeeded. Different factors so random chance or not at all to get 1st.
                   }
                   track.incrementBotRacer(); //increment to next racer to overtake.
                   
               } else {
                   System.out.println("\nYou have NOT overtaken and still in position: " + track.getPosition());
               }
               
           
           } else {
               System.out.println("You have chosen not to overtake");
           }
           
           if (optionOvertake.equals("Y")) { //pitstop-upgrade options only if user TRIED to overtake.
               System.out.println("Due to trying to overtake, you have arrived at a pitstop");

               //Checks if anymore pitstops left.
               if (track.getPitstopCount() == pitstopAmount) {
                   System.out.println("\nUnfortunately no more pitstops/adjustments left.");
                   System.out.println("");
               } 
               
               else {
                   System.out.println("\n" + pitstops[track.getPitstopCount()].getDescription()); //polymorphism (late dynamic binding)
                   
                   //Check to see if Fuel pitstop is of type fuel
                   if (pitstops[track.getPitstopCount()].getType() == "Fuel") {
                       System.out.println("\nWould you like to fill up the fuel? Y or N");
                       String fillup = scanner.nextLine();
                       
                       if (fillup.equals("Y")) {
                           if (pitstops[track.getPitstopCount()].overtaken() == true) { //polymorphism
                               //random chance to go behind, as could get overtaken at pitstop.
                               track.incrementPosition(); 
                               System.out.println("\nA vehicle has overtaken you and so you are in position: " + track.getPosition());
                               track.decrementBotRacer();
                           }
                           
                           Fuel fuel = (Fuel)pitstops[track.getPitstopCount()]; //casting
                           userPlayer.setFuel(fuel.getLitres());
                           System.out.println("\nYou have now " + userPlayer.getFuel() + " litres of fuel");
                       }
                   }
                   
                   //Check to see if Fuel pitstop is of type adjustment
                   else if (pitstops[track.getPitstopCount()].getType() == "Adjustment") {
                       System.out.println("\nWould you like to upgrade your engine/speed? Y or N");
                       String chosen = scanner.nextLine();
                       
                       if (chosen.equals("Y")) {
                           if (pitstops[track.getPitstopCount()].overtaken() == true) { //polymorphism
                               //random chance to go behind, as could get overtaken at pitstop.
                               track.incrementPosition(); 
                               System.out.println("\nA vehicle has overtaken you and so you are in position: " + track.getPosition());
                               track.decrementBotRacer();
                           }
                           
                          Adjustment adjustment = (Adjustment)pitstops[track.getPitstopCount()]; //casting
                          int engineUpgrade = userPlayer.getEngineSize() + adjustment.getEngineUpgrade();
                          
                          //new engine size added to a random upgrade that was generated within instance method.
                          userPlayer.setEngineSize(engineUpgrade);
                          System.out.println("\nYou have now " + userPlayer.getEngineSize() + " engine size");
                       }
                   }
                   track.incrementPitstopCount(); //next round of a random pitstop.
                }
           }            
       }
       
       System.out.println("Game over!");
       //Two options, if user ran out of fuel or if they won the race by being in first position.
       if (userPlayer.getFuel() == 0) {
           System.out.println("Unfortunately, you have run out of fuel, and forfeited the race!");
       }
       else if (track.getPosition()==1) {
           System.out.println("Congratulations, " + userPlayer.getDriverName() + " you have overtaken all the racers and won the race in first position!");
       }
    }
}
