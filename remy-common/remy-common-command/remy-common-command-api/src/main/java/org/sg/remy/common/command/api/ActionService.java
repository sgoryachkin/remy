package org.sg.remy.common.command.api;

public interface ActionService {

	<A, R> R doAction(A command);

}
