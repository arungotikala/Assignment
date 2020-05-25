package com.apple.manageDependencies.core;

import java.util.Set;

import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 * @param <T>
 */
public interface Manager<T extends Software> {
	Set<T> install(T program) throws Exception;

	void depend(T source, Set<T> dest) throws Exception;

	Set<T> remove(T program) throws Exception;

	Set<Software> list() throws Exception;
}
