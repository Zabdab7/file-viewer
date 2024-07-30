import java.io.File;
import java.util.ArrayList;

public class FileNode {

        private File file;
        private int depth;
        private boolean isOpen;

        public FileNode(File file, int depth) {
            this.file = file;
            this.depth = depth;
            this.isOpen = false;
        }

        public FileNode[] listFiles() {
            ArrayList<FileNode> nodes = new ArrayList<>();
            for(File f : this.file.listFiles()) {
                nodes.add(new FileNode(f, depth + 1));
            }
            return nodes.toArray(nodes.toArray(new FileNode[0]));
        }

        public void open() {
            this.isOpen = true;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        public File getFile() {
            return this.file;
        }

        public int getDepth() {
            return this.depth;
        }
}
