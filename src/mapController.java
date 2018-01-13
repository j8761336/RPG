import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.event.EventHandler;

import javax.swing.*;

public class mapController implements Controllerstage {
    @FXML
    AnchorPane anchorPane;
    StageController sc;
    ImageView imgv;
    private Image img;
    private ImageView stone[] = new ImageView[16];
    private int count = 0, level = 0, person = 0, win = 1;
    private Controller con;
    private PersonController personcon;
    @FXML
    MenuBar mb;

    @FXML
    private void reset() {
        con.reset();
    }

    @FXML
    private void Previouspage() {
        sc.setStage(Main.mainview2);
        sc.cancelStage(Main.mainview3);
    }

    @FXML
    private void exit() {
        con.exit();
    }

    @FXML
    private void about() {
        con.about();
    }


    public void init(int a) {
        Pane pane = (Pane) sc.getStage(Main.mainview3).getScene().getRoot();
        AnchorPane anchorPane = (AnchorPane) pane.getChildren().get(1);
        if (person != 0) {
            anchorPane.getChildren().remove(18);
        }
        level = con.level();
        if (level == 1) {
            sc.getStage(Main.mainview3).setTitle("第一關卡");
            person = 1;
        } else if (level == 2) {
            sc.getStage(Main.mainview3).setTitle("第二關卡");
            person = 1;
        } else if (level == 3) {
            sc.getStage(Main.mainview3).setTitle("第三關卡");
            person = 1;
        }
        if (a == 1) {
            img = new Image("img/person1.png");
        } else if (a == 3) {
            img = new Image("img/person2.png");
        } else if (a == 2) {
            img = new Image("img/person3.png");
        }
        imgv = new ImageView(img);

        anchorPane.getChildren().add(imgv);
        imgv.setFitHeight(70);
        imgv.setFitWidth(50);
        imgv.setLayoutX(0);
        imgv.setLayoutY(90);
//        System.out.println(imgv.getX());
//        System.out.println(imgv.getY());
        stonecount();
        this.addKeyHandler();
        Text t = new Text();
        t.start();
    }

    private void addKeyHandler() {
        anchorPane.requestFocus();
        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int dx = (int) imgv.getLayoutX();
                int dy = (int) imgv.getLayoutY();
                if (event.getCode() == KeyCode.UP) {
                    if (count == 0) {
                        stonejudge(dx, dy, 1);
                    }
                    if (count == 1) {
                        count = 0;
                        dy -= 10;
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    if (count == 0) {
                        stonejudge(dx, dy, 2);
                    }
                    if (count == 1) {
                        count = 0;
                        dy += 10;
                    }
                } else if (event.getCode() == KeyCode.LEFT) {
                    if (count == 0) {
                        stonejudge(dx, dy, 3);
                    }
                    if (count == 1) {
                        count = 0;
                        dx -= 10;
                    }
                } else if (event.getCode() == KeyCode.RIGHT) {
                    if (count == 0) {
                        stonejudge(dx, dy, 4);
                    }
                    if (count == 1) {
                        count = 0;
                        dx += 10;
                    }
                }
                imgv.setLayoutX(dx);
                imgv.setLayoutY(dy);
            }
        });
    }

    public void stonejudge(int dx, int dy, int e) {
        for (int i = 0; i < 16; i++) {
//            System.out.println(i);
            int a = (int) stone[i].getLayoutX();
            int b = a + (int) stone[i].getFitWidth();
            int c = (int) stone[i].getLayoutY();
            int d = c + (int) stone[i].getFitHeight();
            if (e == 1) {
                if (dx >= a - 45 && dx <= b - 5 && dy > c && dy - 10 < d - 5) {
                    count = 0;
                    break;
                } else if (dy - 10 < 0) {
                    break;
                } else {
                    count = 1;
                }
            } else if (e == 2) {
                if (dx >= a - 45 && dx <= b - 5 && dy + 10 > c - 70 && dy < d) {
                    if (dy >= 0 && dy <= 81) {
                        count = 1;
                    } else {
                        count = 0;
                        break;
                    }
                } else if (dy + 10 > 420) {
                    break;
                } else {
                    count = 1;
                }
            } else if (e == 3) {
                if (dx > a && dx - 10 < b && dy > c - 70 && dy <= d - 10) {
                    count = 0;
                    break;
                } else if (dx - 10 < 0) {
                    break;
                } else {
                    count = 1;
                }
            } else if (e == 4) {
                if (dx + 10 > a - 50 && dx < b && dy > c - 70 && dy <= d - 10) {
                    count = 0;
                    break;
                } else if (dx + 10 >= 800) {
                    if (dy >= 360 && dy <= 420) {
                        count = 1;
                        if (dx > 860) {
                            sc.setStage(Main.mainview);
                            sc.cancelStage(Main.mainview3);
                            con.nonebtn++;
                            con.setnobtn();
                            con.money += 10;
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("恭喜過關");
                            alert.setHeaderText(null);
                            if (win < 3) {
                                alert.setContentText("請前進下一關");
                            } else if (win == 3) {
                                alert.setContentText("恭喜全部通關!!");
                            } else {
                                alert.setContentText("恭喜過關");
                            }
                            alert.showAndWait();
                            win++;
                            break;
                        }
                    }
                    break;
                } else {
                    count = 1;
                }
            } else {
                count++;
            }
        }
    }

    public void stonecount() {
        Pane pane = (Pane) sc.getStage(Main.mainview3).getScene().getRoot();
        AnchorPane an = (AnchorPane) pane.getChildren().get(1);
        for (int i = 2; i < 18; i++) {
            stone[i - 2] = (ImageView) an.getChildren().get(i);
        }
    }

    public void setStageController(StageController stageController) {
        sc = stageController;
        con = (Controller) sc.getController("Controller1");
        personcon = (PersonController) sc.getController("Controller2");
        sc.addcontroller("Controller3", this);
    }

    public class Text extends Thread {

        ImageView a = (ImageView) anchorPane.getChildren().get(1);

        public void run() {
            while (true) {
                try {
                    a.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 500);
                    } catch (Exception e) {
                    }
                }
                try {
                    a.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 500);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

}
