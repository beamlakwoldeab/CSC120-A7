/* This is the cafe class */

public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name){
        this.name = name;
      }
      public Cafe(String name, String address){
        this(name, address, 1);
      }

    public Cafe(String name, String address, int nFloors) {
        super(name, address,nFloors);
        System.out.println("You have built a cafe: ☕");
    }
/** This function is used to restock all ingredient items to 100 after every coffee purchase to ensure that there are enough ingredients to make the next drink. 
 * 
*/
    private void restock(){
        nCoffeeOunces = 100;
        nSugarPackets = 100;
        nCreams = 100;
        nCups = 100;
    }; 
/** This is the fuction that allows the cafe to sell coffee. 
 * @param size number of coffee ounces
 * @param numSugarPackets number of sugar packets
 * @param numCreams number of creams 
*/
    public void sellCoffee(int size, int numSugarPackets, int numCreams){
            nCoffeeOunces -= size;
            nSugarPackets -= numSugarPackets;
            nCreams -= numCreams;
            nCups -= 1;
            this.restock();}

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goToFloor(n)\n + restock()\n + sellCoffee()");
    }
    
    public void goToFloor(int floorNum) {
          System.out.println("Sorry, this building only has one floor.");
        }
    
    public static void main(String[] args) {
        Cafe compass =  new Cafe("Compass Cafe", "2 Chapin Way", 1);
        compass.sellCoffee(3,3,4);
        System.out.println(compass.nCreams);
        compass.showOptions();

    }
    
}
