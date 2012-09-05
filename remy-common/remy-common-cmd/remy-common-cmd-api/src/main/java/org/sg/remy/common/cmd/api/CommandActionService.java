package org.sg.remy.common.cmd.api;

public interface CommandActionService {

	<R> R doAction(CommandAction<R> action);

}
