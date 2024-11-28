import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Window for searching employees by various criteria
public class SearchEmployeeWindow extends JFrame implements ActionListener 
{

    // Search interface components
    JTextField searchField;
    JButton searchButton;

    SearchEmployeeWindow() 
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 200);

        // Setup search interface
        JLabel searchLabel = new JLabel("Search by Name, SSN, or Employee ID:");
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        // Add components to window
        this.add(searchLabel);
        this.add(searchField);
        this.add(searchButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) // Process search request and display results
    {
        if (e.getSource() == searchButton) {
            String query = searchField.getText();
            for (Employee emp : AddEmployeeWindow.employeeList) { // Search through employee list for matches
                if (emp.matches(query)) {
                    JOptionPane.showMessageDialog(this, emp.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Employee not found!");
        }
    }
}

