package duke.tasks;

public class Todo extends Task {

  public Todo(String description, boolean doneness) {
    super(description, doneness);
  }

  /**
  * Returns a String representation of this Todo. The format is "[T][StatusIcon] Description"
  * 
  * 
  * @return a String representation of this Todo.
  */
  @Override
  public String toString() {
    return String.format("[T][%s] %s", this.getStatusIcon(), this.description);
  }

  /**
  * Returns a string representation of this Todo. The format is T # Doneness # Description.
  * Note that this is different from toString() as it is used for encoding data in the file.
  * 
  * 
  * @return a string representation of this Todo for storage in the file.
  */
  @Override
  public String toFileString() {
    return String.format("T # %d # %s", (doneness ? 1 : 0), this.description);
  }
}
