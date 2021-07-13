import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

// launches the application
public class MainClass extends Application {
    private Player player;
    private FileChooser fileChooser;

    public void start(final Stage primaryStage) {
        // setting up the stages
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        // Connecting the above three
        // it would connect open with file
        file.getItems().add(open);
        menu.getMenus().add(file);

        // Adding functionality to switch to different videos
        fileChooser = new FileChooser();
        fileChooser = new FileChooser();
        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Pausing the video while switching
                player.player.pause();
                File file = fileChooser.showOpenDialog(primaryStage);

                // Choosing the file to play
                if (file != null) {
                    try {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player, 720, 535, Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        String path = "G:/movies/42_(2013)/42.mp4";
        try {
                // here you can choose any video
                player = new Player(new File(path).toURI().toString());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            // Setting the menu at the top
            player.setTop(menu);

            // Adding player to the Scene
            Scene scene = new Scene(player, 720, 535, Color.BLACK);

            // height and width of the video player
            // background color set to Black
            primaryStage.setScene(scene); // Setting the scene to stage
            primaryStage.show(); // Showing the stage


    }
        // Main function to launch the application
        public static void main (String[]args){
            launch(args);
        }


}