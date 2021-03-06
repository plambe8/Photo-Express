package appDesign;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import appData.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Launches the program
 * @author Peter Lambe and Le Liu - Photo Album 40
 */

public class PhotoAlbum extends Application {

	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		PhotoAlbum.primaryStage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			Scene scene = new Scene(root, 526, 249);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/appDesign/icon.png"));
			primaryStage.setTitle("PhotoExpress - Login");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		
	}

	
		

}
