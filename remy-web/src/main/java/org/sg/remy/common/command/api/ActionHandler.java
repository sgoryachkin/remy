package org.sg.remy.common.command.api;

public interface ActionHandler<T, R> {
	
	
	R execute(T command);
	
	
}
