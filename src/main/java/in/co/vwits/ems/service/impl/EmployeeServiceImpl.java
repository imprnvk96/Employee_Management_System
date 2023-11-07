package in.co.vwits.ems.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.ems.dao.impl.EmployeeDaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl {
	private EmployeeDaoImpl dao;
	public EmployeeServiceImpl() {
		dao=new EmployeeDaoImpl();
	}

	public void create(Employee e) {
		dao.save(e);
	}
	public List<Employee> read() {
		return dao.findAll();
	}
	public Optional<Employee> findById(int id) throws EmployeeNotFoundException{
		Optional<Employee> p = dao.findById(id);
		if(p.isPresent())
		{
			return p;
		}
		else
			//Throw user define exception "StudentNotFound"
			throw new EmployeeNotFoundException();
		//return p;
	}
	public void deleteById(int id){
		dao.delete(id);
	}
	public void updateName(int id, String name) {
		dao.updateName(id, name);
	}
	public List<Employee> ascendingSortedByName() {
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->e11.getName().compareTo(e22.getName()));
		return emps;

	}


	public List<Employee> descendingSortedBySalary() {
		return dao.findAll().stream()
				.sorted()
				.collect(Collectors.toList());
	}
}


