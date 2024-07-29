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

    for(Button button : buttons) {
      button.getButton().addActionListener(e -> {
        updateLabels(button.getFile());
      });
      this.add(button.getButton());
    }

    for(Label label : labels) {
      label.getButton().addActionListener(g -> {
        System.out.println(Util.getSuccessors(label.getFile()));
        updateLabels(label.getFile());
      });
    }

    addLabels();

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

  public void refresh() {

      this.setVisible(false);
      this.setVisible(true);
  }

  public void updateLabels(File pressed) {
    if(Util.hasSuccessors(pressed)) {
      for(Label l : labels) this.remove(l.getButton()); // clear labels from JFrame
      this.labels.clear(); // empty labels list
      this.refresh();
      this.fillLabels(pressed);
      this.addLabels();
    }
  }

  // add input's successors to labels
  public void fillLabels(File parent) {
    int i = 0;
    for (File successor : Util.getSuccessors(parent)) {
      this.labels.add(new Label(successor, i++));
    }
  }

  // Loop through labels, adding each to the JFrame
  public void addLabels() {
    for(Label label : labels) this.add(label.getButton());
  }

  public static Dimension getScreenSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }

  // Has no use, but needed or else errors
  @Override
  public void actionPerformed(ActionEvent e) {}

}