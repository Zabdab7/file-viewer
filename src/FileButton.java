import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FileButton extends JButton {

    private FileNode node;
    private int downwardShift;

    public FileButton(FileNode node, int downwardShift) {
        this.node = node;
        this.downwardShift = downwardShift;
        this.formatButton();
    }

    private void formatButton() {
        // Set name
        String text = this.node.getFile().getAbsolutePath();
        this.setText(text);

        // Set height to fit text
        int buttonHeight = this.getFontMetrics(this.getFont()).getHeight() + 5;
        this.setBounds(5 * node.getDepth() + 20, buttonHeight * this.downwardShift + 20, (int) Frame.getScreenSize().getWidth() - 20, buttonHeight);

        this.setImageIcon();

        // Align text to top-left corner
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.TOP);

        // Remove buttony-ness
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
    }

    public void enter() {
        // TODO = change label background color to light blue  while cursor is hovering
    }

    public void exit() {
        // TODO = change label color back to transparent when cursor is not hovering
    }

    private void setImageIcon() {
        String fileName = "D:\\Coding Projects\\Java Projects\\file-viewer\\img\\";

        if(Util.hasSuccessors(node.getFile())) {
            fileName += "folder.png";
        } else {
            fileName += "document.png";
        }

        ImageIcon icon = new ImageIcon(fileName);

        // Scale icon to fit JButton
        int imageWidth = icon.getIconWidth() * (this.getHeight() - 1) / icon.getIconHeight();
        java.awt.Image scaledImage = icon.getImage().getScaledInstance( imageWidth, this.getHeight() - 5,  java.awt.Image.SCALE_SMOOTH );
        this.setIcon(new ImageIcon(scaledImage));
    }
}
