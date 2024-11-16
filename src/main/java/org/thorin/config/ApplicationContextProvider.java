package org.thorin.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author pavel.arakelyan
 */
@Component
public class ApplicationContextProvider
		implements ApplicationContextAware {
	private static ApplicationContext ctx = null;

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ctx = context;
	}
}
