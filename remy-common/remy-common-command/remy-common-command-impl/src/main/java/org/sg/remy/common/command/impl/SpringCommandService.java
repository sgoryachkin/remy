package org.sg.remy.common.command.impl;

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
public class SpringCommandService implements ActionService {

	private static Logger LOG = LoggerFactory
			.getLogger(SpringCommandService.class);

	@Autowired
	private ListableBeanFactory beanFactory;

	private Map<Class<?>, Object> handlers = new HashMap<Class<?>, Object>();

	@PostConstruct
	public void init() {

		LOG.info("Handlers searching...");
		

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

				if (handlers.put(commandClass, entry.getValue()) != null) {
					throw new IllegalStateException(
							"There is more than one implementation of handler for "
									+ commandClass.getName() + " action");
				}
			}
		}

		LOG.info("Handlers: " + handlers);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object doAction(Object command) {
		Class<?> commandClass = command.getClass();
		ActionHandler<Object, ?> handler = (ActionHandler<Object, ?>) handlers
				.get(commandClass);
		if (handler == null) {
			throw new IllegalArgumentException("Handler for action "
					+ commandClass.getName() + " is not found");
		}
		Object handleResult = handler.execute(command);
		return handleResult;
	}

}
