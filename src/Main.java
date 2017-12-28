import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    public static String mainview="MainView";
    public static String main1="1.fxml";

    public static String mainview2="MainView2";
    public static String main2="2.fxml";

    private StageController stageController;
    @Override

    public void start(Stage primaryStage){
//        this.primaryStage=primaryStage;
//        this.primaryStage.setTitle("請選擇關卡");
//        first();
        stageController=new StageController();
        stageController.setPrimaryStage("primaryStage",primaryStage);
        stageController.loadStage(mainview,main1,  StageStyle.UNDECORATED);
        stageController.loadStage(mainview2,main2);

        stageController.setStage(mainview);
    }
    public void first() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1.fxml"));
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
