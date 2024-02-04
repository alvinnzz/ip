package Duke.Commands;

import Duke.DukeException;
import Duke.Storage;
import Duke.TaskList;
import Duke.Ui;

/**
 * Represents a command to print an error.
 */
public class ErrorCommand extends Command {
    Ui ui;
    TaskList taskList;
    Storage storage;
    String error;

    /**
     * Constructor for the ErrorCommand class.
     *
     * @param ui The Ui object to interact with user.
     * @param taskList The taskList object to record the tasks.
     * @param storage The Storage object to save and load information.
     * @param error The error message to be printed.
     */
    public ErrorCommand(Ui ui, TaskList taskList, Storage storage, String error) {
        this.ui = ui;
        this.taskList = taskList;
        this.storage = storage;
        this.error = error;
    }
    @Override
    public void execute() throws DukeException {
        this.ui.printErrorMessage(this.error);
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
