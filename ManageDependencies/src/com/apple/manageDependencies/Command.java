package com.apple.manageDependencies;

/**
 * Command Pattern Implementation
 * @author gotik
 *
 */
@FunctionalInterface
public interface Command {
	String executeCmd(String[] args) throws Exception;
}
