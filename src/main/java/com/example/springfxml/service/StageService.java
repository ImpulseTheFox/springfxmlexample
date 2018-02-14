package com.example.springfxml.service;

import com.example.springfxml.util.Constants;
import com.example.springfxml.util.SpringFXMLLoaderFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * A Service class for opening new stages.
 * The {@link Service @Service} annotation creates a singleton of this class,
 * accessible in various ways (e.g. the {@link org.springframework.beans.factory.annotation.Autowired @Autowired} annotation).
 */
@Service
public class StageService
{
	/**
	 * Opens the test stage.
	 *
	 * @param owner the owner window. Used for modality.
	 */
	public void openExampleStage(Window owner)
	{
		try
		{
			Stage stage = new Stage();
			FXMLLoader loader = SpringFXMLLoaderFactory.getLoader(this.getClass().getClassLoader().getResource(Constants.TEST_FXML));
			Parent root = loader.load();
			Scene scene = new Scene(root, -1, -1, false, SceneAntialiasing.BALANCED);
			stage.setScene(scene);
			stage.initOwner(owner);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.setTitle("Test Stage");
			stage.showAndWait();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
