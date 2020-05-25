package com.apple.manageDependencies.commands;

import java.util.Set;

import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 */
public class InstallCommand extends AbstractCommand {
	@Override
	public String executeCommand(String[] args) throws Exception {
		StringBuilder response = new StringBuilder();
		hasExactNumberOfArguments(args, 2);
		Set<Software> installed = manager.install(new Software(args[1]));
		for (Software program : installed) {
			response.append("\tInstalling ").append(program.getName()).append("\n");
		}

		return response.toString();
	}
}
