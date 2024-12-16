package org.example.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * Returns the configuration classes for the DispatcherServlet application context.
     * This context is specific to the DispatcherServlet and typically holds MVC-related beans.
     * Here, we use the AppConfig class to load the Spring MVC configuration.
     *
     * @return an array containing the AppConfig class, which configures Spring MVC
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {AppConfig.class};
    }

    /**
     * Returns the servlet mappings for the DispatcherServlet.
     * This method defines which URL patterns the DispatcherServlet should handle.
     * In this case, we map the DispatcherServlet to handle all URLs ("/").
     *
     * @return an array containing the root URL mapping ("/")
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
