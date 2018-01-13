import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    public static String mainview = "MainView";
    public static String main1 = "main1.fxml";
    private String title1="選擇關卡";

    public static String mainview2 = "MainView2";
    public static String main2 = "main2.fxml";
    private String title2="選擇人物";

    public static String mainview3 = "MainView3";
    public static String main3 = "main3.fxml";

    public static String mainview4 = "MainView4";
    public static String main4 = "main4.fxml";
    private String title4="管理者信箱";
    private StageController stageController;

    @Override

    public void start(Stage primaryStage) throws IOException {
        stageController = new StageController();
        stageController.loadStage(mainview, main1,title1);
        stageController.loadStage(mainview2, main2,title2);
        stageController.loadStage(mainview3, main3,"3");
        stageController.loadStage(mainview4, main4,title4);
        stageController.setStage(mainview);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
