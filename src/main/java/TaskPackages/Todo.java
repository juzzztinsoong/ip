package TaskPackages;

public class Todo extends Task{

  protected Todo(String description) {
    super(description);
  }
  
  @Override
  public String toString() {
    return String.format("[T][%s] %s", this.getStatusIcon(), this.description);
  }
}
