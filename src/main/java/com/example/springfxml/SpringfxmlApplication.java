package com.example.springfxml;

import com.example.springfxml.util.Constants;
import com.example.springfxml.util.SpringFXMLLoaderFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * The main class, launching the application and starting the main stage
 */
@SpringBootApplication
public class SpringfxmlApplication extends Application
{
	/**
	 * Launches the application
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	/**
	 * Starts the main stage
	 *
	 * @param primaryStage the main stage
	 */
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			FXMLLoader loader = SpringFXMLLoaderFactory.getLoader(this.getClass().getClassLoader().getResource(Constants.MAIN_FXML), super.getParameters().getRaw().toArray(new String[0]));
			Parent root = loader.load();
			Scene scene = new Scene(root, -1, -1, false, SceneAntialiasing.BALANCED);
			primaryStage.setTitle("Main Stage");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
