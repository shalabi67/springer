package com.springer.challenge.commands;

import java.util.List;

public class InvalidCommand extends Command {
	private String error;
	InvalidCommand(String error) {
		this.error = error;		
	}
	
	@Override
	protected void init(List<String> parameters) {
	}
	
	@Override
	public void execute() {
		//TODO: we need to show a help message here
		System.out.println(error);		
	}

}
