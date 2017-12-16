package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Controller {
    @FXML
    private MenuBar mb;
    @FXML
    private Menu mn;
    @FXML
    private AnchorPane ap;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnshop;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;

    private Main main;

    public Controller() {
    }
    @FXML
    private void btnshopaction(ActionEvent event) throws IOException {
        Stage stage2=new Stage();
        Parent root1=FXMLLoader.load(getClass().getResource("2.fxml"));
        stage2.setScene(new Scene(root1,650,400));
        stage2.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    DropShadow shadow=new DropShadow();


}