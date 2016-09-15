package com.springer.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.springer.challenge.commands.Command;
import com.springer.challenge.commands.InvalidParameter;
import com.springer.challenge.commands.QuitCommand;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

        while(!QuitCommand.isQuit()) {
        	try {
				String input = reader.readLine();
				Command command = Command.create(input);
				command.execute();
			} catch(InvalidParameter invalidParam) {
				System.out.println(invalidParam.getMessage());
			} catch (IOException e) {
				Logger.LogException(e.getMessage());
				e.printStackTrace();
			}

        }
    }
}
