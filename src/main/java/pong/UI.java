package pong;

import javax.swing.*;
import java.awt.*;

public class UI {
    public static UI instance;
    public final JFrame frame = new JFrame(Constants.WINDOW_TITLE);
    public final JPanel contentPane = new JPanel();
    public final KL keyListener = new KL();

    private UI() {
    }

    public static UI getInstance() {
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }

    public Graphics getGraphics() {
        return frame.getGraphics();
    }

    public void initWindow() {
        createAndShowGUI();
        // SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    private void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(new Dimension(Constants.WINDOW_W, Constants.WINDOW_H));
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(keyListener);

        contentPane.setBackground(new Color(0));
        contentPane.setFocusable(true);
        frame.setContentPane(contentPane);
    }
}
