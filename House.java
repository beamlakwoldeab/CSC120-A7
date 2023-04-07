/* This is the House class */
import java.util.ArrayList;
public class House extends Building{
  
  private ArrayList <String> residents;
  private boolean hasDiningRoom;
  public boolean elevator_friendly;
  
  public House(String name){
    this.name = name;
  }
  public House(String name, String address){
    this(name, address, 3, false);
  }

  public House(String name, String address, int nfloors){
    this(name, address, nfloors, false);
  }

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address,nFloors);
    this.elevator_friendly=true;
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }


  

  /** This method is an accessor for the hasDiningRoom attribute and checks if a house has a dining room.
   * @return boolean T/F depending on whether the house has a dining room.
*/
  public boolean gethasDiningRoom(){
    return hasDiningRoom; 
  }
  /** This method is an accessor for the residents attribute and returns the number of residents in a house.
   * @return The size of the residents Arraylist (the number of residents)
*/
  public int getnResidents(){
    return residents.size();
  };
/** This method adds a new resident into a house
 * @param newResident The name of the new resident
*/  
  public void moveIn(String newResident){
    residents.add(newResident);
  }
  /** This method removes a resident from a house (shows that they have moved out)
   * @param name The name of the resident that is moving out
   * @return name The name of the resident that is moving out.
*/
  public String moveOut(String name){
    residents.remove(name);
    return name;
  }
  /** This method checks if a person is a resident in a house by checking to find their name in the residents list.
   * @param name Name of the person in question
   * @return T/F deoending on whether the person is a resident in the house or not.
*/
  public boolean isResident(String name){
    if (this.residents.contains(name)){
      return true;
    } 
  else {
    return false;}
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + gethasDiningRoom() \n + getnResidents() \n + moveIn() \n + moveOut() \n + isResident() ");
}
  public void goToFloor(int floorNum) {
    if (this.elevator_friendly){
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
    }
    else{
      System.out.println("Sorry, this building does not have an elevator so you cannot move between floors in a single action. Please use goUp or goDown methods.");
    }
    
}

  public static void main(String[] args) {
    House wilson = new House("Wilson house", "16 Kensington", 6, true);
    wilson.showOptions();
  }

}