Student name: Abid Miah	
Student number: 200193849

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Vehicle]

This superclass is extended into at least two subclasses called [Motorbike, Rover, Car]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Motorbike] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [acceleration]

These/this new properties/property are used by the subclass in the following way: [In class Motorbike, Line 26. the acceleration property is used to change the speed of the vehicle accordingly. In class Motorbike, on line 9, depending on the random generated number it assigns different value to the acceleration property, so different motorbikes can have different acceleration values which impacts their speed. In the Racing class, line 136, outputs the acceleration.]

Subclass [Motorbike] extends the superclass by overriding the following methods (there must be at least one): [getSpeed() and inRace() methods are overriden. In class Motorbike, line 25 and line 40.]

These overridden methods are used in the working code in the following places: [In the Racing class, on line 167, compares the speed of the userPlayers to the randomly generated bots vehicles. In line 16, inRace method is called, depending on which subtype is the instanceof.]

Subclass 2.

Subclass [Rover] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [changeTires]

These/this new properties/property are used by the subclass in the following way: [Due to a rover having large wheels, it may need to get changed often throughout the race, as may tear down. Line 25 in class Rover, checks to see if the changeTires property is set to true and if so it decreases the speed drastically. Also in Line 37 in class Rover, it sets the changeTires property to be true, given a random number. In the Racing class, line 141, 144 and 146 outputs the changeTires value and also an if statement that checks to see if its true, and if so. Tires would get repaired and call the resetTires instance method which would set the value of the property back to false.]

Subclass [Rover] extends the superclass by overriding the following methods (there must be at least one): [getSpeed, overtake and inRace methods. In class Rover, line 24, line 34 and line 44.]

These overridden methods are used in the working code in the following places: [In class Racing, on line 164, overtake method is called and if the userPlayer is an instanceof Rover then it'll call overtake method in the Rover class, and given a random number after overtaking it may or may not set to changeTires. In line 167, compares the speed of the userPlayers to the randomly generated bots vehicles. In line 16, inRace method is called, depending on which subtype is the instanceof.]

Subclass 3.

Subclass [Car] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [damaged and maxDamaged]

These/this new properties/property are used by the subclass in the following way: [Damaged property, not needed in motorbike as its small and rover as its strongly built. Line 20 in class Car. It checks the damaged value and decreases the speed accordingly. As if the car is damaged heavily then it would reduce the speed. Line 11 and 15 in class Car, getter methods of the new properties. Line 109 in class Racing, outputs, the damaged property value. Also, on line 117, calls the instance method setRepair, which sets the damage property value to 0. Also, on line 130 in class Racing, if statement that checks if the damaged value is equal to the maxDamaged value, by using getter methods, and if so, the fuel is emptied as when damage reaches max, fuel is set to 0, exits loop, forfeits race.]

Subclass [Car] extends the superclass by overriding the following methods (there must be at least one): [getSpeed, overtake and inRace methods. In class Car, line 20, line 38 and line 45.]

These overridden methods are used in the working code in the following places: [In the Racing class, on line 164, overtake method is called and if the userPlayer is an instanceof Car then it'll call overtake method in the Car class, in which everytime increments the damage on the car by one, as well as calling the Vehicle (superclass) overtake method. On line 167, compares if the speed of the userPlayers is greater than the randomly generated bots vehicles, and if so a chance of overtaked being true if originally was false. On line 16, inRace method is called, depending on which subtype is the instanceof.]


I have a another superclass called [Pitstop]

This superclass is extended into at least two subclasses called [Fuel and Adjustment]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Fuel] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [litres]

These/this new properties/property are used by the subclass in the following way: [Property used to determine the amount of litres of actual fuel. In class Fuel, on line 9, depending on the random generated number it assigns different value to the litres property, so there can be different litres of fuel. In the Racing class, line 218/219, a new variable called fuel is created of type Fuel as its casted from the pitstops array. And depending on the value of litres, it sets the Fuel within the Vehicle class by using the getter method of the litres property. In addition, in the class Fuel, line 29, litres is used to determine whether the vehicle would be overtaken or not.]

Subclass [Fuel] extends the superclass by overriding the following methods (there must be at least one): [getDescription and overtaken. On line 27 and 37 of class Fuel.]

These overridden methods are used in the working code in the following places: [In the racing class, on line 203, getDescription method is called, depending on which subtype is the instanceof. It would first call the superclass getDescription method and then state Fuel tank with, with a litres getter method. Also, in the Racing class, on line 211, the overtaken method is called depending on which subtype is the instanceof and depending on the value of the property there is a chance to get overtaken, whilst being at the pitstop.]

Subclass 2.

Subclass [Adjustment] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [engineUpgrade]

These/this new properties/property are used by the subclass in the following way: [Ability to upgrade engine at pitstop. In class Adjustment, on line 9, depending on the random generated number it assigns different value to the engineUpgrade property, so there can be different upgrade values possible. In class Racing, line 237, 38 and 241. A new variable called adjustment is created of type Adjustment as its casted from the pitstops array. Then using a getter method to get the value of the engine upgrade, which gets added onto the current enginesize and sets the new engineSize of the users vehicle. In addition, on line 29 in Adjustment class, the engineupgrade is used to determine wherther the vehicle would be overtaken or not, whilst at pitstop, depending on the value of the property.]

Subclass [Adjustment] extends the superclass by overriding the following methods (there must be at least one): [getDescription and overtaken. In line 27 and 37 of class Adjustment.]

These overridden methods are used in the working code in the following places: [In the racing class, on line 203, getDescription method is called, depending on which subtype is the instanceof. It would first call the superclass getDescription method and then state Engine Upgrade of, with a engine upgrade getter method. Also, in the Racing class, on line 211/230 the overtaken method is called depending on which subtype is the instanceof and depending on the value of the property there is a chance to get overtaken, whilst being at the pitstop.]

LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [In Racing class, line 38/42/46 and 66/69/71]. The name of the superclass used in this example is [Vehicle] and the subclasses used are [Car, Motorbike, Rover].

Late dynamic binding can be seen in [In Racing class, line 16, 164 and 167].

This is necessary in my program, as it is needed in order for the user to choose which vehicle they'd like as well as to generate random bot racers with different subtype instances, so the program is not purely one vehicle. Every vehicle in my program has a enginesize and speed, these values are different for each subtype of vehicle. But every different types of vehicles (car, motorbike, rover), can have different overtake/getspeed method implementations as well as extra individual properties, which would aid during the race.

Example 2.

The substitution principle can be seen in use in [In Racing class, line 83/86]. The name of the superclass used in this example is [Pitstop] and the subclasses used are [Fuel, Adjustment].

Late dynamic binding can be seen in [In Racing class, line 203 and 211/230].

This is necessary in my program, as both use a common interface and the ability to have different forms related to the superclass. So within the program, users would have either a fuel pitstop or an adjustment pitstop, and depending on the individual properties value of subclass fuel/adjustment, there is a chance that a vehicle could overtake if the user wishes to take the pitstop. Also, this would affect the properties within the Vehicle class, as well as having their own implmentation of the pitstop class.

