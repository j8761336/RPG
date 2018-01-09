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
        imgv.setLayoutY(85);
//        System.out.println(imgv.getX());
//        System.out.println(imgv.getY());
        stonecount();
        this.addKeyHandler();
         Text t =new Text();
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
            int c = (int) stone[i].getLayoutY();
            int d = c + (int) stone[i].getFitHeight();
            if (e == 1) {
                if (dx >= a-45 && dx <= b && dy > c && dy - 5 < d-5) {
                    count = 0;
                    System.out.println("Tdy" + dy);
                    System.out.println("T" + c);
                    System.out.println("T" + d);
                    break;
                } else if (dy - 5 < 0) {
                    break;
                } else {
//                    System.out.println("Tdx" + dx);


                    count = 1;
                }
            } else if (e == 2) {
                if (dx >= a-45 && dx <= b && dy + 5 > c-70 && dy < d-5) {
                    if (dy >= 0 && dy <= 81) {
                        System.out.println("dy" + dy);
//                        System.out.println("break" + c);
//                        System.out.println("break" + d);
//                        System.out.println("break" + i);
                        count = 1;
                    } else {
                        System.out.println("break" + i);
                        System.out.println("dy" + dy);
                        System.out.println("break" + c);
                        System.out.println("break" + d);
                        count = 0;
                        break;
                    }
                } else if (dy + 5 >420) {
                    break;
                } else {
//                    System.out.println("Ddx" + dx);
                    count = 1;
                }
            } else if (e == 3) {
                if (dx > a && dx - 5 <= b&& dy >= c-70 && dy <= d-10) {
//                    if(dy<=d+60){
//                        System.out.println("dy" + dy);
//                    }
//                    System.out.println("break" + i);
//                    System.out.println("break" + (c - 60));
//                    System.out.println("break" + (d - 60));
//                    System.out.println("dy" + dy);
                    count = 0;
                    break;
                } else if (dx - 5 < 0) {
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
                if (dx + 5 > a-50 && dx < b && dy >= c-70 && dy <= d-10) {
//                    if (dy >= 0 && dy <= 81) {
//                        count = 1;
//                    } else {
                    System.out.println("Ldyy" + i);
                    System.out.println("dy" + dy);
                    System.out.println("dx" + dx);
                    System.out.println("Rdy" + c);
                    System.out.println("Rdy" + d);
                    System.out.println("break");
                    count = 0;
                    break;
//                    }
                } else if (dx + 5 >=800) {
                    break;
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


}public class Text extends Thread {
        ImageView a = (ImageView) anchorPane.getChildren().get(1);
        public void run() {
            while(true){
                try {
                    a.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Thread.sleep(1 * 500);
                    } catch (Exception e) {
                    }
                }try {
                    a.setVisible(true);
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        Thread.sleep(1 * 500);
                    } catch (Exception e) {
                  }}

        }
        }
    }

}

