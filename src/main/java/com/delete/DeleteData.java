package com.delete;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javatpoint.Employee;

public class DeleteData 
{


	public static void main(String[] args) 
	{
	
		Configuration cfg = new Configuration();
		cfg.configure("com.cfg.xml");
		SessionFactory factory  = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query ="from Employee s where s.id=:x and s.lastName=:n";
		Query q=s.createQuery(query);
		//		q.setParameter("x", "shivam");
		List<Employee> list = q.list();
		
		for(Employee student: list)
		{
			System.out.println(student.getLastName() +" "+ student.getId());
		}
		
		System.out.println("_________________________________________________________");
		
		Transaction tx = s.beginTransaction();
//		Query q2=s.createQuery("delete from Employee s where s.id=:c");
//		q2.setParameter("c", 123);
//		int r = q2.executeUpdate();
//		System.out.println("Deleted! ");
//		System.out.println(r);

		
//		UPDATE QUERY
		Query q2 = s.createQuery("update Student set id=:c where firestName =:n");
		q2.setParameter(123, "Deepak");
		q2.setParameter(124, "Peter");
		int r = q2.executeUpdate();
		System.out.println(r +"objects Updated ");
		tx.commit();

        
//		INNER JOIN
		Query q3 =s.createQuery("select q.question , q.questionId , a.answer from Question as INNER JOIN q.answers as a");
		List<Object []> list3 = q3.getResultList();
		for(Object[] arr : list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		
			
		s.close();
		factory.close();
	}
}