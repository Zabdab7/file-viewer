import java.io.File;

import javax.swing.ImageIcon;

public class Util {

    public static int scaleWidth(int old_width, int old_height, int new_height) {
        return old_width * new_height / old_height;
    }

    public static boolean hasSuccessors(File f) {
        return f.listFiles() != null;
    }

    public static File[] getSuccessors(File f) {
        return Util.hasSuccessors(f) ? f.listFiles() : null;
    }

    
    public static ImageIcon getImageIcon(File f) {
        String fileName = "D:\\Coding Projects\\Java Projects\\file-viewer\\img\\";

        if(Util.hasSuccessors(f)) {
            fileName += "folder.png";
        } else {
            fileName += "document.png";
        }

        return new ImageIcon(fileName);
    }
}
