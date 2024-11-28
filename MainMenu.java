import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main navigation window providing access to all system functions
public class MainMenu extends JFrame implements ActionListener 
{

    // Navigation buttons for different functions
    JButton addButton, searchButton, updateButton, reportButton;

    MainMenu() 
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500, 300);

        // Setup main title
        JLabel titleLabel = new JLabel("Employee Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titleLabel);

        // Initialize and setup navigation buttons
        addButton = new JButton("Add Employee");
        searchButton = new JButton("Search Employee");
        updateButton = new JButton("Update Employee");
        reportButton = new JButton("Generate Reports");

        // Add listeners for button clicks
        addButton.addActionListener(this);
        searchButton.addActionListener(this);
        updateButton.addActionListener(this);
        reportButton.addActionListener(this);

        // Add components to window
        this.add(addButton);
        this.add(searchButton);
        this.add(updateButton);
        this.add(reportButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) // Handle navigation to different windows based on button clicks
    {
        if (e.getSource() == addButton) {
            new AddEmployeeWindow();
        } else if (e.getSource() == searchButton) {
            new SearchEmployeeWindow();
        } else if (e.getSource() == updateButton) {
            new UpdateEmployeeWindow();
        } else if (e.getSource() == reportButton) {
            new ReportWindow();
        }
    }
}
