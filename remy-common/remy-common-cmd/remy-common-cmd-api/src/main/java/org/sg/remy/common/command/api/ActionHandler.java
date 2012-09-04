package org.sg.remy.common.command.api;

/**
 * @author Semyon Goryachkin
 * 
 * @param <A>
 *            - action
 * @param <R>
 *            - result
 */
public interface ActionHandler<A extends Action<R>, R> {

	R execute(A command);

}
