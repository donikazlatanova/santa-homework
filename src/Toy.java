
public class Toy {
  private String greetings;

  public void setGreetings(String greetings) {
    this.greetings = greetings;
  }

  public String getGreetings() {
    return greetings;
  }

  @Override
  public String toString() {
    return "Hello, child! " + "May this toy bring you much joy! " + getGreetings();
  }

}
