import java.util.ArrayList;
import java.io.File;

public class FileTree {

    private FileNode rootNode;

    public FileTree(File rootFileName) {
        rootNode = new FileNode(rootFileName, 0);
    }

    public void traverse() {
        traverse(rootNode);
    }

    // pre-order tree traversal
    private void traverse(FileNode node) {
        System.out.println("name: " + node.getFile().getName() + ", depth: " + node.getDepth());
        if(node.hasChildren()) {
            for(FileNode childNode : node.getChildren()) {
                traverse(childNode);
            }
        }
    }
}
