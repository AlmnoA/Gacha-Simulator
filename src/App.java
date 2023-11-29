
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame {
    private JButton onePull;
    private JButton tenPull;
    private JTextField resultName;
    private JTextField resultDiscrption;
    private JLabel resultImage;
    public Wishing wish = new Wishing(new Rates(60, 90, 74, 600), new Rates(510, 10, 10, 0));
    private JButton a;

    App() {
        try {
            // wish.ReadOutcomesFromCSV("WishingOutcomes.csv");
        } catch (Exception e) {
            System.out.println("oops\n");
            e.printStackTrace();
        }

        onePull = new JButton("One pull");
        tenPull = new JButton("Ten pull");
a=new JButton("balls");
        onePull.addActionListener(new ActionListener() {
            @Override // is this syntax?
            public void actionPerformed(ActionEvent e) {
                System.out.println("reddt");
         a.setText("A");
            }
        });
        tenPull.addActionListener(new ActionListener() {
            @Override // is this syntax?
            public void actionPerformed(ActionEvent e) {
                a.setText("b");
            }
        });
        add(a);
        add(onePull);
        add(tenPull);

        setTitle("When the gambling");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });

    }
}