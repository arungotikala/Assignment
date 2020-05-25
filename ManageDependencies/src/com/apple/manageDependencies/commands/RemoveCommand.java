package com.apple.manageDependencies.commands;

import java.util.Set;

import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 */
public class RemoveCommand extends AbstractCommand {
    @Override
    public String executeCommand(String[] args) throws Exception {
        hasExactNumberOfArguments(args, 2);

        Set<Software> installed = manager.remove(new Software(args[1]));

        StringBuilder response = new StringBuilder();
        for (Software program : installed) {
            response.append("\tRemoving ").append(program.getName()).append("\n");
        }

        return response.toString();
    }
}
