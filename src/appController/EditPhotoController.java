package appController;

import java.net.URL;
import java.util.ResourceBundle;

import appData.Admin;
import appData.Photo;
import appData.Tag;
import appData.User;
import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controls the Edit Photo Controller
 * @author Peter Lambe and Le Liu - Photo Album 40
 */

public class EditPhotoController implements Initializable {

  @FXML
  TextField caption;

  @FXML
  TextField tagValue;
  @FXML
  TextField tagType;

  @FXML
  ListView<Tag> listViewofTags;

  Tag selectedTag;
  User loggedIn = LoginSceneController.getLoggedInUser();

  public void editPhoto(ActionEvent event) {

    Photo photo = PhotoDisplaySceneController.getSelectedPhoto();

    photo.editCaption(caption.getText(), loggedIn);
    Admin.updateUser(loggedIn);
        //photo.editTags(tags.getText(), loggedIn);
        //photo.setPreTags(tags.getText());
    ((Node) (event.getSource())).getScene().getWindow().hide();

  }

  public void deleteTag(ActionEvent event){
    Photo photo = PhotoDisplaySceneController.getSelectedPhoto();
    photo.removeTag(selectedTag);
    listViewofTags.setItems(FXCollections.observableList(photo.getTags(photo)));
    listViewofTags.getSelectionModel().select(0);
    Admin.updateUser(loggedIn);
  }

  public void addTag(ActionEvent event){
    Photo photo = PhotoDisplaySceneController.getSelectedPhoto();

    Tag newTag = new Tag(tagValue.getText(), tagType.getText());
    photo.addTag(newTag);
    listViewofTags.setItems(FXCollections.observableList(photo.getTags(photo)));
    listViewofTags.getSelectionModel().select(0);
    Admin.updateUser(loggedIn);
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    Photo photo = PhotoDisplaySceneController.getSelectedPhoto();
    listViewofTags.setItems(FXCollections.observableList(photo.getTags(photo)));

    listViewofTags.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue == null) {
        return;
      }
      selectedTag = newValue;
    }
    );
    listViewofTags.getSelectionModel().select(0);
    caption.setText(photo.getCaption());

  }
    //tags.setText(photo.getPreTags());
}
