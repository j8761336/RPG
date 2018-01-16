import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller implements Controllerstage {
    //    public static int money = 0;
    @FXML
    public MenuBar mb;
    @FXML
    private Menu mn;
    @FXML
    private AnchorPane ap;
    @FXML
    private Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    private Button btnman1;
    @FXML
    private Button btnman2;
    @FXML
    private Button btnman3;
    @FXML
    public Label moneyjlb;
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


    private StageController sc;
    public static int count = 0, money = 0, nonebtn = 1;
    public int b = 0, person = 0;

    public void setStageController(StageController s) {
        sc = s;
        if (count == 0) {
            count++;
            sc.addcontroller("Controller1", this);
            btn2.setOpacity(0.8);
            btn3.setOpacity(0.8);
        }
    }

    ///////////////menu bar/////////////////////////////////
    @FXML
    public void exit() {
        System.exit(0);
    }

    @FXML
    public void about() {
        sc.getStage(Main.mainview4).setTitle("聯絡管理員");
        sc.setStage(Main.mainview4);
    }

    @FXML
    public void reset() {
        sc.setStage(Main.mainview);
        sc.cancelStage(Main.mainview2);
        sc.cancelStage(Main.mainview3);

    }


///////////////////////////////////////////////////////////////////////

    @FXML
    private void btn1action(ActionEvent event) throws IOException {
        try {
            b = 1;
            PersonController con2 = (PersonController) sc.getController("Controller2");
            con2.moneyjlb.setText(String.valueOf(money));
            con2.moneyjlb.setAlignment(Pos.CENTER);
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);
        } catch (Exception e) {
            e.toString();
        }
    }

    @FXML
    private void btn2action(ActionEvent event) throws IOException {
        try {
            b = 2;
            PersonController con2 = (PersonController) sc.getController("Controller2");
            con2.moneyjlb.setText(String.valueOf(money));
            con2.moneyjlb.setAlignment(Pos.CENTER);
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);
        } catch (Exception e) {
            e.toString();
        }
    }


    @FXML
    private void btn3action(ActionEvent event) throws IOException {
        try {
            b = 3;
            PersonController con2 = (PersonController) sc.getController("Controller2");
            con2.moneyjlb.setText(String.valueOf(money));
            con2.moneyjlb.setAlignment(Pos.CENTER);
            sc.setStage(Main.mainview2);
            sc.cancelStage(Main.mainview);

        } catch (Exception e) {
            e.toString();
        }
    }

    public int level() {
        return b;
    }

    public void setnobtn() {
        if (nonebtn >= 2) {
            System.out.println(Controller.nonebtn);
            btn2.setId("btn2style");
            btn2.setDisable(false);
            Image img = new Image("img/unlock2.png");
            img2.setImage(img);
            if (nonebtn >= 3) {
                img3.setImage(img);
                btn3.setId("btn3style");
                btn3.setDisable(false);
            }
        }
    }


}
