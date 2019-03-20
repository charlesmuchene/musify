package dev.cstv.musify.servlet;

import dev.cstv.musify.data.TestData;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Musify servlet context listener
 */
@WebListener
public class MusifyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        TestData testData = getBean(sce, "testData", TestData.class);
        testData.load();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    /**
     * Get bean with the given name and class
     * <p>
     * Helper method to get a spring managed bean
     *
     * @param event {@link ServletContextEvent} instance
     * @param name  Name of the bean
     * @param klass {@link Class} of the required bean
     * @param <T>   Type of the bean
     * @return Instance of the bean
     */
    private <T> T getBean(ServletContextEvent event, String name, Class<T> klass) {
        ServletContext servletContext = event.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        return context.getBean(name, klass);
    }
}