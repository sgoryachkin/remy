package org.sg.remy.common.command.api;

public interface ActionService {

	<R> R doAction(CommandAction<R> action);

}
