import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryManagementSystemGUI {
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        UserAuthentication auth = new UserAuthentication();

        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(150, 50, 150, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(150, 100, 150, 25);
        frame.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 25);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (auth.authenticate(username, password)) {
                    showInventoryManagement(frame);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static void showInventoryManagement(JFrame frame) {
        frame.getContentPane().removeAll();

        JLabel titleLabel = new JLabel("Inventory Management");
        titleLabel.setBounds(100, 20, 200, 25);
        frame.add(titleLabel);

        JButton addButton = new JButton("Add Product");
        addButton.setBounds(50, 60, 150, 25);
        frame.add(addButton);

        JButton viewButton = new JButton("View Inventory");
        viewButton.setBounds(50, 100, 150, 25);
        frame.add(viewButton);

        JButton reportButton = new JButton("Low Stock Report");
        reportButton.setBounds(50, 140, 150, 25);
        frame.add(reportButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Enter product ID:");
                String name = JOptionPane.showInputDialog("Enter product name:");
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));

                Product product = new Product(id, name, quantity, price);
                inventory.addProduct(product);

                JOptionPane.showMessageDialog(frame, "Product added successfully!");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder inventoryList = new StringBuilder();
                for (Product product : inventory.getProducts()) {
                    inventoryList.append("ID: ").append(product.getId())
                            .append(", Name: ").append(product.getName())
                            .append(", Quantity: ").append(product.getQuantity())
                            .append(", Price: $").append(product.getPrice())
                            .append("\n");
                }
                JOptionPane.showMessageDialog(frame, inventoryList.toString());
            }
        });

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Product> lowStockProducts = inventory.getLowStockProducts(10);
                if (lowStockProducts.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No products are low in stock.");
                } else {
                    StringBuilder report = new StringBuilder();
                    for (Product product : lowStockProducts) {
                        report.append("ID: ").append(product.getId())
                                .append(", Name: ").append(product.getName())
                                .append(", Quantity: ").append(product.getQuantity())
                                .append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, report.toString());
                }
            }
        });

        frame.revalidate();
        frame.repaint();
    }
}
