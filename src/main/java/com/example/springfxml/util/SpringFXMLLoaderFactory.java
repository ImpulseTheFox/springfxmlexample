package com.example.springfxml.util;

import com.example.springfxml.SpringfxmlApplication;
import javafx.fxml.FXMLLoader;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.net.URL;
import java.nio.charset.Charset;

/**
 * The helper-class for creating new {@link FXMLLoader FXMLLoaders} (e.g. to open a new stage).
 */
public class SpringFXMLLoaderFactory
{
	/**
	 * The current {@link ApplicationContext}. Created and assigned, when the {@link #getLoader(URL, String[])} method is called for the first time.
	 */
	private static ApplicationContext appContext;
	
	/**
	 * Convenience method so you don't have to pass <code>null</code> if you don't have args.
	 *
	 * @param url the URL to the FXML-file
	 * @return the FXMLLoader, ready for loading
	 */
	public static FXMLLoader getLoader(URL url)
	{
		return SpringFXMLLoaderFactory.getLoader(url, null);
	}
	
	/**
	 * First, creates a new Spring ApplicationContext with the arguments, if there is none.
	 * Then, creates a new FXMLLoader with the URL and a reference to the {@link org.springframework.beans.factory.BeanFactory#getBean(Class)}
	 * method of the just created application context as a ControllerFactory.
	 *
	 * @param url the URL to the FXML-file
	 * @param args arguments or <code>null</code>
	 * @return the FXMLLoader, ready for loading
	 */
	public static FXMLLoader getLoader(URL url, String[] args)
	{
		if (appContext == null)
		{
			if (args == null)
			{
				args = new String[0];
			}
			
			SpringApplication app = new SpringApplication(SpringfxmlApplication.class);
			app.setBannerMode(Mode.OFF);
			SpringFXMLLoaderFactory.appContext = app.run(args);
		}

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		loader.setCharset(Charset.forName("UTF-8"));
		loader.setControllerFactory(SpringFXMLLoaderFactory.appContext::getBean);
		return loader;
	}
}
