package org.sg.remy.common.command.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.sg.remy.common.command.api.ActionHandler;
import org.sg.remy.common.command.api.ActionService;
import org.sg.remy.common.command.api.Handler;
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
		Map.Entry<String, ActionHandler> entry : beanFactory.getBeansOfType(
				ActionHandler.class).entrySet()) {

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


	@SuppressWarnings("unchecked")
	@Override
	public Object doAction(Object action) {
		Class<?> commandClass = action.getClass();
		@SuppressWarnings("rawtypes")
		ActionHandler handler = (ActionHandler) handlers
				.get(commandClass);
		if (handler == null) {
			throw new IllegalArgumentException("Handler for action "
					+ commandClass.getName() + " is not found");
		}
		Object handleResult = handler.execute(action);
		return handleResult;
	}
}