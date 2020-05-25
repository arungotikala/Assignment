package com.apple.manageDependencies.commands;

import com.apple.manageDependencies.Command;
import com.apple.manageDependencies.core.Manager;
import com.apple.manageDependencies.model.Software;

/**
 * This class is used to decouple using Liskov Substitution Principle 
 * @author gotik
 *
 */
public abstract class AbstractCommand implements Command {

	protected Manager<Software> manager;

	public abstract String executeCommand(String[] args) throws Exception;

	/**
	 * 
	 */
	public String executeCmd(String[] args) throws Exception {
        try {
        	
            return executeCommand(args);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
		return null;
    }

	/**
	 * 
	 * @return
	 */
	public Manager<Software> getManager() {
		return manager;
	}

	/**
	 * 
	 * @param manager
	 */
	public void setManager(Manager<Software> manager) {
		this.manager = manager;
	}

	/**
	 * 
	 * @param args
	 * @param count
	 * @throws Exception
	 */
	protected void hasExactNumberOfArguments(String[] args, int count) throws Exception {
		if (args.length != count) {
			throw new Exception(
					"Incorrect number of command arguments");
		}
	}



}
