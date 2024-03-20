import java.awt.*;
import javax.swing.*;
public class GUI {
    private JButton btn1;
    private JButton btn2;
    private JButton btnBack;
    private JFrame frame;
    public void start(){
        btn1 = new JButton("Part 1");
        btn2 = new JButton("Part 2");

        frame = new JFrame("App");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel(new BorderLayout());

        btn1.setPreferredSize(new Dimension(100, 50));
        btn2.setPreferredSize(new Dimension(100, 50));
        
        btnPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        btnPanel.add(btn1, BorderLayout.NORTH);
        btnPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        btnPanel.add(btn2, BorderLayout.SOUTH);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        
        // Set JFrame properties
        frame.setSize(350, 125);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void part1(){
        frame.setVisible(false);

        btn1 = new JButton("Test Values");
        btn2 = new JButton("Generate Files");
        btnBack = new JButton("Back");

        JFrame frame = new JFrame("Testing Experiment Values");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel mainPanel = new JPanel(new BorderLayout());

        btn1.setPreferredSize(new Dimension(150, 50));
        btn2.setPreferredSize(new Dimension(150, 50));
        
        btnPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        btnPanel.add(btn1, BorderLayout.NORTH);
        btnPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        btnPanel.add(btn2, BorderLayout.SOUTH);

        backPanel.add(btnBack);

        mainPanel.add(btnPanel, BorderLayout.CENTER);
        mainPanel.add(backPanel, BorderLayout.EAST);

        frame.getContentPane().add(mainPanel);
        
        // Set JFrame properties
        frame.setSize(450, 125);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void part2(){
        frame.setVisible(false);

        btn1 = new JButton("Test Values");
        btn2 = new JButton("Generate Files");
        btnBack = new JButton("Back");

        JFrame frame = new JFrame("Testing Knowledge Base Values");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel(new BorderLayout());

        btn1.setPreferredSize(new Dimension(150, 50));
        btn2.setPreferredSize(new Dimension(150, 50));
        btnBack.setPreferredSize(new Dimension(50, 50));
        
        btnPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        btnPanel.add(btn1, BorderLayout.NORTH);
        btnPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        btnPanel.add(btn2, BorderLayout.SOUTH);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        
        // Set JFrame properties
        frame.setSize(450, 125);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getButton1(){
        return btn1;
    }

    public JButton getButton2(){
        return btn2;
    }

}
