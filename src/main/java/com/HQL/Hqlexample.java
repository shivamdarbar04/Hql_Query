package com.HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javatpoint.Employee;

public class Hqlexample 
{

	public static void main(String[] args) 
	{
	
		Configuration cfg = new Configuration();
		cfg.configure("com.cfg.xml");
		SessionFactory factory  = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query ="from Employee where lastName=:x";
		Query q = s.createQuery(query);
//		q.setParameter("x", "shivam");
		List<Employee> list = q.list();
		
		for(Employee student: list)
		{
			System.out.println(student.getLastName());
		}
		
		s.close();
		factory.close();
	}
}
