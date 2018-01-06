import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class mapController implements Controllerstage {
    @FXML
    AnchorPane anchorPane;
    StageController sc;
    ImageView imgv;
    private ImageView img[] = new ImageView[16];


    public void init(int a) {
        Image img = null;
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
        imgv.setFitHeight(110);
        imgv.setFitWidth(70);
        imgv.setX(10);
        imgv.setY(30);
        System.out.println(imgv.getX());
        System.out.println(imgv.getY());

    }
    //    @FXML
//    public void setKeyPressed(){
//        imgman1.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                int dx = 0;
//                int dy = 0;
//
//            if(event.getCode()== KeyCode.UP){
//                dy = -5;
//            }else if(event.getCode()== KeyCode.DOWN){
//                dy = 5;
//            }else if(event.getCode()== KeyCode.LEFT){
//                dx = -5;
//            }else if(event.getCode()== KeyCode.RIGHT){
//                dx = 5;
//            }
//                imgman1.setLayoutX(imgman1.getLayoutX()+dx);
//                imgman1.setLayoutY(imgman1.getLayoutY()+dy);
//
//
//            }
//        });
//    }

    public void setStageController(StageController stageController) {
        sc = stageController;
        sc.addcontroller("Controller3", this);
    }

    public void gotomain() {
        System.out.println(anchorPane);
    }

}

