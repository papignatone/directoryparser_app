import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static DirectoryParser parser = new DirectoryParser();

    // GUI FRONT END
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FxFindingLargestFile.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Finding Largest File");
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException ex) {
            // TODO: handle exception
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }

    public static void getOutput(String directory) {

        // chosen traversal method, demo 2
        parser.setDirectoryPath(Paths.get(directory));
        parser.setLargestFileSize(0);
        parser.setLargestFilePath(null);
        parser.getLargestFileSize();

    }

    // convert UTC time to EST
    public static String formatDateTime(FileTime fileTime) {

        LocalDateTime localDateTime = fileTime
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }
}
