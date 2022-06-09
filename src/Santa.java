import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Santa implements Observable {

  private static Santa instance = new Santa();

  private Observer magicBoard;
  private String wish;
  protected static final List<Toy> collectionOfToys = new ArrayList<>();

  private Santa() {}

  public static Santa getInstance() {
    return instance;
  }

  @Override
  public void subscribe(Observer magicBoard) {
    this.magicBoard = magicBoard;
    magicBoard.setObservable(this);
  }

  @Override
  public void unsubscribe(Observer magicBoard) {
    this.magicBoard = magicBoard;
    magicBoard.setObservable(null);
  }

  @Override
  public void notifyObservers() {
    magicBoard.update();
  }

  public String getWish() {
    return wish;
  }

  public void requestToy(String wish) {
    this.wish = wish;
    notifyObservers();
  }

  public Stream<Toy> obtainToysFromCollection() {
    return collectionOfToys.stream().limit(5);
  }

}
