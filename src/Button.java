import javax.swing.JButton;
import java.io.File;

public class Button {
  private JButton button;
  private File file;

  public Button(File rootDirectory, int horizontalShift) {
    this.file = rootDirectory;

    this.button = new JButton(this.file.getAbsolutePath());

    button.setBounds((75 + 20) * horizontalShift + 20, 20, 75, 40);
    button.setFocusable(false);
  }

  public JButton getButton() {
    return this.button;
  }

  public File getFile() {
    return this.file;
  }

}
