package com.springer.challenge.commands;

import java.util.List;

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
	
	protected abstract void init(List<String> parameters) throws InvalidParameter;
	
	public abstract void execute();	

}
