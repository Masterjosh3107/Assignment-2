import java.awt.*;
import javax.swing.*;
public class GUI {
    private JButton btn1 = new JButton("Part 1");
    private JButton btn2 = new JButton("Part 2");

    private JButton btn3 = new JButton("Test Values");
    private JButton btn4 = new JButton("Test Values");

    private JButton btnBack1 = new JButton("Back");
    private JButton btnBack2 = new JButton("Back");

    private JFrame mainFrame = new JFrame("App");
    private JFrame framePart1 = new JFrame("Testing Experiment Values");
    private JFrame framePart2 = new JFrame("Testing Generics Knowledge Base Values");

    public void start(){

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel(new BorderLayout());

        btn1.setPreferredSize(new Dimension(100, 50));
        btn2.setPreferredSize(new Dimension(100, 50));
        
        btnPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        btnPanel.add(btn1, BorderLayout.NORTH);
        btnPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        btnPanel.add(btn2, BorderLayout.SOUTH);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        mainFrame.getContentPane().add(mainPanel);
        
        mainFrame.setSize(350, 150);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        btn1.addActionListener(e -> part1());
        btn2.addActionListener(e -> part2());

        
    }

    public void part1(){
        mainFrame.setVisible(false);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel(new BorderLayout());

        btn3.setPreferredSize(new Dimension(150, 50));
        btnBack1.setPreferredSize(new Dimension(80, 25));
        
        btnPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        btnPanel.add(btn3, BorderLayout.WEST);
        btnPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        backPanel.add(Box.createRigidArea(new Dimension(280, 0)));
        backPanel.add(btnBack1);

        mainPanel.add(btnPanel, BorderLayout.CENTER);
        mainPanel.add(backPanel, BorderLayout.SOUTH);

        framePart1.getContentPane().add(mainPanel);
        
        framePart1.setSize(425, 175);
        framePart1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePart1.setLocationRelativeTo(null);
        framePart1.setVisible(true);

        btnBack1.addActionListener(e -> backButton());
    }

    public void part2(){
        mainFrame.setVisible(false);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel(new BorderLayout());

        btn4.setPreferredSize(new Dimension(150, 50));
        btnBack2.setPreferredSize(new Dimension(80, 25));
        
        btnPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        btnPanel.add(btn4, BorderLayout.WEST);
        btnPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        backPanel.add(Box.createRigidArea(new Dimension(280, 0)));
        backPanel.add(btnBack2);

        mainPanel.add(btnPanel, BorderLayout.CENTER);
        mainPanel.add(backPanel, BorderLayout.SOUTH);

        framePart2.getContentPane().add(mainPanel);
        
        framePart2.setSize(425, 175);
        framePart2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePart2.setLocationRelativeTo(null);
        framePart2.setVisible(true);

        btnBack2.addActionListener(e -> backButton());
    }

    public void showMessage1(){
        JOptionPane.showMessageDialog(framePart1, "Close program to see generated output, stored in output.txt or continue to Part 2");
    }

    public void showMessage2(){
        JOptionPane.showMessageDialog(framePart1, "Close program to see generated output, stored in output.txt");
    }

    public void backButton(){
        framePart1.setVisible(false);
        framePart2.setVisible(false);
        start();
    }

    public JButton getButton3(){
        return btn3;
    }

    public JButton getButton4(){
        return btn4;
    }

    public JButton getBackButton1(){
        return btnBack1;
    }

    public JButton getBackButton2(){
        return btnBack2;
    }

}
