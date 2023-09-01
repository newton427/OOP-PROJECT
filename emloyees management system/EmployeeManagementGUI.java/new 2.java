import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public EmployeeManagementGUI() {
        setTitle("Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        
        add(loginPanel);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (AccessControl.authenticate(username, password)) {
                    openManagerPanel(username);
                } else {
                    JOptionPane.showMessageDialog(EmployeeManagementGUI.this, "Invalid credentials");
                }
            }
        });
    }
    
    private void openManagerPanel(String username) {
        if (AccessControl.hasAccess(username)) {
            // Open the manager panel for authorized users
            // Implement the GUI for managing employees, attendance, etc.
        } else {
            JOptionPane.showMessageDialog(this, "Access denied");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EmployeeManagementGUI gui = new EmployeeManagementGUI();
                gui.setVisible(true);
            }
        });
    }
}
