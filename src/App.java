import java.awt.*;
import javax.swing.*;
public class App {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Basic GUI Example");
        
        // Create a JButton
        JButton button = new JButton("Click Me");
        
        // Add an ActionListener to the button
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Button Clicked!");
        });
        
        // Add the button to the JFrame's content pane
        frame.getContentPane().add(button);
        
        // Set JFrame properties
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
