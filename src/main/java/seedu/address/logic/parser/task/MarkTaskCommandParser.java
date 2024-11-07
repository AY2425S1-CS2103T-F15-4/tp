package seedu.address.logic.parser.task;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.task.MarkTaskCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new MarkTaskCommand object.
 */
public class MarkTaskCommandParser implements Parser<MarkTaskCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the MarkTaskCommand
     * and returns a MarkTaskCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public MarkTaskCommand parse(String args) throws ParseException {
        String[] splitArgs = args.trim().split("\\s+");
        if (splitArgs.length == 0) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkTaskCommand.MESSAGE_USAGE));
        }
        Set<Index> targetIndexes = TaskAssignmentParserUtil.parseMultipleIndexes(splitArgs, 0);
        return new MarkTaskCommand(targetIndexes);
    }
}