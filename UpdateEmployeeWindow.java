import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Window for updating employee details and performing salary adjustments
public class UpdateEmployeeWindow extends JFrame implements ActionListener 
{

    JTextField searchField, newNameField, newDivisionField, percentageField, minSalaryField, maxSalaryField;
    JButton searchButton, updateDetailsButton, updateSalaryButton;
    
    // Tracks currently selected employee for updates
    Employee selectedEmployee = null;

    UpdateEmployeeWindow() 
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500, 400);

        JLabel searchLabel = new JLabel("Search by Name, SSN, or Employee ID:");
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        JLabel newNameLabel = new JLabel("New Name:");
        newNameField = new JTextField(20);
        JLabel newDivisionLabel = new JLabel("New Division:");
        newDivisionField = new JTextField(20);
        updateDetailsButton = new JButton("Update Details");
        updateDetailsButton.addActionListener(this);

        JLabel percentageLabel = new JLabel("Increase Salary by (%) for Range:");
        percentageField = new JTextField(5);
        JLabel minSalaryLabel = new JLabel("Min Salary:");
        minSalaryField = new JTextField(10);
        JLabel maxSalaryLabel = new JLabel("Max Salary:");
        maxSalaryField = new JTextField(10);
        updateSalaryButton = new JButton("Update Salaries");
        updateSalaryButton.addActionListener(this);

        this.add(searchLabel);
        this.add(searchField);
        this.add(searchButton);

        this.add(newNameLabel);
        this.add(newNameField);
        this.add(newDivisionLabel);
        this.add(newDivisionField);
        this.add(updateDetailsButton);

        this.add(percentageLabel);
        this.add(percentageField);
        this.add(minSalaryLabel);
        this.add(minSalaryField);
        this.add(maxSalaryLabel);
        this.add(maxSalaryField);
        this.add(updateSalaryButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == searchButton) { // Handling the search button click
            String query = searchField.getText();
            for (Employee emp : AddEmployeeWindow.employeeList) {
                if (emp.matches(query)) { // Check if the employee matches the search query
                    selectedEmployee = emp; // Store the found employee
                    JOptionPane.showMessageDialog(this, "Employee Found: \n" + emp.toString()); // Display employee details
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Employee not found!"); // Show error if no employee is found
        } else if (e.getSource() == updateDetailsButton) { // Handling the update details button click
            if (selectedEmployee != null) { // Update the name and division if new values are provided
                String newName = newNameField.getText();
                String newDivision = newDivisionField.getText();

                if (!newName.isEmpty()) selectedEmployee.name = newName;
                if (!newDivision.isEmpty()) selectedEmployee.division = newDivision;

                JOptionPane.showMessageDialog(this, "Details Updated!\n" + selectedEmployee.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Please search for an employee first!");
            }
        } else if (e.getSource() == updateSalaryButton) { // Handling the update salary button click
            try { // Parse the percentage, min salary, and max salary from the input fields
                double percentage = Double.parseDouble(percentageField.getText());
                double minSalary = Double.parseDouble(minSalaryField.getText());
                double maxSalary = Double.parseDouble(maxSalaryField.getText());
                for (Employee emp : AddEmployeeWindow.employeeList) { // Update the salary for employees within the specified range
                    if (emp.salary >= minSalary && emp.salary <= maxSalary) {
                        emp.salary += emp.salary * (percentage / 100);
                    }
                }
                JOptionPane.showMessageDialog(this, "Salaries Updated for Range!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.");
            }
        }
    }
}

