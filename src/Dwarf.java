import java.util.Arrays;
import java.util.LinkedList;

public class Dwarf implements DwarfObserver {
  private MagicBoard magicBoard;
  private boolean needsRest = false;

  @Override
  public void setObservable(Observable observable) {
    if (observable instanceof MagicBoard) {
      this.magicBoard = (MagicBoard) observable;
    }
  }

  @Override
  public void update() {
    if (needsRest) {
      needsRest = false;
      return;
    }
    String toyRequest = magicBoard.obtainNextToy();
    Toy obtainedToy;
    if (toyRequest.equals("Bicycle")) {
      obtainedToy = WorkShop.getBicycle();
    } else {
      obtainedToy = WorkShop.getDoll();
    }
    if (null != obtainedToy) {
      Santa.collectionOfToys.add(obtainedToy);
    }
    needsRest = true;
  }

  @Override
  public void createToys() {
    LinkedList<Toy> dollCollection =
        new LinkedList<>(Arrays.asList(new Doll(), new Doll(), new Doll()));
    WorkShop.addDollsToCollection(dollCollection);
    LinkedList<Toy> bibycleCollection =
        new LinkedList<>(Arrays.asList(new Bicycle(), new Bicycle(), new Bicycle()));
    WorkShop.addBicyclesToCollection(bibycleCollection);
  }
}
