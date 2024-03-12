// ITELEC1: Object-oriented Programming (ASSESSMENT 3: Program Defense)

//----------------------------------------------------------------

/* This program first creates an ArrayList numbers containing numbers from 1 to 49. 
   It then uses a loop to pick six distinct numbers by randomly selecting an index from the ArrayList, removing that element, 
   and adding it to the lotteryCombination ArrayList. 
   Finally, it sorts the lotteryCombination list and prints the result in any order. */

//----------------------------------------------------------------

// Author: CAPISTRANO, John Jabez
// BS_INFORMATION TECHNOLOGY 2D
// September 15, 2023

//----------------------------------------------------------------

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class LotteryGeneratorGUI extends JFrame {

    private JLabel resultLabel;

    public LotteryGeneratorGUI() {
        super("Lottery Number Generator");

        JPanel panel = new JPanel();
        JButton generateButton = new JButton("Generate Lottery Numbers");
        JButton saveButton = new JButton("Save to Database");
        resultLabel = new JLabel("Lottery Combination: ");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateLotteryNumbers();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToDatabase(resultLabel.getText());
            }
        });

        panel.add(generateButton);
        panel.add(saveButton);
        panel.add(resultLabel);

        add(panel);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateLotteryNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        StringBuilder result = new StringBuilder("Lottery Combination: ");
        for (int i = 0; i < 6; i++) {
            int pickedNumber = numbers.remove(0);
            result.append(pickedNumber).append(" ");
        }

        resultLabel.setText(result.toString());
    }

    private void saveToDatabase(String lotteryCombination) {
        String url = "jdbc:mariadb://localhost:3306/lotterydatabase";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/lotterydatabase", "root", "")) {
            String sql = "INSERT INTO lottery_numbers(number) VALUES(?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, lotteryCombination);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Lottery combination saved to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving to the database.");
        }
    }

    public static void main(String[] args) {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LotteryGeneratorGUI();
            }
        });
    }
}
