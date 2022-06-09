
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WorkShop {
  private static final Queue<Toy> collectionOfDolls = new LinkedList<>();
  private static final Queue<Toy> collectionOfBicycles = new LinkedList<>();

  public static void addDollsToCollection(List<Toy> dolls) {
    collectionOfDolls.addAll(dolls);
  }

  public static void addBicyclesToCollection(List<Toy> bicycles) {
    collectionOfBicycles.addAll(bicycles);
  }

  public static Toy getBicycle() {
    return collectionOfBicycles.poll();
  }

  public static Toy getDoll() {
    return collectionOfDolls.poll();
  }
}
