import javax.swing.JFrame;

import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Frame extends JFrame implements ActionListener {

  private ArrayList<Button> buttons;
  private ArrayList<Label> labels;
  private final File[] roots;
  private int iterable;

  public Frame() {

    this.roots = File.listRoots();

    this.buttons = new ArrayList<Button>();
    this.labels = new ArrayList<Label>();

    this.iterable = 0;
    for (File root : roots) buttons.add(new Button(root, iterable++));

    for (Button button : buttons) {
      button.getButton().addActionListener(e -> {
        this.iterable = 0;
        for(File child : button.getChildren()) {
          Label l = new Label(child, iterable);
          labels.add(l);
          iterable++;
        }
        for(Label label : labels) {
          label.getButton().addActionListener(g -> {
            if(Util.hasSuccessors(label.getFile())) {
              for(Label l : labels) this.remove(l.getButton());
              labels.clear();
              iterable = 0;
              for(File successor : Util.getSuccessors(label.getFile())) {
                labels.add(new Label(successor, iterable));
                iterable++;
              }
            }  
          });
          this.add(label.getButton());
        }
      });
      // Display Labels
      for(Label label : labels) this.add(label.getButton());
      this.add(button.getButton());
    }

    this.setSize(Frame.getScreenSize());
    this.setLayout(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static Dimension getScreenSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }

  // Has no use, but needed or else errors
  @Override
  public void actionPerformed(ActionEvent e) {}

}