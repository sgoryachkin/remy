package org.sg.remy.common.command;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommandServiceImpl implements CommandService {
	
	private static Logger LOG = LoggerFactory.getLogger(CommandServiceImpl.class);

	@Autowired
	private ListableBeanFactory beanFactory;
	
	private Map<Class<?>, Object> handlers = new HashMap<Class<?>, Object>();
	
	@PostConstruct
	public void init(){
		
		LOG.info("Handlers searching...");

		for (Map.Entry<String, Object> entry : beanFactory
				.getBeansWithAnnotation(CommandHandlerComponent.class).entrySet()) {

			CommandHandlerComponent docReportAnnotation = beanFactory
					.findAnnotationOnBean(entry.getKey(), CommandHandlerComponent.class);

			LOG.info("Bean name: " + entry.getKey() + ", bean: "
					+ entry.getValue() + ", bean class: "
					+ entry.getValue().getClass() + ", "
					+ CommandHandlerComponent.class.getSimpleName() + " value = "
					+ docReportAnnotation.command());

				if (handlers.put(docReportAnnotation.command(), entry.getValue()) != null) {
					throw new IllegalStateException(
							"There is more than one implementation of handler for "
									+ docReportAnnotation.command().getSimpleName() + " command");
				}
		}

		LOG.info("Handlers: " + handlers);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object doCommand(Object command) {
		Class<?> commandClass = command.getClass();
		CommandHandler<Object, ?> handler = (CommandHandler<Object, ?>) handlers.get(commandClass);
		Object handleResult = handler.execute(command);
		return handleResult;
	}

}
