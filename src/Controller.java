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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Controller{
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

    Window node;

    public Controller() {
    }
//public Controller() {
//
//}
    @FXML
    private void btnshopaction(ActionEvent event) throws IOException {
        Stage stage2=new Stage();
        Parent root1=FXMLLoader.load(getClass().getResource("2.fxml"));
        stage2.setScene(new Scene(root1,650,400));
        stage2.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    private void btn1action(ActionEvent event)throws IOException{
        Stage stage2=new Stage();
        Parent root1=FXMLLoader.load(getClass().getResource("2.fxml"));
        stage2.setScene(new Scene(root1,650,400));
        stage2.show();
        node=((Node)(event.getSource())).getScene().getWindow();
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    private void prevbtn(ActionEvent event)throws IOException{

    }

}