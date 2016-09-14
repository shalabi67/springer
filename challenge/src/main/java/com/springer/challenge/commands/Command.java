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
			switch(parameters.get(0)) {
				
			}
			
		}
		
		command.init(parameters);
		return command;
		
	}
	
	protected abstract void init(List<String> parameters) throws InvalidParameter;
	
	public abstract void execute();	

}
