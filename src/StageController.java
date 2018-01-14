import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StageController {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();
    public Map<String, Object> controller = new HashMap<String, Object>();

    public void addStage(String name, Stage stage) {
        stages.put(name, stage);
//        System.out.println(name + stage);
    }

    public void addcontroller(String name, Object obj) {
        controller.put(name, obj);
//        System.out.println(name + obj);
    }

    public Stage getStage(String name) {
        return stages.get(name);

    }

    public Object getController(String name) {
        return controller.get(name);
    }

    public void loadStage(String name, String resources, String title) throws IOException {
//        System.out.println(name);
//        System.out.println(resources);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resources));
        Pane tempPane = (Pane) loader.load();
        Controllerstage cs = loader.getController();
        cs.setStageController(this);
        Stage tempStage = new Stage();
        if (!title.equals("3")) {
            tempStage.setTitle(title);
        }
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

