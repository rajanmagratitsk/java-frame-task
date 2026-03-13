import javax.swing.*;

public class TopBar1 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Java GUI Top Bar");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem("Exit"));

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Paste"));

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(new JMenuItem("Options"));

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(toolsMenu);

        // Set menu bar to frame
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}