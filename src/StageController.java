import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;

public class StageController {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();

    public void addStage(String name, Stage stage) {
        stages.put(name, stage);
        System.out.println(name + stage);

    }

    public Stage getStage(String name) {
        return stages.get(name);

    }

    public void loadStage(String name, String resources) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resources));
        Pane tempPane = (Pane) loader.load();
        Controller cr = loader.getController();
        cr.setStageController(this);
        Stage tempStage = new Stage();
        tempStage.setScene(new Scene(tempPane));
        this.addStage(name, tempStage);

    }

    public boolean setStage(String name) {
        this.getStage(name).show();
        return true;
    }

    public boolean cancelStage(String name) {
        this.getStage(name).hide();
        return true;
    }

    public boolean unloadStage(String name) {
        if (stages.remove(name) == null) {
            System.out.println("窗口不存在，请检查名称");
            return false;
        } else {
            System.out.println("窗口移除成功");
            return true;
        }
    }
}

