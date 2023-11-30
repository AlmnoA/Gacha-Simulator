import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame {
    private JButton onePull;
    private JButton tenPull;

    public Wishing wish = new Wishing(new Rates(60, 90, 74, 600), new Rates(510, 10, 10, 0));

    App() {
        try {
            wish.ReadOutcomesFromCSV("WishingOutcomes.csv");
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
                
                showResult(wish.summonThing(), 0);
            }
        });
        tenPull.addActionListener(new ActionListener() {
            @Override // is this syntax?
            public void actionPerformed(ActionEvent e) {
                for (int i = 9; i != 0; i--) {
                    showResult(wish.summonThing(), i + 1);
                }
            }
        });

        add(onePull);
        add(tenPull);

        setTitle("When the gambling");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    static void showResult(thing aThing, int number) {
        JFrame john = new JFrame();
        JLabel mary = new JLabel();
        JTextArea george = new JTextArea(
                (aThing.RaritytoString() + ": " + aThing.getName() + " " + aThing.getDiscription()));
        mary.setIcon((new ImageIcon(aThing.image)));

        john.add(george);
        john.add(mary);
        john.setTitle(Integer.toString(number) + " " + aThing.getName());
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