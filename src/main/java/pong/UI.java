package pong;

import javax.swing.*;
import java.awt.*;

public class UI {
    public static UI instance;
    public final JFrame frame = new JFrame(Constants.WINDOW_TITLE);
    public final KL keyListener = new KL();
    private Image img;

    private UI() {
    }

    public static UI getInstance() {
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }

    public void initWindow() {
        createAndShowGUI();
        createDbImage();
        frame.addKeyListener(keyListener);
//        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    private void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(new Dimension(Constants.WINDOW_W, Constants.WINDOW_H));
        frame.setLocationRelativeTo(null);

        Constants.INSETS_TOP = frame.getInsets().top;
    }

    public void createDbImage() {
        img = frame.createImage(frame.getWidth(), frame.getHeight());
    }

    public Graphics2D getDbGraphics() {
        return (Graphics2D) img.getGraphics();
    }

    public void drawDbImg() {
        frame.getGraphics().drawImage(img, 0, 0, frame);
    }

    public void setBackground(Graphics2D g) {
        g.setColor(Constants.SCREEN_BG);
        g.fillRect(0, 0, Constants.WINDOW_W, Constants.WINDOW_H);
    }
}
