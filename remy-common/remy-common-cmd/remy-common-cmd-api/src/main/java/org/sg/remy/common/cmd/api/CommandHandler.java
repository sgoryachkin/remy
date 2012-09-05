package org.sg.remy.common.cmd.api;

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
