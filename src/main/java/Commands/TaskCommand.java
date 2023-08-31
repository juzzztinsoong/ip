package Commands;

import Tasks.TaskList;
import Utilities.Storage;
import Utilities.Ui;

public abstract class TaskCommand extends Command {

  protected String description;
  protected boolean doneness;

  public TaskCommand(String description, boolean doneness) {
    this.description = description;
    this.doneness = doneness;
  }

  @Override
  public void load(TaskList tasklist) {
  }

  @Override
  public void execute(TaskList tasklist, Ui ui, Storage storage) {
  }
}
