
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.naming.spi.DirStateFactory.Result;
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

        onePull.addActionListener(new ActionListener() {
            @Override // is this syntax?
            public void actionPerformed(ActionEvent e) {
                System.out.println("reddt");
                for (int i = 0; i < 10; i++) {
                    showResult(wish.summonThing());
                }
            }
        });
        tenPull.addActionListener(new ActionListener() {
            @Override // is this syntax?
            public void actionPerformed(ActionEvent e) {
                System.out.println("\u001B[31m" + "yellow(real)(your color blind)");
            }
        });

        add(onePull);
        add(tenPull);

        setTitle("When the gambling");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    static void showResult(thing aThing) {
        JFrame john = new JFrame();
        john.setTitle(aThing.getName());
        john.setSize(300, 400);
        john.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        john.setLayout(new FlowLayout());
        john.setLocationRelativeTo(null);
        john.setVisible(true);
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