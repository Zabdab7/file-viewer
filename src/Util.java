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

    /*
    public static String getExtension(File f) {
        String extension = "", fileName = f.getName();

        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i+1);
        }

        return extension;
    }
    */
    
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
