import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class trip extends JFrame implements ActionListener {

    // Components
    JLabel title, daysLabel, hotelLabel, foodLabel, transportLabel, resultLabel;
    JTextField daysField, hotelField, foodField, transportField;
    JButton calculateBtn, clearBtn;

    public trip() {
        setTitle("Travel Cost Calculator");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        title = new JLabel("Travel Cost Calculator");
        title.setBounds(80, 10, 250, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        // Days
        daysLabel = new JLabel("Number of Days:");
        daysLabel.setBounds(30, 60, 150, 25);
        add(daysLabel);

        daysField = new JTextField();
        daysField.setBounds(180, 60, 150, 25);
        add(daysField);

        // Hotel
        hotelLabel = new JLabel("Hotel Cost / Night:");
        hotelLabel.setBounds(30, 100, 150, 25);
        add(hotelLabel);

        hotelField = new JTextField();
        hotelField.setBounds(180, 100, 150, 25);
        add(hotelField);

        // Food
        foodLabel = new JLabel("Food Cost / Day:");
        foodLabel.setBounds(30, 140, 150, 25);
        add(foodLabel);

        foodField = new JTextField();
        foodField.setBounds(180, 140, 150, 25);
        add(foodField);

        // Transport
        transportLabel = new JLabel("Transport Cost:");
        transportLabel.setBounds(30, 180, 150, 25);
        add(transportLabel);

        transportField = new JTextField();
        transportField.setBounds(180, 180, 150, 25);
        add(transportField);

        // Buttons
        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(50, 230, 120, 30);
        calculateBtn.addActionListener(this);
        add(calculateBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(200, 230, 120, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);

        // Result
        resultLabel = new JLabel("Total Cost: ");
        resultLabel.setBounds(100, 280, 250, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == calculateBtn) {
                int days = Integer.parseInt(daysField.getText());
                double hotel = Double.parseDouble(hotelField.getText());
                double food = Double.parseDouble(foodField.getText());
                double transport = Double.parseDouble(transportField.getText());

                double total = (days * hotel) + (days * food) + transport;

                resultLabel.setText("Total Cost: $" + total);
            }

            if (e.getSource() == clearBtn) {
                daysField.setText("");
                hotelField.setText("");
                foodField.setText("");
                transportField.setText("");
                resultLabel.setText("Total Cost: ");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new trip();
    }
}