import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Window for adding new employees with input validation
public class AddEmployeeWindow extends JFrame implements ActionListener 
{

    // Input fields for employee information
    JTextField nameField, ssnField, empIdField, salaryField, divisionField;
    JButton submitButton;
    
    // Using a static arraylist as a central storage for all employees in the system
    static ArrayList<Employee> employeeList = new ArrayList<>();

    AddEmployeeWindow() 
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 400);

        // Creating labels for input fields
        JLabel nameLabel = new JLabel("Name:");
        JLabel ssnLabel = new JLabel("SSN:");
        JLabel empIdLabel = new JLabel("Employee ID:");
        JLabel salaryLabel = new JLabel("Salary:");
        JLabel divisionLabel = new JLabel("Division:");

        // Initialize input fields
        nameField = new JTextField(20);
        ssnField = new JTextField(20);
        empIdField = new JTextField(20);
        salaryField = new JTextField(20);
        divisionField = new JTextField(20);

        // Setup submit button
        submitButton = new JButton("Add Employee");
        submitButton.addActionListener(this);

        // Add all components to window
        this.add(nameLabel);
        this.add(nameField);
        this.add(ssnLabel);
        this.add(ssnField);
        this.add(empIdLabel);
        this.add(empIdField);
        this.add(salaryLabel);
        this.add(salaryField);
        this.add(divisionLabel);
        this.add(divisionField);
        this.add(submitButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) // Handle employee creation when submit button is clicked
    {
        // Collecting the input field values
        if (e.getSource() == submitButton) {    
            String name = nameField.getText();
            String ssn = ssnField.getText();
            String empId = empIdField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            String division = divisionField.getText();

            // Create and store new employee
            employeeList.add(new Employee(name, ssn, empId, salary, division));
            JOptionPane.showMessageDialog(this, "Employee Added!");
            this.dispose();
        }
    }
}

