package org.sg.remy.common.command.api;

/**
 * @author Semyon Goryachkin
 * 
 * @param <A>
 *            - action
 * @param <R>
 *            - result
 */
public interface CommandHandler<A extends CommandAction<R>, R> {

	R execute(A command);

}
