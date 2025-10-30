package com.code.AnimatedCircleProgress;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedCircleProgress extends JPanel implements ActionListener {

    private int angle = 0;  // start at 0 degrees
    private final int radius = 100;
    private final int centerX = 150;
    private final int centerY = 150;
    private final Timer timer;

    public AnimatedCircleProgress() {
        // Timer calls actionPerformed() every few milliseconds
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw partial circle (only the part completed)
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, 0, -angle);

        // Draw current moving point
        double rad = Math.toRadians(angle);
        int x = (int) (centerX + radius * Math.cos(Math.toRadians(360 - angle)));
        int y = (int) (centerY - radius * Math.sin(Math.toRadians(360 - angle)));

        g2d.setColor(Color.RED);
        g2d.fillOval(x - 6, y - 6, 12, 12);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 2; // increase progress
        if (angle > 360) {
            angle = 360;
            timer.stop();
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Progressive Circle Drawing");
            AnimatedCircleProgress panel = new AnimatedCircleProgress();
            frame.add(panel);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
