package org.sg.remy.business;

import javax.annotation.PostConstruct;

import org.sg.remy.business.service.InitReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDBComponent {
	
	@Autowired
	InitReferenceService initReferenceService;
	
	@PostConstruct
	public void init(){
		
		System.out.println(initReferenceService.updateCategory());
	}

}
