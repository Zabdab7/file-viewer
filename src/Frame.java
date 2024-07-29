import javax.swing.JFrame;

import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Frame extends JFrame implements ActionListener {

  private final ArrayList<Button> buttons = new ArrayList<Button>();;
  private ArrayList<Label> labels = new ArrayList<Label>();;


  public Frame() {

    fillRootButtons();

    for (Button button : buttons) {
      button.getButton().addActionListener(e -> {

        int i = 0;
        for(File child : button.getChildren()) {
          Label l = new Label(child, i++);
          labels.add(l);
        }

        for(Label label : labels) {
          label.getButton().addActionListener(g -> {
            if(Util.hasSuccessors(label.getFile())) {
              fillLabels(label.getFile());
            }
          });
          this.add(label.getButton());
        }

      });

      for(Label label : labels) this.add(label.getButton());
      this.add(button.getButton());
    }


    frameConfig();
  }

  public void fillRootButtons() {
    int i = 0;
    for (File root : File.listRoots()) this.buttons.add(new Button(root, i++));
  }

  public void frameConfig() {
    this.setSize(Frame.getScreenSize());
    this.setLayout(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void fillLabels(File parent) {
    this.clearLabels();
    // add parent's successors to the list
    int i = 0;
    for(File successor : Util.getSuccessors(parent)) {
      this.labels.add(new Label(successor, i++));
    }
  }

  public void clearLabels() {
    // clear labels from JFrame
    for(Label l : labels) this.remove(l.getButton());
    // empty labels list
    labels.clear();
  }

  public static Dimension getScreenSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }

  // Has no use, but needed or else errors
  @Override
  public void actionPerformed(ActionEvent e) {}

}