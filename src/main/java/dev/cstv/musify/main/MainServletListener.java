package dev.cstv.musify.main;

import dev.cstv.musify.resources.PlayResource;
import dev.cstv.musify.resources.SongResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Main Servlet context listener
 */
@WebListener
public class MainServletListener implements ServletContextListener {

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