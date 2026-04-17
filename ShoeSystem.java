import javax.swing.*;
import java.awt.*;

public class ShoeSystem {
    public static void main(String[] args) {
        // Start with the Login Screen instead of the console
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}

// 1. LOGIN GUI (Replaces the Scanner/Console input)
class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Shoe System - Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers window
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("  Enter Name:");
        JTextField nameField = new JTextField();
        
        JLabel contactLabel = new JLabel("  Enter Contact:");
        JTextField contactField = new JTextField();

        JButton loginBtn = new JButton("Launch System");

        add(nameLabel);
        add(nameField);
        add(contactLabel);
        add(contactField);
        add(new JLabel()); // Spacer
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String name = nameField.getText();
            String contact = contactField.getText();

            if (!name.isEmpty() && !contact.isEmpty()) {
                new MainMenu(name, contact);
                this.dispose(); // Close the login window
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all details.");
            }
        });

        setVisible(true);
    }
}

// 2. MAIN MENU GUI
class MainMenu extends JFrame {
    String userName;
    String contact;

    public MainMenu(String userName, String contact) {
        this.userName = userName;
        this.contact = contact;

        setTitle("Shoe Reservation System - Welcome " + userName);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        JLabel title = new JLabel("Welcome, " + userName, JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JButton viewShoesBtn = new JButton("View Shoes Catalog");
        JButton reserveBtn = new JButton("Make a Reservation");
        JButton exitBtn = new JButton("Exit");

        add(title);
        add(viewShoesBtn);
        add(reserveBtn);
        add(exitBtn);

        viewShoesBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Available Catalog:\n1. Nike - $100\n2. Adidas - $120\n3. Puma - $90");
        });

        reserveBtn.addActionListener(e -> new ReserveMenu(userName, contact));

        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}

// 3. RESERVE MENU GUI
class ReserveMenu extends JFrame {
    public ReserveMenu(String userName, String contact) {
        setTitle("Reserve Shoes");
        setSize(400, 350);
        // DISPOSE_ON_CLOSE means only this window closes, not the whole app
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel shoeLabel = new JLabel("  Select Shoe:");
        String[] shoes = {"Nike ($100)", "Adidas ($120)", "Puma ($90)"};
        JComboBox<String> shoeBox = new JComboBox<>(shoes);

        JLabel sizeLabel = new JLabel("  Size:");
        JTextField sizeField = new JTextField();

        JLabel qtyLabel = new JLabel("  Quantity:");
        JTextField qtyField = new JTextField();

        JButton confirmBtn = new JButton("Confirm");
        JButton cancelBtn = new JButton("Cancel");

        add(shoeLabel);
        add(shoeBox);
        add(sizeLabel);
        add(sizeField);
        add(qtyLabel);
        add(qtyField);
        add(cancelBtn);
        add(confirmBtn);

        confirmBtn.addActionListener(e -> {
            String shoe = (String) shoeBox.getSelectedItem();
            String size = sizeField.getText();
            String qty = qtyField.getText();

            if(size.isEmpty() || qty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please complete the form!");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "SUCCESS!\n\nCustomer: " + userName +
                    "\nContact: " + contact +
                    "\nItem: " + shoe +
                    "\nSize: " + size +
                    "\nQty: " + qty);
            this.dispose(); 
        });

        cancelBtn.addActionListener(e -> this.dispose());

        setVisible(true);
    }
}