/* This is a stub for the Library class */
import java.util.Hashtable;
// books move around
public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  boolean elevator_friendly;

    public Library(String name){
      this.name = name;
    }
    public Library(String name, String address){
      this(name, address, 1);
    }

    public Library(String name, String address, int nFloors) {
      super(name, address,nFloors);
      this.elevator_friendly = true;
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  /** This method adds a title to the collection of books.
   * @param title The name of the title to be added
*/
    public void addTitle(String title){
      collection.put(title, true);
      System.out.println(title + " has been added to the collection " + collection.get(title));
    }
  /** This method removes a title from the collection of books.
   * @param title Name of the title to be removed
   * @return Name of the title that was removed
*/
    public String removeTitle(String title){
      collection.remove(title);
      return(title);
    }; 
 /** This method checks out a book if it is found in the library. If the book is not found in the library, it notifies the human.
   * @param title Name of the title to be removed
*/
    public void checkOut(String title){
      if (collection.containsKey(title)){
        collection.replace(title, false);
      }
      else{ 
        System.out.println("The book " + title +" doesn't exist in this library, sorry!");
      }
        }
/** This method returns a checked out book to the library.
   * @param title Name of the title to be removed
*/    
    public void returnBook(String title){ 
      if (collection.containsKey(title)){
      collection.replace(title, true);
    }
    else{ 
      System.out.println("The book " + title +" doesn't exist in this library, sorry!");
    }
    };

/** This method checks if a certain title is contained in the collection.
   * @param title Name of the title to be removed
   * @return T/F depending on whether a book is contained in the collection.
*/   
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
      }
/** This method checks if a certain title is available to be borrowed.
   * @param title Name of the title to be removed
   * @return T/F depending on whether a book is available or not.
*/   
    public boolean isAvailable(String title){
      return collection.get(title);
      }
/** This method prints out all the books in the collection including their availability status.
*/   
    public void printCollection(){
      System.out.println(collection);

    }

    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle \n + removeTitle \n + checkOut \n + returnBook \n + containsTitle \n + isAvailable  \n + printCollection ");
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
 Library neilson = new Library("Neilson", "10 Chapin Way", 4);
 System.out.println(neilson);
 neilson.showOptions();

  
  }

}