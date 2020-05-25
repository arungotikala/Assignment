package com.apple.manageDependencies.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.apple.manageDependencies.model.Software;

/**
 * 
 * @author gotik
 *
 */
public class ManagerImpl implements Manager<Software> {
	private Map<Software, Set<Software>> newDependencies;
	private Set<Software> installed;

	/**
	 * constructor
	 */
	public ManagerImpl() {
		newDependencies = new HashMap<>();
		installed = new HashSet<>();
	}

	/**
	 * 
	 */
	@Override
	public Set<Software> install(Software software) throws Exception {
		// TODO Auto-generated method stub
		isInstalled(software);
		this.installed.add(software);
		return this.installed;
	}

	/**
	 * 
	 * @param software
	 * @throws Exception
	 */
	private void isInstalled(Software software) throws Exception {
		// TODO Auto-generated method stub
		if (this.installed.contains(software)) {
			throw new Exception("Already Installed...");
		}
	}

	/**
	 * 
	 */
	@Override
	public void depend(Software source, Set<Software> dest) throws Exception {
		// TODO Auto-generated method stub
		isSoftwareNull(source);
		if (this.installed.contains(source)) {
			throw new Exception("Cannot add a new dependency that is installed.");
		}

		for (Iterator<Software> iterator = dest.iterator(); iterator.hasNext();) {
			Software software = (Software) iterator.next();
			if (!newDependencies.containsKey(software)) {
				newDependencies.put(software, new HashSet<>());
			}
			source.addDependency(software);
			newDependencies.get(software).add(source);

		}

	}

	private void isSoftwareNull(Software source) throws Exception {
		if (null == source) {
			throw new Exception("software connot be null");
		}
	}

	@Override
	public Set<Software> remove(Software software) throws Exception {
		Set<Software> removed = new HashSet<>();
		// TODO Auto-generated method stub
		if (checkIfInstalled(software)) {
			removed.add(software);
			this.installed.remove(software);
		}
		return removed;
	}

	/**
	 * 
	 * @param software
	 * @throws Exception
	 */
	private boolean checkIfInstalled(Software software) throws Exception {
		// TODO Auto-generated method stub
		return this.installed.contains(software);
	}

	/**
	 * 
	 */
	@Override
	public Set<Software> list() throws Exception {
		// TODO Auto-generated method stub
		return this.installed;
	}

	/**
	 * 
	 * @return
	 */
	public Set<Software> getSoftwares() {
		return newDependencies.keySet();
	}

	/**
	 * 
	 * @param program
	 * @return
	 */
	public Software getSoftware(Software program) {
		return newDependencies.keySet().stream().filter(p -> p.equals(program)).findFirst().orElse(program);
	}

}
