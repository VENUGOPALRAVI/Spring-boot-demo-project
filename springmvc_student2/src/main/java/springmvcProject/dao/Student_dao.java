package springmvcProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvcProject.dto.Student_dto;

@Repository
public class Student_dao
{
	@Autowired
	EntityManager em;
	
	public Student_dto saveStudent(Student_dto s)
	{
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		return s;
		
	}
	
	public Student_dto findStudent(int student_id)
	{
		
		return em.find(Student_dto.class, student_id);
		
	}
	public List<Student_dto> findAll()
	{
		Query query = em.createQuery("select s from Student_dto s ");
		List <Student_dto> students= query.getResultList();
		
		return students;
		
		
	}
	public void deleteStudent(int id)
	{
		Student_dto exstudent = findStudent(id);
		if(exstudent!=null)
		{
			em.getTransaction().begin();
			em.remove(exstudent);
			em.getTransaction().commit();
		}
		
		
	}
	public Student_dto findByEmail(String email)
	{
		Query query= em.createQuery("select s from Student_dto s where studentemail=?1");
		query.setParameter(1, email);
		Student_dto student = (Student_dto) query.getSingleResult();
		if(student!=null)
		{
			return student;
		}
		return null;
	}
	public Student_dto updateStudent(Student_dto stu,int id)
	{
		Student_dto exstu= findStudent(id);
		if(exstu!=null)
		{
			stu.setStudent_id(id);
			em.getTransaction().begin();
			em.merge(stu);
			em.getTransaction().commit();
			return stu;
			
		}
		return null;
	}

}
