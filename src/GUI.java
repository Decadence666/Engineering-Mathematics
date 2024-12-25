import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;

public class GUI {
    private static final Color BACKGROUND_COLOR = new Color(51, 0, 51);
    private ImageIcon icon;
    private JFrame mainFrame;
    private JButton buttonCalc;
    private JLabel label;
    private JPanel panel;

    public GUI() {
        mainFrame = new JFrame();
        buttonCalc = new JButton("Calculate");
        label = new JLabel();
        icon = null;
    }

    public void menu() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(360, 540, 360, 540));
        panel.setLayout(new GridLayout(0, 1));
        buttonCalc.setPreferredSize(new Dimension(200, 50));
        panel.add(buttonCalc);

        mainFrame.add(panel, BorderLayout.CENTER);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Engineering Mathematics");
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setBackground(BACKGROUND_COLOR);
        //mainFrame.setIconImage(icon.getImage());
    }
}
