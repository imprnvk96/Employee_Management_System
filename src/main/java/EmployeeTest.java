import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.impl.EmployeeServiceImpl;
import in.co.vwits.exceptions.EmployeeNotFoundException;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		int option=-1;
		Scanner sc = null;
		sc=new Scanner(System.in);
		do {
			System.out.println("Welcome......");
			System.out.println("1 Find all record");
			System.out.println("2 Insert a record");
			System.out.println("3 Find Employee by ID");
			System.out.println("4 Delete by ID");
			System.out.println("5 Update Name by ID :");
			System.out.println("6 Print Students in Ascending Order of Name: ");
			System.out.println("7 Print Students in Descending Order of Salary: ");
			System.out.println("-1 to exit");
			System.out.println("Enter Your Choice:");
			option = sc.nextInt();
			switch (option) {

			case 1:
				List<Employee> Employees= service.read();
				System.out.println(Employees);
				break;
			case 2:
				Employee s=new Employee();
				//Accept value from user
				System.out.println("Enter Name of Employee:");
				s.setName(sc.next());
				System.out.println("Enter ID:");
				s.setId(sc.nextInt());
				System.out.println("Enter Salary of Employee: ");
				s.setSalary(sc.nextInt());
				service.create(s);
				System.out.println("Data Saved");

				break;

			case 3:
				System.out.println("Enter ID:");
				int id=sc.nextInt();
				Optional<Employee> foundEmployee;
				try {
					foundEmployee = service.findById(id);
					System.out.println("Found Employee: "+foundEmployee.get());
				} catch (EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Employee not found");
				}

				break;
			
			case 4:
				int id1=0;
				System.out.println("Enter ID:");
				try {
					id1=sc.nextInt();
					service.deleteById(id1);
				}
				catch(InputMismatchException e)
				{
					System.out.println("ID must be Integer Value");
					sc.nextLine();
				}
				break;
			case 5:
				String modifiedName;
				System.out.println("Enter ID:");
				id=sc.nextInt();
				System.out.println("Enter New Name: ");
				modifiedName=sc.next();
				service.updateName(id,modifiedName);
				break;
			case 6:
				System.out.println(service.ascendingSortedByName());
				break;
			case 7:
				System.out.println(service.descendingSortedBySalary());
				break;
			}
		}while(option!=-1);
	}

}
