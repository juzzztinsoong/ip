package duke.exceptions;

/**
 * @author juzzztinsoong
 */
public class InvalidNumberException extends DukeException {

    public InvalidNumberException() {
        super("You didn't specify the task number!");
    }
}
