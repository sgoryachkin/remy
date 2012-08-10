package org.sg.remy.common.command;

public interface CommandHandler<T, R> {
	
	
	R execute(T command);
	
	
}
