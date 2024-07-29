import javax.swing.JButton;
import java.io.File;

public class Button {
  private JButton button;
  private File parent;
  private File[] children;

  public Button(File rootDirectory, int horizontalShift) {
    this.parent = rootDirectory;
    this.children = this.parent.listFiles();

    this.button = new JButton(this.parent.getAbsolutePath());

    button.setBounds((75 + 20) * horizontalShift + 20, 20, 75, 40);
    button.setFocusable(false);
  }

  public JButton getButton() {
    return this.button;
  }

  public File getParent() {
    return this.parent;
  }

  public File[] getChildren() {
    return this.children;
  }
}
