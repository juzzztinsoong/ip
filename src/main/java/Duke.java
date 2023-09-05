import duke.commands.Command;
import duke.exceptions.DukeException;
import duke.tasks.TaskList;
import duke.utils.Parser;
import duke.utils.Storage;
import duke.utils.Ui;

/**
 * @author juzzztinsoong
 */
public class Duke {

    private Storage storage;
    private TaskList tasklist;
    private Ui ui;

    /**
     * Constructor method for Duke.
     * @param filepath duke.txt filepath.
     */
    public Duke(String filepath) {
        ui = new Ui();
        storage = new Storage(filepath);
        try {
            tasklist = storage.loadFromFile();
        } catch (DukeException e) {
            ui.showError("File failed to load");
            tasklist = new TaskList();
        }
    }

    /**
     * Runs the program until the user enters a quit command.
     */
    private void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullcommand = ui.readCommand();
                Command c = Parser.parse(fullcommand);
                c.execute(tasklist, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        ui.showGoodbye();
        try {
            storage.writeToFile(tasklist);
        } catch (DukeException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Entry point for Duke. This is the main method that will be called.
     * @param args Command line arguments not used in this program.
     */
    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}
