package com.apple.manageDependencies.commands;

import java.util.Set;

import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 */
public class ListCommand extends AbstractCommand {
	@Override
	public String executeCommand(String[] args) throws Exception {
		hasExactNumberOfArguments(args, 1);
		Set<Software> installed = manager.list();
		StringBuilder response = new StringBuilder();
		for (Software program : installed) {
			response.append("\t").append(program.getName()).append("\n");
		}

		return response.toString();
	}
}
