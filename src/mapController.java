import javafx.application.Platform;
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
    private ImageView coin[] = new ImageView[7];
    private boolean boo[] = new boolean[7];
    private boolean mon=true;
    private int count = 0, level = 0, person = 0, win = 1;
    private Controller con;
    private PersonController personcon;
    private ImageView mon1, mon2, mon3;
    private Text t;
    @FXML
    MenuBar mb;
    int denden = 0;

    public void setStageController(StageController stageController) {
        sc = stageController;
        con = (Controller) sc.getController("Controller1");
        personcon = (PersonController) sc.getController("Controller2");
        sc.addcontroller("Controller3", this);
    }

    ///////////////menu bar/////////////////////////////////
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
///////////////menu bar/////////////////////////////////

    public void init(int a) {
        Pane pane = (Pane) sc.getStage(Main.mainview3).getScene().getRoot();
        AnchorPane anchorPane = (AnchorPane) pane.getChildren().get(1);
        mon1 = (ImageView) anchorPane.getChildren().get(18);
        mon2 = (ImageView) anchorPane.getChildren().get(19);
        mon3 = (ImageView) anchorPane.getChildren().get(20);
        if (person != 0) {
            anchorPane.getChildren().remove(28);
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
        coincount();
        this.addKeyHandler();
         t = new Text();
        Text2 t2 = new Text2();
        Text3 t3 = new Text3();
        t3.start();
        t2.start();
        t.start();

    }

    private void gg() {
        sc.setStage(Main.mainview);
        sc.cancelStage(Main.mainview3);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Q_Q");
        alert.setContentText("GameOver!!");
        alert.showAndWait();
    }

    private void addKeyHandler() {
        anchorPane.requestFocus();
        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int bx = (int) mon1.getLayoutX();
                int by = (int) mon1.getLayoutY();
                int cx = (int) mon2.getLayoutX();
                int cy = (int) mon2.getLayoutY();
                int dx2 = (int) mon3.getLayoutX();
                int dy2 = (int) mon3.getLayoutY();
                int dx = (int) imgv.getLayoutX();
                int dy = (int) imgv.getLayoutY();
                if (event.getCode() == KeyCode.UP) {
                    if (count == 0) {
//                        if (dx >= 100 && dx <= 200 && dy >= 335 && dy <= 377) {
//                            if (denden == 0) {
//                                gg();
//                            }
//                        }
//                        if (dx >= bx && dx <= bx + 50 && dy >= by && dy + 10 < by + 50) {
//                            gg();
//                        }
//                        if (dx >= cx && dx <= cx + 50 && dy >= cy && dy + 10 < cy + 50) {
//                            gg();
//                        }
//                        if (dx >= dx2 && dx <= dx2 + 50 && dy >= dy2 && dy + 10 < dy2 + 50) {
//                            gg();
//                        }
                        stonejudge(dx, dy, 1);
                        coinjudge(dx, dy, 1);
                    }
                    if (count == 1) {
                        count = 0;
                        dy -= 10;
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    if (count == 0) {

//                        if (dx >= 100 && dx <= 200 && dy - 10 > 265 && dy <= 307) {
//                            if (denden == 0) {
//                                gg();
//                            }
//                        }
//                        if (dx >= bx && dx <= bx + 50 && dy + 10 >= by - 50 && dy <= by + 50) {
//                            gg();
//                        }
//                        if (dx >= cx && dx <= cx + 50 && dy + 10 >= cy - 50 && dy <= cy + 50) {
//                            gg();
//                        }
//                        if (dx >= dx2 && dx <= dx2 + 50 && dy + 10 >= dy2 - 50 && dy <= dy2 + 50) {
//                            gg();
//                        }
                        stonejudge(dx, dy, 2);
                        coinjudge(dx, dy, 2);
                    }
                    if (count == 1) {
                        count = 0;
                        dy += 10;
                    }
                } else if (event.getCode() == KeyCode.LEFT) {

                    if (count == 0) {

//                        if (dx >= 100 && dx <= 200 && dy >= 335 && dy <= 377) {
//                            if (denden == 0) {
//                                gg();
//                            }
//                        }
//                        if (dx >= bx && dx - 10 <= bx + 50 && dy >= by - 50 && dy <= by + 50) {
//                            gg();
//                        }
//                        if (dx >= cx && dx - 10 <= cx + 50 && dy >= cy - 50 && dy <= cy + 50) {
//                            gg();
//
//                        }
//                        if (dx >= dx2 && dx - 10 <= dx2 + 50 && dy >= dy2 - 50 && dy <= dy2 + 50) {
//                            gg();
//                        }
                        stonejudge(dx, dy, 3);
                        coinjudge(dx, dy, 3);
                    }
                    if (count == 1) {
                        count = 0;
                        dx -= 10;
                    }
                } else if (event.getCode() == KeyCode.RIGHT) {

                    if (count == 0) {

//                        if (dx >= 100 && dx <= 200 && dy >= 335 && dy <= 377) {
//                            if (denden == 0) {
//                                gg();
//                            }
//                        }
//                        if (dx + 10 > bx - 50 && dx <= bx + 50 && dy >= by - 50 && dy <= by + 50) {
//                            gg();
//                        }
//                        if (dx + 10 >= cx - 50 && dx <= cx + 50 && dy >= cy - 50 && dy <= cy + 50) {
//                            gg();
//                        }
//                        if (dx + 10 >= dx2 - 50 && dx <= dx2 + 50 && dy >= dy2 - 50 && dy <= dy2 + 50) {
//                            gg();
//                        }
                        stonejudge(dx, dy, 4);
                        coinjudge(dx, dy, 4);
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


    private void coinjudge(int dx, int dy, int e) {
        for (int i = 0; i < 7; i++) {
            int a = (int) coin[i].getLayoutX();
            int b = a + (int) coin[i].getFitWidth();
            int c = (int) coin[i].getLayoutY();
            int d = c + (int) coin[i].getFitHeight();
            if (e == 1) {
                if (dx >= a - 50 && dx <= b - 5 && dy > c && dy - 10 < d) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }
            } else if (e == 2) {
                if (dx >= a - 45 && dx <= b - 5 && dy + 10 > c - 70 && dy < d) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }
            } else if (e == 3) {
                if (dx > a && dx - 10 < b && dy > c - 70 && dy <= d - 10) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }

            } else if (e == 4) {
                if (dx + 10 > a && dx < b && dy > c - 70 && dy <= d - 10) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }
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

    private void coincount() {
        Pane pane = (Pane) sc.getStage(Main.mainview3).getScene().getRoot();
        AnchorPane an = (AnchorPane) pane.getChildren().get(1);
        for (int i = 0; i < 7; i++) {
            coin[i] = (ImageView) an.getChildren().get(i + 21);
            boo[i] = true;
        }

    }

    private void stopok(){
        if(mon==false){
            t.interrupt();
            Platform.runLater(() -> {
                gg();
            });
        }
    }

     class Text extends Thread {
        ImageView a = (ImageView) anchorPane.getChildren().get(1);
        //        ImageView c = (ImageView) anchorPane.getChildren().get(19);
//        ImageView d = (ImageView) anchorPane.getChildren().get(20);
        int bx = (int) mon1.getLayoutX();
        int by = (int) mon1.getLayoutY();
        int dx = (int) imgv.getLayoutX();
        int dy = (int) imgv.getLayoutY();

        // 這是閃電跟小恐龍--------------------------------------------------------------------------------
        public void run() {
            while (mon) {
                System.out.println("11");
                run1();

                try {
                } catch (Exception e) {
                    System.out.println("222");
                    e.printStackTrace();
                }
            }

        }

        boolean boo2 = true;
        boolean boo3 = true;

        public void run1() {
            System.out.println("123");
            boolean boo = true;
            while (mon) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    a.setVisible(false);
                    denden = 1;
                    if (bx < 320 && boo2) {
                        if (bx + 10 > dx && bx < dx + 50 && by > dy && by < dy + 70) {
                            mon=false;
                            System.out.println(mon);
                            Thread.interrupted();
                            stopok();
                            break;
                        } else {
                            bx += 10;
                            mon1.setLayoutX(bx);
                        }
                    } else if (bx > 166 && boo) {
                        bx -= 10;
                        mon1.setLayoutX(bx);
                    } else {
                        run2();
                        break;
                    }
                    Thread.sleep(1 * 800);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    a.setVisible(true);
                    denden = 0;
                    if (bx < 320 && boo2) {
                        bx += 10;
                        mon1.setLayoutX(bx);
                        boo = false;
                        boo3 = true;
                    } else if (bx > 166 && boo) {
                        bx -= 10;
                        mon1.setLayoutX(bx);
                        boo3 = false;
                    } else {
                        run2();
                        break;
                    }
                    Thread.sleep(1 * 800);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void run2() {
            boolean boo = true;
            while (mon) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    a.setVisible(false);
                    denden = 1;
                    if (by < 235 && boo3) {
                        by += 10;
                        mon1.setLayoutY(by);
                    } else if (by > 116 && boo) {
                        by -= 10;
                        mon1.setLayoutY(by);
                    } else {
                        run1();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 100);
                    } catch (Exception e) {
                    }
                }
                try {
                    a.setVisible(true);
                    denden = 0;
                    if (by < 235 && boo3) {
                        by += 10;
                        mon1.setLayoutY(by);
                        boo = false;
                        boo2 = false;
                    } else if (by > 116 && boo) {
                        by -= 10;
                        mon1.setLayoutY(by);
                        boo2 = true;
                    } else {
                        run1();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 100);
                    } catch (Exception e) {
                    }
                }
            }
        }

    }

    //  小怪物第二之-------------------------------------------------------------------------
    public class Text2 extends Thread {
        ImageView c = (ImageView) anchorPane.getChildren().get(19);
        double cx = c.getLayoutX();
        double cy = c.getLayoutY();

        public void run() {
            while (true) {
                try {
                    if (cx < 650) {
                        cx += 10;
                        c.setLayoutX(cx);
                    } else {
                        crun2();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 50);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void crun2() {
            while (true) {
                try {
                    if (cy < 246) {
                        cy += 10;
                        c.setLayoutY(cy);
                    } else {
                        crun3();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 50);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void crun3() {
            while (true) {
                try {
                    if (cx > 400) {
                        cx -= 10;
                        c.setLayoutX(cx);
                    } else {
                        crun4();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 50);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void crun4() {
            while (true) {
                try {
                    if (cy >= 121) {
                        cy -= 10;
                        c.setLayoutY(cy);
                    } else {
                        run();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 50);
                    } catch (Exception e) {
                    }
                }
            }
        }

    }

    //   小怪物第3之-------------------------------------------------------------------------
    public class Text3 extends Thread {

        ImageView d = (ImageView) anchorPane.getChildren().get(20);
        double dx = d.getLayoutX();
        double dy = d.getLayoutY();

        public void run() {
            while (true) {
                try {
                    if (dx < 370) {
                        dx += 10;
                        d.setLayoutX(dx);
                    } else {
                        drun2();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 200);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void drun2() {
            while (true) {
                try {
                    if (dy < 405) {
                        dy += 10;
                        d.setLayoutY(dy);
                    } else {
                        drun3();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 200);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void drun3() {
            while (true) {
                try {
                    if (dx > 120) {
                        dx -= 10;
                        d.setLayoutX(dx);
                    } else {
                        drun4();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 200);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void drun4() {
            while (true) {
                try {
                    if (dy > 280) {
                        dy -= 10;
                        d.setLayoutY(dy);
                    } else {
                        run();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 200);
                    } catch (Exception e) {
                    }
                }
            }
        }

    }

}
