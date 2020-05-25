package com.apple.manageDependencies.commands;

import java.util.Arrays;

import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 */
public class DependCommand extends AbstractCommand {
    @Override
    public String executeCommand(String[] args) throws Exception {
        //verifyHasMinimumNumberOfArguments(args, 3);
    	manager.depend(new Software(args[1]),
                Software.createSoftware(Arrays.copyOfRange(args, 2, args.length)));

        return null;
    }
}
