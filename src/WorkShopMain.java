import java.util.Set;

public class WorkShopMain {
  private static final String BICYCLE = "Bicycle!";
  private static final String DOLL = "Doll!";

  public static void main(String[] args) {
    var santa = Santa.getInstance();
    var board = MagicBoard.getInstance();
    DwarfObserver Johny = new Dwarf();
    DwarfObserver Michael = new Dwarf();
    DwarfObserver Frank = new Dwarf();

    Set<DwarfObserver> workers = Set.of(Johny, Michael, Frank);

    for (DwarfObserver dwarf : workers) {
      dwarf.createToys();
    }

    board.subscribe(Johny);
    board.subscribe(Michael);
    board.subscribe(Frank);
    santa.subscribe(board);

    santa.requestToy(BICYCLE);
    santa.requestToy(BICYCLE);
    santa.requestToy(DOLL);
    santa.requestToy(BICYCLE);
    santa.requestToy(DOLL);

    santa.obtainToysFromCollection().forEach(toy -> {
      toy.setGreetings("Love from Santa!");
      System.out.println(toy.toString());
      System.out.println("Toy type: " + toy.getClass());
    });


  }
}


