package org.sg.remy.common.cmd.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.sg.remy.common.cmd.api.ActionService;
import org.sg.remy.common.cmd.api.CommandAction;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements ActionService {

	private static Logger LOG = LoggerFactory
			.getLogger(CommandServiceImpl.class);

	@Autowired
	private ListableBeanFactory beanFactory;

	private Map<Class<?>, Object> handlers = null;

	@PostConstruct
	public void init() {

		LOG.info("Handlers searching...");
		
		Map<Class<?>, Object> localHandlers = new HashMap<Class<?>, Object>();
		

		for (@SuppressWarnings("rawtypes")
		Map.Entry<String, CommandHandler> entry : beanFactory.getBeansOfType(
				CommandHandler.class).entrySet()) {

			Handler docReportAnnotation = beanFactory.findAnnotationOnBean(
					entry.getKey(), Handler.class);

			for (Class<?> commandClass : docReportAnnotation.action()) {
				LOG.info("Bean name: " + entry.getKey() + ", bean: "
						+ entry.getValue() + ", bean class: "
						+ entry.getValue().getClass() + ", "
						+ Handler.class.getSimpleName() + " value = "
						+ docReportAnnotation.action());

				if (localHandlers.put(commandClass, entry.getValue()) != null) {
					throw new IllegalStateException(
							"There is more than one implementation of handler for "
									+ commandClass.getName() + " action");
				}
			}
		}
		
		handlers = Collections.unmodifiableMap(localHandlers);

		LOG.info("Handlers: " + handlers);
	}


	@Override
	public <R> R doAction(CommandAction<R> action) {
		Class<?> commandClass = action.getClass();
		@SuppressWarnings("unchecked")
		CommandHandler<CommandAction<R>, R> handler = (CommandHandler<CommandAction<R>, R>) handlers
				.get(commandClass);
		if (handler == null) {
			throw new IllegalArgumentException("Handler for action "
					+ commandClass.getName() + " is not found");
		}
		R handleResult = handler.execute(action);
		return handleResult;
	}
}