package com.apple.manageDependencies;

import java.util.HashMap;
import java.util.Map;

import com.apple.manageDependencies.commands.DependCommand;
import com.apple.manageDependencies.commands.InstallCommand;
import com.apple.manageDependencies.commands.ListCommand;
import com.apple.manageDependencies.commands.RemoveCommand;
import com.apple.manageDependencies.core.Manager;
import com.apple.manageDependencies.core.ManagerImpl;
import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 */
public class CmdFactory {

	Map<String, Command> commands;

	private CmdFactory() {
		commands = new HashMap<>();
	}

	public void addCommand(CommandEnum name, Command command) {
		commands.put(name.toString(), command);
	}

	public String execute(String[] args) throws Exception {
		Command command = commands.get(args[0]);
		if (command != null) {
			return command.executeCmd(args);
		}
		return "Command not found!";
	}

	public static CmdFactory init() {
        CmdFactory cf = new CmdFactory();
        Manager<Software> manager = new ManagerImpl();
        
        InstallCommand addCommand = new InstallCommand();
        addCommand.setManager(manager);
        cf.addCommand(CommandEnum.INSTALL, addCommand);
        DependCommand dependCommand = new DependCommand();
        dependCommand.setManager(manager);
        cf.addCommand(CommandEnum.DEPEND, dependCommand);
        ListCommand listCommand = new ListCommand();
        listCommand.setManager(manager);
        cf.addCommand(CommandEnum.LIST, listCommand);
        RemoveCommand removeCommand = new RemoveCommand();
        removeCommand.setManager(manager);
        cf.addCommand(CommandEnum.REMOVE, removeCommand);
        return cf;
    }
}
