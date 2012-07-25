package org.sg.remy.dev;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFFactory {
	
	public static EntityManagerFactory getEmf(){
		return Persistence.createEntityManagerFactory("remyPersistenceUnit");
	}

}
