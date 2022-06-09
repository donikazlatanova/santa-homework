import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MagicBoard implements Observer, Observable {
  private static List<Observer> dwarves = new ArrayList<>();
  private final Queue<String> requestedToys = new LinkedList<>();

  private Santa santa;

  private static MagicBoard instance = new MagicBoard();

  public static MagicBoard getInstance() {
    return instance;
  }

  private MagicBoard() {

  }

  @Override
  public void update() {
    if (santa == null) {
      System.out.println("I serve only Santa!");
      return;
    }
    storeRequestForToy(santa.getWish());
  }

  @Override
  public void setObservable(Observable observable) {
    if (observable instanceof Santa) {
      santa = (Santa) observable;
    }
  }

  @Override
  public void subscribe(Observer dwarf) {
    dwarves.add(dwarf);
    dwarf.setObservable(this);
  }

  @Override
  public void unsubscribe(Observer dwarf) {
    dwarves.remove(dwarf);
    dwarf.setObservable(null);
  }

  @Override
  public void notifyObservers() {
    for (Observer dwarf : dwarves) {
      dwarf.update();
      if (requestedToys.isEmpty()) {
        break;
      }
    }
  }

  public String obtainNextToy() {
    return requestedToys.poll();
  }

  private void storeRequestForToy(String wishOfSanta) {
    if (wishOfSanta.equals("Bicycle!")) {
      requestedToys.add("Bicycle");
      notifyObservers();
    } else if (wishOfSanta.equals("Doll!")) {
      requestedToys.add("Doll");
      notifyObservers();
    } else {
      System.out.println("We can't craft this toy!");
    }
  }

}
