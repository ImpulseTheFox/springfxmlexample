package com.example.springfxml.controller;

import com.example.springfxml.service.StageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * The controller of the main stage
 */
@Controller
public class MainController
{
	/**
	 * The button in the middle of the main stage
	 */
	@FXML
	private Button button;
	
	/**
	 * Access to the Singleton of the {@link StageService} class, Spring created for us via the {@link org.springframework.stereotype.Service @Service} annotation
	 */
	@Autowired
	private StageService dialogService;
	
	/**
	 * Gets called when we press the {@link #button} in the middle of the main stage.
	 *
	 * @param event the ActionEvent. Can be used for various stuff, but not needed in this case.
	 */
	@FXML
	void buttonPressed(ActionEvent event)
	{
		this.dialogService.openExampleStage(this.button.getScene().getWindow());
	}
}
