package org.sg.remy.common.cmd.api;

public interface ActionService {

	<R> R doAction(CommandAction<R> action);

}
