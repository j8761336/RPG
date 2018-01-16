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
    private boolean mon = true, flag = true, boo2 = true, boo3 = true;
    private int count = 0, level = 0, person = 0, win = 1;
    private Controller con;
    private PersonController personcon;
    private ImageView mon1, mon2, mon3;
    private Text t1;
    private Text2 t2;
    private Text3 t3;
    private boolean aaa = true;
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
        aaa = false;
        sc.setStage(Main.mainview);
        sc.cancelStage(Main.mainview3);
        con.reset();
        flag = false;
        person = 1;
        boo2 = true;
        boo3 = true;
        mon = true;
        t1 = new Text();
        t1.start();
        t2 = new Text2();
        t3 = new Text3();
        t3.start();
        t2.start();
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
        level = con.level();
        t1 = new Text();
        t2 = new Text2();
        t3 = new Text3();
        if (level == 1) {
            sc.getStage(Main.mainview3).setTitle("第一關卡");
            anchorPane.getChildren().get(1).setVisible(false);
            mon1.setVisible(false);
            mon3.setVisible(false);
            flag = false;
            person = 1;
            aaa = true;
            t2.start();
        } else if (level == 2) {
            sc.getStage(Main.mainview3).setTitle("第二關卡");
            mon1.setVisible(true);
            mon3.setVisible(false);
            flag = true;
            person = 1;
            aaa = true;
            mon1.setLayoutX(170);
            mon1.setLayoutY(116);
//            mon2.setLayoutX(400);
//            mon2.setLayoutY(121);
            t1.start();
            t2.start();
        } else if (level == 3) {
            sc.getStage(Main.mainview3).setTitle("第三關卡");
            mon1.setVisible(true);
            mon3.setVisible(true);
            person = 1;
            flag = true;
            aaa = true;
//            mon1.setLayoutX(170);
//            mon1.setLayoutY(116);
//            t1 = new Text();
//            t2 = new Text2();
//            t3 = new Text3();
//            mon1.setLayoutX(170);
//            mon1.setLayoutY(116);
//            mon2.setLayoutX(400);
//            mon2.setLayoutY(121);
//            mon3.setLayoutX(120);
//            mon3.setLayoutY(280);
            t1.start();
            t3.start();
            t2.start();
        }

//        System.out.println(imgv.getX());
//        System.out.println(imgv.getY());
        stonecount();
        coincount();
        this.addKeyHandler();
    }

    private void gg() {
        aaa = false;
        sc.setStage(Main.mainview);
        sc.cancelStage(Main.mainview3);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Q_Q");
        alert.setContentText("GameOver!!");
        alert.showAndWait();

    }

    private void addKeyHandler() {
        aaa = true;
        anchorPane.requestFocus();
        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int lightx = (int) anchorPane.getChildren().get(1).getLayoutX();
                int lighty = (int) anchorPane.getChildren().get(1).getLayoutY();
                int dx = (int) imgv.getLayoutX();
                int dy = (int) imgv.getLayoutY();
                if (event.getCode() == KeyCode.UP) {
                    if (count == 0) {
                        stonejudge(dx, dy, 1);
                        coinjudge(dx, dy, 1);
                        if (dx >= lightx && dx <= lightx + 100 && dy > lighty && dy - 10 < lighty + 37) {
                            stopok();
                        }
                    }
                    if (count == 1) {
                        count = 0;
                        dy -= 10;
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    if (count == 0) {
                        if (dx >= lightx && dx <= lightx + 100 && dy + 10 > lighty - 70 && dy < lighty + 37) {
                            stopok();
                        }
                        stonejudge(dx, dy, 2);
                        coinjudge(dx, dy, 2);
                    }
                    if (count == 1) {
                        count = 0;
                        dy += 10;
                    }
                } else if (event.getCode() == KeyCode.LEFT) {
                    if (count == 0) {

                        stonejudge(dx, dy, 3);
                        coinjudge(dx, dy, 3);
                    }
                    if (count == 1) {
                        count = 0;
                        dx -= 10;
                    }
                } else if (event.getCode() == KeyCode.RIGHT) {
                    if (count == 0) {
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
//                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }
            } else if (e == 2) {
                if (dx >= a - 45 && dx <= b - 5 && dy + 10 > c - 70 && dy < d) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
//                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }
            } else if (e == 3) {
                if (dx > a && dx - 10 < b && dy > c - 70 && dy <= d - 10) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
//                        System.out.println(con.money);
                        boo[i] = false;
                    }
                }

            } else if (e == 4) {
                if (dx + 10 > a && dx < b && dy > c - 70 && dy <= d - 10) {
                    coin[i].setVisible(false);
                    if (boo[i] == true) {
                        con.money += 10;
//                        System.out.println(con.money);
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

    private void stopok() {
        Platform.runLater(() -> {
            gg();
        });
        if (level == 1) {
            System.out.println("level" + level);
            t2.interrupt();
        } else if (level == 2) {
            System.out.println("level" + level);
            t1.interrupt();
            t2.interrupt();
        } else if (level == 3) {
            System.out.println("level" + level);
            t1.interrupt();
            t2.interrupt();
            t3.interrupt();
        }
    }

    public class Text extends Thread {
        ImageView a = (ImageView) anchorPane.getChildren().get(1);
        int bx = (int) mon1.getLayoutX();
        int by = (int) mon1.getLayoutY();
        int dx = (int) imgv.getLayoutX();
        int dy = (int) imgv.getLayoutY();

        // 這是閃電跟小恐龍--------------------------------------------------------------------------------
        public void run() {
            bx = (int) mon1.getLayoutX();
            by = (int) mon1.getLayoutY();
            while (aaa) {
                run1();
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        public void run1() {
            while (true) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (flag) {
                        a.setVisible(false);
                        denden = 1;
                    }
                    if (bx < 320) {
                        if (dx + 10 > bx - 60 && dx < bx + 50 && dy >= by - 50 && dy <= by + 50) {
//                            System.out.println("123");
                            stopok();
                            break;
                        } else {
                            bx += 10;
                            mon1.setLayoutX(bx);
                        }
                    } else {
                        run2();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 800);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
                try {
                    if (flag) {
                        a.setVisible(true);
                        denden = 0;
                    }
                    if (bx < 320) {
                        if (dx + 10 > bx - 60 && dx < bx + 50 && dy >= by - 50 && dy <= by + 50) {
                            stopok();
                            break;
                        } else {
                            bx += 10;
                            mon1.setLayoutX(bx);
                        }
                    } else {
                        run2();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 800);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
            }
        }

        public void run2() {
            while (true) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (flag) {
                        a.setVisible(false);
                        denden = 1;
                    }
                    if (by < 235) {
                        if (dx >= bx && dx <= bx + 50 && dy <= by + 50 && dy >= by) {
                            stopok();
                            break;
                        } else {
                            by += 10;
                            mon1.setLayoutY(by);
                        }
                    } else {
                        run3();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 300);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
                try {
                    if (flag) {
                        a.setVisible(true);
                        denden = 0;
                    }
                    if (by < 235) {
                        if (dx >= bx && dx <= bx + 50 && dy <= by + 50 && dy >= by) {
                            stopok();
                            break;
                        } else {
                            by += 10;
                            mon1.setLayoutY(by);
                        }
                    } else {
                        run3();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 300);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
            }
        }

        public void run3() {
            while (true) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (flag) {
                        a.setVisible(false);
                        denden = 1;
                    }
                    if (bx > 166) {
                        if (dx < bx + 50 && dx + 10 > bx - 50 && dy >= by - 50 && dy <= by + 50) {
                            stopok();
                            break;
                        } else {
                            bx -= 10;
                            mon1.setLayoutX(bx);
                        }
                    } else {
                        run4();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 800);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
                try {
                    if (flag) {
                        a.setVisible(true);
                        denden = 0;
                    }
                    if (bx > 166) {
                        if (dx < bx + 50 && dx + 10 > bx - 50 && dy >= by - 50 && dy <= by + 50) {
                            stopok();
                            break;
                        } else {
                            bx -= 10;
                            mon1.setLayoutX(bx);
                        }
                    } else {
                        run4();
                        break;
                    }
                } finally {
                    try {
                        Thread.sleep(1 * 800);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
            }
        }


        public void run4() {
            while (true) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (flag) {
                        a.setVisible(false);
                        denden = 1;
                    }
                    if (by > 116) {
                        if (dx >= bx - 50 && dx <= bx + 50 && dy >= by - 70 && dy <= by + 50) {
                            stopok();
                            break;
                        } else {
                            by -= 10;
                            mon1.setLayoutY(by);
                        }
                    } else {
                        run1();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 300);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
                try {
                    if (flag) {
                        a.setVisible(true);
                        denden = 0;
                    }
                    if (by > 116) {
                        if (dx >= bx - 50 && dx <= bx + 50 && dy >= by - 70 && dy <= by + 50) {
                            stopok();
                            break;
                        } else {
                            by -= 10;
                            mon1.setLayoutY(by);
                        }
                    } else {
                        run1();
                        break;
                    }
                } finally {
                    try {
                        Thread.sleep(1 * 300);
                    } catch (Exception e) {
                        this.interrupt();
                    }
                }
            }
        }

    }


    //  小怪物第二之-------------------------------------------------------------------------
    public class Text2 extends Thread {
        ImageView c = (ImageView) anchorPane.getChildren().get(19);
        int cx = (int) c.getLayoutX();
        int cy = (int) c.getLayoutY();
        int dx = (int) imgv.getLayoutX();
        int dy = (int) imgv.getLayoutY();

        public void run() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (cx < 650) {
                        if (dx + 10 > cx - 60 && dx < cx + 50 && dy >= cy - 50 && dy <= cy + 50) {
//                            System.out.println("123");
                            stopok();
                            break;
                        } else {
                            cx += 10;
                            c.setLayoutX(cx);
                        }
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
                        this.interrupt();
                    }
                }
            }
        }

        public void crun2() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (cy < 246) {
                        if (dx >= cx && dx <= cx + 50 && dy <= cy + 50 && dy >= cy) {
                            stopok();
                            break;
                        } else {
                            cy += 10;
                            c.setLayoutY(cy);
                        }
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
                        this.interrupt();
                    }
                }
            }
        }

        public void crun3() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (cx > 400) {
                        if (dx < cx + 50 && dx + 10 > cx - 50 && dy >= cy - 50 && dy <= cy + 50) {
                            stopok();
                            break;
                        } else {
                            cx -= 10;
                            c.setLayoutX(cx);
                        }
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
                        this.interrupt();
                    }
                }
            }
        }

        public void crun4() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (cy >= 121) {
                        if (dx >= cx - 50 && dx <= cx + 50 && dy >= cy - 70 && dy <= cy + 50) {
                            stopok();
                            break;
                        } else {
                            cy -= 10;
                            c.setLayoutY(cy);
                        }

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
                        this.interrupt();
                    }
                }
            }
        }

    }

    //   小怪物第3之-------------------------------------------------------------------------
    public class Text3 extends Thread {

        ImageView d = (ImageView) anchorPane.getChildren().get(20);
        double ex = mon3.getLayoutX();
        double ey = mon3.getLayoutY();
        int dx = (int) imgv.getLayoutX();
        int dy = (int) imgv.getLayoutY();
        public void run() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (ex < 370) {
                        if (ex + 10 > ex - 60 && dx < ex + 50 && dy >= ey - 50 && dy <= ey + 50) {
//                            System.out.println("123");
                            stopok();
                            break;
                        } else {
                            ex += 10;
                            d.setLayoutX(ex);
                        }

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
                        this.interrupt();
                    }
                }
            }
        }

        public void drun2() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (ey < 405) {

                        if (dx >= ex && dx <= ex + 50 && dy <= ey + 50 && dy >= ey) {
                            stopok();
                            break;
                        } else {
                            ey += 10;
                            d.setLayoutY(ey);
                        }

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
                        this.interrupt();
                    }
                }
            }
        }

        public void drun3() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (ex > 120) {
                        if (dx < ex + 50 && dx + 10 > ex - 50 && dy >= ey - 50 && dy <= ey + 50) {
                            stopok();
                            break;
                        } else {
                            ex -= 10;
                            d.setLayoutX(ex);
                        }

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
                        this.interrupt();
                    }
                }
            }
        }

        public void drun4() {
            while (aaa) {
                dx = (int) imgv.getLayoutX();
                dy = (int) imgv.getLayoutY();
                try {
                    if (ey > 280) {
                            if (dx >= ex - 50 && dx <= ex + 50 && dy >= ey - 70 && dy <= ey + 50) {
                                stopok();
                                break;
                            } else {
                                ey -= 10;
                                d.setLayoutY(ey);
                            }
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
                        this.interrupt();
                    }
                }
            }
        }

    }
}