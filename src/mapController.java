import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.event.EventHandler;

public class mapController implements Controllerstage {
    @FXML
    AnchorPane anchorPane;
    StageController sc;
    ImageView imgv;
    private Image img;
    private ImageView stone[] = new ImageView[16];
    private int count = 0;

    public void init(int a) {
        if (a == 1) {
            img = new Image("img/person1.png");
        } else if (a == 3) {
            img = new Image("img/person2.png");
        } else if (a == 2) {
            img = new Image("img/person3.png");
        }
        imgv = new ImageView(img);
        Pane pane = (Pane) sc.getStage(Main.mainview3).getScene().getRoot();
        AnchorPane anchorPane = (AnchorPane) pane.getChildren().get(1);
        anchorPane.getChildren().add(imgv);
        imgv.setFitHeight(70);
        imgv.setFitWidth(50);
        imgv.setLayoutX(0);
        imgv.setLayoutY(47);
//        System.out.println(imgv.getX());
//        System.out.println(imgv.getY());
        stonecount();
        this.addKeyHandler();
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
//                        System.out.println("dytop123");
                        dy -= 5;
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    if (count == 0) {
                        stonejudge(dx, dy, 2);
                    }
                    if (count == 1) {
                        count = 0;
//                        System.out.println("dydown123");
                        dy += 5;
                    }
                } else if (event.getCode() == KeyCode.LEFT) {
                    if (count == 0) {
                        stonejudge(dx, dy, 3);
                    }
                    if (count == 1) {
                        count = 0;
//                        System.out.println("dxleft123");
                        dx -= 5;
                    }
                } else if (event.getCode() == KeyCode.RIGHT) {
                    if (count == 0) {
                        stonejudge(dx, dy, 4);
                    }
                    if (count == 1) {
                        count = 0;
//                        System.out.println("dxright123");
                        dx += 5;
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
            int c= (int) stone[i].getLayoutY();
            int d = c + (int) stone[i].getFitHeight();
//            System.out.println(i + "\t" + dx);
//            System.out.println(i+"\t"+dy);
//            System.out.println(i + "\t" + a);
//            System.out.println(i + "\t" + b);
            if (e == 1) {
                if (dy - 5 < 0 || dx >= a && dx <= b && dy > c && dy - 5 < d - 60) {
                    count = 0;
                    break;
                } else {
//                    System.out.println("Tdx" + dx);
//                    System.out.println("Tdy" + dy);
                    count = 1;
                }
            } else if (e == 2) {
                if (dy + 5 > 450 || dx >= a && dx <= b && dy + 5 >= c-65 && dy <= d - 35) {
                    if (dy >= 0 && dy <= 45) {
//                        System.out.println("dy" + dy);
//                        System.out.println("break" + c);
//                        System.out.println("break" + d);
//                        System.out.println("break" + i);
                        count = 1;
                    } else {
                        System.out.println("break" + i);
//                        System.out.println("break" + i);
                        System.out.println("dy" + dy);
                        System.out.println("break" + c);
                        System.out.println("break" + d);
                        count = 0;
                        break;
                    }
                } else {
//                    System.out.println("Ddx" + dx);
                    count = 1;
                }
            } else if (e == 3) {
                if (dx - 5 < 0 || dx >= a && dx - 5 <= b && dy >= c - 60 && dy <= d - 60) {
//                    if(dy<=d+60){
//                        System.out.println("dy" + dy);
//                    }
//                    System.out.println("break" + i);
//                    System.out.println("break" + (c - 60));
//                    System.out.println("break" + (d - 60));
//                    System.out.println("dy" + dy);
                    count = 0;
                    break;
                } else {
//                    System.out.println("Ldyy" + i);
//                    System.out.println("Ldy" + dy);
//                    System.out.println("Ldx" + dx);
//                    System.out.println("Ldyy" + c);
//                    System.out.println("Ldyy" + (c-35));
                    count = 1;
                }
            } else if (e == 4) {
                if (dx + 5 >= 650 || dx + 5 >= a && dx <= b && dy >= c && dy <= d - 30) {
                    if (dy >= 0 && dy <= 65) {
                        count = 1;
                    } else {
                        System.out.println("Ldyy" + i);
                        System.out.println("dy" + dy);
                        System.out.println("dx" + dx);
                        System.out.println("Rdy" + c);
                        System.out.println("Rdy" + d);
                        System.out.println("break");
                        count = 0;
                        break;
                    }
                } else {
//                    System.out.println("Rdx" + dx);
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
        sc.addcontroller("Controller3", this);
    }

    public void gotomain() {
        System.out.println(anchorPane);
    }

}
//            if (dx >= a && dx <= b) {
//                System.out.println("top" + i);
//                if (e == 1) {
//                    if (dy-5 <= d && dy >= c) {
//                        System.out.println("dx" + dx);
////                        System.out.println(i);
//                        break;
//                    } else {
//                        count = 1;
//                    }
//                } else if (e == 2) {
//                    if (dy + 5 >= c && dy <= d) {
////                        System.out.println(c);
//                        System.out.println("dx" + dx);
////                        System.out.println(d);
////                        System.out.println(i);
//                        break;
//                    } else {
//                        count = 1;
//                    }
//                } else if (e == 3) {
//                    if (dx - 5 <= b && dy > d && dx > a) {
//                        break;
//                    } else {
//                        count = 1;
//                    }
//                } else if (e == 4) {
//                    if (dx + 5 >= a && dx < b && dy > d) {
//                        break;
//                    } else {
//                        count = 1;
//                    }
//                }
//            } else if (dy >= c && dy <= d) {
////                System.out.println("456");
//                System.out.println("lwft"+i);
//                if (e == 1) {
//                    if (dy >= c && dy - 5 <= d && dx < b) {
//                        break;
//                    } else {
//                        count = 1;
//                    }
//                } else if (e == 2) {
//                    if (dy + 5 >= c && dy <= d && dx < b) {
//                        break;
//                    } else {
//                        count = 1;
//                    }
//                } else if (e == 3) {
//                    if (dx - 5 <= b && dx >= a) {
//                        System.out.println("dx" + dx);
////                        System.out.println(i);
//                        break;
//                    } else {
//                        System.out.println("dx" + dx);
//                        count = 1;
//                    }
//                } else if (e == 4) {
//                    if (dx + 5 >= a && dx < b) {
//                        System.out.println("dx" + dx);
////                        System.out.println(i);
//                        break;
//                    } else {
//                        System.out.println("dx" + dx);
//                        count = 1;
//                    }
//                }
//            } else {
//                count = 1;
//            }
