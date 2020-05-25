package com.apple.manageDependencies.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author gotik
 *
 */
public class Software {
    private String name;
    private Set<Software> dependencies;

    public Software(String name) {
        this.name = name;
        dependencies = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Software> getDependencies() {
        return this.dependencies;
    }

    public boolean addDependency(Software program) {
        return dependencies.add(program);
    }

      @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Software other = (Software) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static Set<Software> createSoftware(String[] programs) {
        Set<Software> set = new HashSet<>(programs.length);
        for (String programName : programs) {
            set.add(new Software(programName));
        }
        return set;
    }
}
