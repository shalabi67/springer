package com.springer.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.springer.challenge.commands.Command;
import com.springer.challenge.commands.InvalidParameterException;
import com.springer.challenge.commands.QuitCommand;
import com.springer.challenge.graphics.GraphicsException;

/**
 * Paint command line application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(!QuitCommand.isQuit()) {
        	try {
				String input = reader.readLine();
				Command command = Command.create(input);
				command.execute();
			} catch(InvalidParameterException | GraphicsException invalidParam) {
				System.out.println(invalidParam.getMessage());
			}  catch (IOException e) {
				Logger.LogException(e.getMessage());
				e.printStackTrace();
			}

        }
    }
}
