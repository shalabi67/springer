package com.springer.challenge.commands;

import com.springer.challenge.Logger;

import java.util.List;

/**
 * This class in responsible to validate command parameters and execute the command by creating the right graphics
 * object and call draw method on it.
 */
public abstract class Command {
	public static Command create(String inputCommand) {
		List<String> parameters = StringParser.parse(inputCommand);
		Command command = new InvalidCommand("Expected valid command.");;
		if(parameters.size() == 0) {
			return command;
		}
		else {
			char commandType = getCommand(parameters.get(0).toLowerCase());
			switch(commandType) {
				case 'c': command = new CanvasCommand(); break;
				case 'q': command = new QuitCommand();break;
				case 'l': command = new LineCommand(); break;
				case 'r': command = new RectangleCommand(); break;
			}
			
		}
		
		command.init(parameters);
		return command;
		
	}
	private static char getCommand(String input) {
		if(null == input || input.length() != 1 ) {
			throw new InvalidParameterException("Unknown command.");
		}

		return input.charAt(0);
	}

	/**
	 * validate input parameter and initialize the command class.
	 * @param parameters an ArrayList of string represents the input parameter for a specific command.
	 * @throws InvalidParameterException
     */
	protected abstract void init(List<String> parameters);

	/**
	 * execute command.
     */
	public abstract void execute();




}
