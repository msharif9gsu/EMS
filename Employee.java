// Represents an employee record with basic information and search functionality

public class Employee 
{
    // Basic employee information fields
    String name, ssn, empId, division;
    double salary;

    // Creates new employee with all required information
    Employee(String name, String ssn, String empId, double salary, String division) 
    {
        this.name = name;
        this.ssn = ssn;
        this.empId = empId;
        this.salary = salary;
        this.division = division;
    }

    // Checks if employee matches the given search criteria
    boolean matches(String query) 
    {
        return name.equalsIgnoreCase(query) || ssn.equals(query) || empId.equals(query);
    }

    @Override
    public String toString() // Formats employee information for display
    {
        return "Name: " + name + "\nSSN: " + ssn + "\nEmployee ID: " + empId + "\nSalary: $" + salary + "\nDivision: " + division;
    }
}

