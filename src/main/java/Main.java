import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static JFrame mainFrame;
    public static MainPanel mainPanel;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            mainFrame = new JFrame();
            mainFrame.setLayout(null);
            mainFrame.setBounds(200, 200, 640, 480);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainPanel = new MainPanel();
            mainFrame.add(mainPanel);
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }
}
