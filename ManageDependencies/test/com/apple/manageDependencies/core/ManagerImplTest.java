package com.apple.manageDependencies.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apple.manageDependencies.model.Software;

import junit.framework.TestCase;

class ManagerImplTest {
	private ManagerImpl manager;
	private Software sft;
	private Software sft2;
	private Software sft3;

	@BeforeEach
	void setUp() throws Exception {
		 manager = new ManagerImpl();
		  sft = new Software("Java");
		  sft2  = new Software("Java1");
		  sft3 = new Software("Java2");
	}

	@AfterEach
	void tearDown() throws Exception {
		 manager = null;
	}

	@Test
	void testInstall() throws Exception {
		   manager.depend(sft, toSet(sft2));
	        manager.depend(sft2, toSet(sft3));
	        TestCase.assertEquals(2, manager.getSoftwares().size());
	        TestCase.assertEquals(0, manager.list().size());

	}

	 @Test
	    public void cannotInstall() throws Exception {
	        manager.depend(sft, toSet(sft2));

	        TestCase.assertEquals(1, manager.getSoftwares().size());
	        TestCase.assertEquals(0, manager.list().size());

	        manager.install(sft);
	        manager.depend(sft2, toSet(sft3));
	    }

	/**
	 */
	private Set<Software> toSet(Software... software) {
        Set<Software> set = new HashSet<>(software.length);
        Collections.addAll(set, software);
        return set;
    }
}
