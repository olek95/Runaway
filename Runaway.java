package runaway;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Runaway extends Application {
    @Override
    public void start(Stage primaryStage) {
        Random rand = new Random();
        Button runawayButton = new Button("Uciekinier");
        StackPane root = new StackPane();
        root.getChildren().add(runawayButton);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Program z uciekającym przyciskiem");
        primaryStage.setScene(scene);
        primaryStage.show();
        runawayButton.setOnMouseMoved(event -> {
            Bounds buttonBounds;
            int sceneWidth = (int)scene.getWidth(), sceneHeight = (int)scene.getHeight(); 
            do{
                runawayButton.setTranslateX(rand.nextInt(sceneWidth) - sceneWidth/2);
                runawayButton.setTranslateY(rand.nextInt(sceneHeight) - sceneHeight/2);
                buttonBounds = runawayButton.getBoundsInParent();
            }while(buttonBounds.getMinX() < 0 || buttonBounds.getMaxX() > sceneWidth || buttonBounds.getMinY() < 0 || buttonBounds.getMaxY() > sceneHeight);
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
