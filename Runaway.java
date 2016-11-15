package runaway;

import java.util.Random;
import javafx.application.Application;
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
        runawayButton.setOnMouseMoved(event -> {
            System.out.println(runawayButton.getBoundsInParent().getMinX());
            runawayButton.setTranslateX(rand.nextInt(300) - 150);
            runawayButton.setTranslateY(rand.nextInt(250) - 125);
            System.out.println(runawayButton.getBoundsInParent().getMinX());
            runawayButton.relocate(runawayButton.getBoundsInParent().getMinX(),0);
        });
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Program z uciekającym przyciskiem");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
