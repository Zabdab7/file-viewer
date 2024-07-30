import java.io.File;
import java.util.ArrayList;

    public class FileNode {

        private File file;
        private int depth;
        private ArrayList<FileNode> children;

        public FileNode(File file, int depth) {
            this.file = file;
            this.depth = depth;
            children = new ArrayList<FileNode>();
        }

        public FileNode[] listFiles() {
            ArrayList<FileNode> nodes = new ArrayList<>();
            for(File f : this.file.listFiles()) {
                nodes.add(new FileNode(f, depth + 1));
            }
            return nodes.toArray(nodes.toArray(new FileNode[0]));
        }

        public boolean hasChildren() {
            return this.getChildren().isEmpty();
        }

        public ArrayList<FileNode> getChildren() {
            return this.children;
        }

        public File getFile() {
            return this.file;
        }

        public int getDepth() {
            return this.depth;
        }
}
