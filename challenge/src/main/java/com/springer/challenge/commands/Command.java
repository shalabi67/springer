package com.springer.challenge.commands;

import java.util.List;

/**
 * This class in responsible to validate command parameters and execute the command by creating the right graphics
 * object and call draw method on it.
 */
public abstract class Command {
	public static Command create(String inputCommand) throws InvalidParameter {
		List<String> parameters = StringParser.parse(inputCommand);
		Command command = null;
		if(parameters.size() == 0) {
			command = new InvalidCommand("Expected valid command.");
		}
		else {
			char commandType = getCommand(parameters.get(0));
			switch(commandType) {
				
			}
			
		}
		
		command.init(parameters);
		return command;
		
	}
	private static char getCommand(String input) throws InvalidParameter {
		if(null == input || input.length() != 1 ) {
			throw new InvalidParameter("Unknown command.");
		}

		return input.charAt(0);
	}

	/**
	 * validate input parameter and initialize the command class.
	 * @param parameters an ArrayList of string represents the input parameter for a specific command.
	 * @throws InvalidParameter
     */
	protected abstract void init(List<String> parameters) throws InvalidParameter;

	/**
	 * execute command.
     */
	public abstract void execute();	

}
