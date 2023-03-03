import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FindingLargestFileController implements Initializable {

    @FXML
    private Button btnLargestFile;

    @FXML
    private Label lblContainingDirectory;

    @FXML
    private Label lblFileName;

    @FXML
    private Label lblInputDirectory;

    @FXML
    private Label lblLastModified;

    @FXML
    private Label lblSize;

    @FXML
    private TextField txtContainingDirectory;

    @FXML
    private TextField txtFileName;

    @FXML
    private TextField txtInputDirectory;

    @FXML
    private TextField txtLastModified;

    @FXML
    private TextField txtSize;

    // printFileInfo
    @FXML
    void onclickFindLargestFile(ActionEvent event) {

        MainApp.getOutput(txtInputDirectory.getText());

        DirectoryParser dirParse = MainApp.parser;
        Path directoryPath = dirParse.getDirectoryPath();
        System.out.println("Calling getDirectoryStream in onclickFindLargestFile");
        DirectoryStream<Path> dirStream = dirParse.getDirectoryStream(directoryPath);

        Path largestFilePath = null;
        long largestFileSize = 0;

        for (Path path : dirStream) {
            try {
                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

                if (attr.size() > largestFileSize && attr.isRegularFile()) {
                    largestFileSize = attr.size();
                    largestFilePath = path;

                }

                else if (attr.size() == largestFileSize) {

                    System.out.println("Last Modified: " +
                            MainApp.formatDateTime(attr.lastModifiedTime()));

                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        dirParse.setLargestFilePath(largestFilePath);
        dirParse.setLargestFileSize(largestFileSize);

        System.out.println("Largest File Path: " + largestFilePath.toString());
        System.out.println("Largest File Size: " + largestFileSize);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
