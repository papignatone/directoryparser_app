import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryParser {

    // ---------------------------------------
    // data attributes
    // ---------------------------------------
    private Path directoryPath;
    private Path largestFilePath;
    private long largestFileSize;

    // ---------------------------------------
    // constructors
    // ---------------------------------------
    public DirectoryParser() {
        directoryPath = null;
        largestFilePath = null;
        largestFileSize = 0;
    }

    public DirectoryParser(Path directoryPath) {
        this.directoryPath = directoryPath;
        largestFileSize = 0;
    }

    public DirectoryStream<Path> getDirectoryStream(Path directoryPath) {
        System.out.println("DIR " + directoryPath.toAbsolutePath());
        try {
            DirectoryStream<Path> dirStream = Files.newDirectoryStream(directoryPath);
            return dirStream;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public Path getDirectoryPath() {
        return this.directoryPath;
    }

    public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Path getLargestFilePath(Path path) {
        return largestFilePath;
    }

    public void setLargestFilePath(Path largestFilePath) {
        this.largestFilePath = largestFilePath;
    }

    public long getLargestFileSize() {
        return largestFileSize;
    }

    public void setLargestFileSize(long largestFileSize) {
        this.largestFileSize = largestFileSize;
    }

}
