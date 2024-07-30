import javax.swing.JFrame;

import java.io.File;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Frame extends JFrame implements ActionListener {

  private ArrayList<FileTree> trees;

  public Frame() {

    createTrees();

    FileTree first = trees.get(0);

    first.getRootNode().open(); // Open C:/

    first.getRootNode().listFiles()[18].listFiles()[2].open(); // Open Program Files

    first.list();

    // frameConfig();

  }

  private void createTrees() {
    trees = new ArrayList<FileTree>();
    for(File root : File.listRoots()) {
      System.out.println(root);
      trees.add(new FileTree(root));
    }
  }

  public void frameConfig() {
    this.setSize(Frame.getScreenSize());
    this.setLayout(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void refresh() {
    this.invalidate();
    this.validate();
    this.repaint();
  }

  public static Dimension getScreenSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }

  // Has no use, but needed or else errors
  @Override
  public void actionPerformed(ActionEvent e) {}

}