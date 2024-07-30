import java.util.ArrayList;
import java.io.File;

public class FileTree {

    private FileNode rootNode;
    private ArrayList<FileNode> nodeList;

    public FileTree(File rootFileName) {
        rootNode = new FileNode(rootFileName, 0);
        nodeList = new ArrayList<FileNode>();
    }

    public FileNode getRootNode() {
        return this.rootNode;
    }

    public ArrayList<FileNode> list() {
        traverse(rootNode);
        return nodeList;
    }

    // tree traversal
    private void traverse(FileNode node) {

        // Stuff To do
        System.out.println("name: " + node.getFile().getAbsolutePath() + ", depth: " + node.getDepth());
        nodeList.add(node);

        if(node.isOpen()) {
            for(FileNode childNode : node.listFiles()) {
                this.traverse(childNode);
            }
        }
    }

}
