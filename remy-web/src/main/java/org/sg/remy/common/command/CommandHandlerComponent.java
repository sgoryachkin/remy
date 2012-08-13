package org.sg.remy.common.command;

import org.springframework.stereotype.Component;

@Component
public @interface CommandHandlerComponent{
	
	Class<?> command();
	
}
