package h2.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MyConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
