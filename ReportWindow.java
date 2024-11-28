import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

// Window for generating various employee reports and statistics
public class ReportWindow extends JFrame implements ActionListener 
{

    // Report interface components
    JButton fullTimeReportButton, payByTitleButton, payByDivisionButton;
    JTextArea reportArea;

    ReportWindow() 
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600, 500);

        // Setup report display area
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(reportArea);

        // Initialize report buttons
        fullTimeReportButton = new JButton("Full-Time Employee Info");
        payByTitleButton = new JButton("Total Pay by Job Title");
        payByDivisionButton = new JButton("Total Pay by Division");

        // Add listeners
        fullTimeReportButton.addActionListener(this);
        payByTitleButton.addActionListener(this);
        payByDivisionButton.addActionListener(this);

        // Layout components
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(fullTimeReportButton);
        buttonPanel.add(payByTitleButton);
        buttonPanel.add(payByDivisionButton);

        this.add(new JLabel("Generate Reports", SwingConstants.CENTER), BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // Handle different report generation requests
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == fullTimeReportButton) {
            generateFullTimeReport();
        } else if (e.getSource() == payByTitleButton) {
            generatePayByTitleReport();
        } else if (e.getSource() == payByDivisionButton) {
            generatePayByDivisionReport();
        }
    }

    // Generate comprehensive employee listing
    private void generateFullTimeReport() 
    {
        StringBuilder report = new StringBuilder("Full-Time Employee Information:\n");
        report.append("--------------------------------------------------\n");
        for (Employee emp : AddEmployeeWindow.employeeList) {
            report.append(emp.toString()).append("\n");
            report.append("---------------------------------------------------\n");
        }
        reportArea.setText(report.toString());
    }

    // Calculate and display salary totals by job title
    private void generatePayByTitleReport() 
    {
        HashMap<String, Double> payByTitle = new HashMap<>(); 
        for (Employee emp : AddEmployeeWindow.employeeList) { // Aggregate salaries by title
            payByTitle.put(emp.empId, payByTitle.getOrDefault(emp.empId, 0.0) + emp.salary);
        }
        
        // Format report
        StringBuilder report = new StringBuilder("Total Pay by Job Title:\n");
        report.append("--------------------------------------------------\n");
        for (String title : payByTitle.keySet()) {
            report.append("Title: ").append(title)
                  .append(", Total Pay: $").append(payByTitle.get(title)).append("\n");
        }
        reportArea.setText(report.toString());
    }

    // Calculate and display salary totals by division
    private void generatePayByDivisionReport() 
    {
        HashMap<String, Double> payByDivision = new HashMap<>(); 
        for (Employee emp : AddEmployeeWindow.employeeList) { // Aggregate salaries by division
            payByDivision.put(emp.division, 
                payByDivision.getOrDefault(emp.division, 0.0) + emp.salary);
        }
        // Format report
        StringBuilder report = new StringBuilder("Total Pay by Division:\n");
        report.append("--------------------------------------------------\n");
        for (String division : payByDivision.keySet()) {
            report.append("Division: ").append(division)
                  .append(", Total Pay: $").append(payByDivision.get(division)).append("\n");
        }
        reportArea.setText(report.toString());
    }
}
