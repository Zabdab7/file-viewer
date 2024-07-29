import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Label {

    private File file;
    private JButton button;
    private ImageIcon icon;
    private int shift;

    public Label(File file, int verticalShift) {
        this.file = file;
        this.shift = verticalShift;
        this.icon = Util.getImageIcon(this.file);

        this.button = new JButton();
        this.formatButton();
    }

    private void formatButton() {
        // Set name
        String text = this.file.getAbsolutePath();
        this.button.setText(text);

        // Set height to fit text
        int height = this.button.getFontMetrics(this.button.getFont()).getHeight() + 5; // padding on the top and bottom 
        this.button.setBounds(20, height * this.shift + 80, (int) Frame.getScreenSize().getWidth() - 20, height);

        // Scaled
        int imageWidth = Util.scaleWidth(icon.getIconWidth(), icon.getIconHeight(), height);
        java.awt.Image scaledIcon = this.icon.getImage().getScaledInstance( imageWidth, height - 5,  java.awt.Image.SCALE_SMOOTH );
        button.setIcon(new ImageIcon(scaledIcon));

        // Align text to top-left corner
        this.button.setHorizontalAlignment(SwingConstants.LEFT);
        this.button.setVerticalAlignment(SwingConstants.TOP);

        // Remove buttony-ness
        this.button.setFocusable(false);
        this.button.setContentAreaFilled(false);
        this.button.setBorderPainted(false);
    }

    public File getFile(){
        return this.file;
    }

    public JButton getButton() {
        return this.button;
    }

    public void enter() {
        // TODO = change label background color to light blue  while cursor is hovering
    }

    public void exit() {
        // TODO = change label color back to transparent when cursor is not hovering
    }

}
