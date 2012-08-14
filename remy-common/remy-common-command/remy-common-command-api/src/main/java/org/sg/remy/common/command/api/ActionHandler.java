package org.sg.remy.common.command.api;

/**
 * @author Semyon Goryachkin
 * 
 * @param <A>
 *            - action
 * @param <R>
 *            - result
 */
public interface ActionHandler<A, R> {

	R execute(A command);

}
