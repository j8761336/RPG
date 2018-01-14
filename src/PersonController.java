import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class PersonController implements Controllerstage {
    @FXML
    public MenuBar mb;
    @FXML
    private Menu mn;
    @FXML
    private AnchorPane ap;
    @FXML
    public Button btnman1;
    @FXML
    public Button btnman2;
    @FXML
    public Button btnman3;
    @FXML
    public Label moneyjlb;
    @FXML
    private ImageView imgman1;
    @FXML
    private ImageView imgman2;
    @FXML
    private ImageView imgman3;
    @FXML
    private Button buyman2;
    @FXML
    private Button buyman3;


    private StageController sc;
    public int b = 0, person = 0;

    public void setStageController(StageController s) {
        sc = s;
        sc.addcontroller("Controller2", this);
    }
////////////////////menu bar/////////////////////////////////
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
//////////////////////////////////////////////////////////////

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
            person = 1;
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void btnman2(ActionEvent event) throws IOException {
        try {
            person = 2;
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void btnman3(ActionEvent event) throws IOException {
        try {
            person = 3;
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void buyman2(ActionEvent event) throws IOException {
        try {
            buy(2);
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void buyman3(ActionEvent event) throws IOException {
        try {
            buy(3);
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    @FXML
    private void start(ActionEvent event) throws IOException {
        try {
            mapController map = (mapController) sc.getController("Controller3");
            if (person == 1) {
                map.init(1);
                sc.cancelStage(Main.mainview2);
                sc.setStage(Main.mainview3);
            } else if (person == 2) {
                map.init(2);
                sc.cancelStage(Main.mainview2);
                sc.setStage(Main.mainview3);
            } else if (person == 3) {
                map.init(3);
                sc.cancelStage(Main.mainview2);
                sc.setStage(Main.mainview3);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告");
                alert.setContentText("請選擇一個人物");
                alert.showAndWait();
            }
        } catch (Exception w) {
            System.out.println(w.toString());
        }
    }

    private void buy(int man) {
        int m;
        Button btn;
        Button btn2;
        if (man == 2) {
            m = 10;
            btn = btnman2;
            btn2 = buyman2;
        } else {
            m = 20;
            btn = btnman3;
            btn2 = buyman3;
        }
        if (Controller.money < m) {
            Alert no = new Alert(Alert.AlertType.INFORMATION);
            no.setTitle("無法購買");
            no.setHeaderText(null);
            no.setContentText("您的遊戲幣不夠喔~");
            no.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("購買");
            alert.setHeaderText(null);
            alert.setContentText("確認要購買這個角色嗎");
            Optional result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                btn.setDisable(false);
                btn2.setVisible(false);
                Controller.money -= m;
                moneyjlb.setText(String.valueOf(Controller.money));
                moneyjlb.setAlignment(Pos.CENTER);
            }
        }
    }
}


