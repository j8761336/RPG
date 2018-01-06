import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller implements Controllerstage {
    @FXML
    private MenuBar mb;
    @FXML
    private Menu mn;
    @FXML
    private AnchorPane ap;
    @FXML
    private AnchorPane ap2;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnman1;
    @FXML
    private Button btnman2;
    @FXML
    private Button btnman3;
    @FXML
    private Button btnshop;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView imgman1;
    @FXML
    private ImageView imgman2;
    @FXML
    private ImageView imgman3;
    @FXML
    private ImageView img[] = new ImageView[16];

    private StageController sc;
    public static int count = 0;
    public int b = 0;

    public void setStageController(StageController s) {
        sc = s;

        if (count == 0) {
            sc.addcontroller("Controller1", this);
            count++;
        } else {
            sc.addcontroller("Controller2", this);
        }
    }
    @FXML
    private void btnshopaction(ActionEvent event) throws IOException {
        try {
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);

        } catch (Exception e) {
            e.toString();
        }
    }

    @FXML
    private void btn1action(ActionEvent event) throws IOException {
        try {
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);
        } catch (Exception e) {
            e.toString();
        }
    }

    @FXML
    private void btn2action(ActionEvent event) throws IOException {
        try {
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);
        } catch (Exception e) {
            e.toString();
        }
    }

    @FXML
    private void btn3action(ActionEvent event) throws IOException {
        try {
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);
        } catch (Exception e) {
            e.toString();
        }
    }

    @FXML
    private void prevbtn(ActionEvent event) throws IOException {
        try {
            sc.setStage(Main.mainview);
            sc.cancelStage(Main.mainview2);
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void btnman1(ActionEvent event) throws IOException {
        try {
            mapController con = (mapController) sc.getController("Controller3");
            con.init(1);
            sc.cancelStage(Main.mainview2);
            sc.setStage(Main.mainview3);
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void btnman2(ActionEvent event) throws IOException {
        try {
            mapController con = (mapController) sc.getController("Controller3");
            con.init(2);
            sc.cancelStage(Main.mainview2);
            sc.setStage(Main.mainview3);
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void btnman3(ActionEvent event) throws IOException {
        try {
            mapController con = (mapController) sc.getController("Controller3");
            con.init(3);
            sc.cancelStage(Main.mainview2);
            sc.setStage(Main.mainview3);
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }



}
