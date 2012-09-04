package org.sg.remy.common.command.api;

public interface ActionService {

	<R> R doAction(Action<R> action);

}
