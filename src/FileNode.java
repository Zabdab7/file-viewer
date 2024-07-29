import java.io.File;
import java.util.ArrayList;

public class FileNode {

    private File file;

    public FileNode(File file) {
        this.file = file;
    }

    public FileNode[] listFile() {
        ArrayList<FileNode> nodes = new ArrayList<>();
        for(File f : this.file.listFiles()) {
            nodes.add(new FileNode(f));
        }
        return nodes.toArray(nodes.toArray(new FileNode[0]));
    }
}
