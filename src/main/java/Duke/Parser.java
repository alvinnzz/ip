package Duke;

import Duke.Commands.*;
import Duke.Tasks.Task;

public class Parser {
    enum CommandWords {
        BYE,
        ADD,
        DELETE,
        LIST,
        MARK,
        UNMARK
    }

    public static Command parse(String input, Ui ui, TaskList taskList, Storage storage) throws DukeException {
        try {
            String[] inputs = input.split(" ");
            CommandWords commandWord = CommandWords.valueOf(inputs[0].toUpperCase());
            switch (commandWord) {
                case BYE:
                    return new GoodbyeCommand(ui, taskList, storage);
                case DELETE:
                    return new DeleteCommand(ui, taskList, storage, Integer.parseInt(inputs[inputs.length - 1]));
                case LIST:
                    return new PrintListCommand(ui, taskList, storage);
                case MARK:
                    return new MarkDoneCommand(ui, taskList, storage, Integer.parseInt(inputs[inputs.length - 1]));
                case UNMARK:
                    return new MarkUndoneCommand(ui, taskList, storage, Integer.parseInt(inputs[inputs.length - 1]));
                case ADD:
                    return new AddCommand(ui, taskList, storage, input);
                default:
                    return new ErrorCommand(ui, taskList, storage,
                            "Please use the correct command Word!>.<");
            }
        } catch (Exception e) {
            return new ErrorCommand(ui, taskList, storage,
                    "Please use the correct command Word!>.<");
        }
    }
}