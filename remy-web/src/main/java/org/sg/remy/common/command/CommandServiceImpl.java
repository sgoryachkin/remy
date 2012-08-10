package org.sg.remy.common.command;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class CommandServiceImpl implements CommandService {
	
	private Map<Class<?>, CommandHandler<?,?>> handlers = new HashMap<Class<?>, CommandHandler<?,?>>();
	
	@PostConstruct
	public void init(){
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object doCommand(Object command) {
		Class<?> commandClass = command.getClass();
		@SuppressWarnings("rawtypes")
		CommandHandler handler = handlers.get(commandClass);
		Object handleResult = handler.execute(command);
		return handleResult;
	}

}
