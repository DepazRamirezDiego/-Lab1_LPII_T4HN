package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	
	//Crear Empleado
	public String createEmpleado(String apellidos, String nombres, int edad, String sexo, double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		
		try {
			Empleado empleado = new Empleado(apellidos, nombres, edad, sexo, salario);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
		
			return "Empleado creado:D";
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	
		return "Error al registrar EmpleadoD:";
	
	}


	//Eliminar Empleado
	public String deleteEmpleado (int id_empleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		//se abre metodo
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, id_empleado);
			session.delete(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Empleado eliminado correctamente:D";
			
		
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	
		return "Error al eliminar EmpleadoD:";
	
	}
	
	//Actualizar Empleado
	public String updateEmpleado(int id_empleado, String nombres) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			

		
		session.beginTransaction();
		Empleado empleado = session.get(Empleado.class, id_empleado);
		empleado.setNombres(nombres);
		session.update(empleado);
		session.getTransaction().commit();
		
		sessionFactory.close();
		
		return "Empleado actualizado correctamente:D";
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al actualizar registroD:";
	
	}
	
	//Leer Empleado
	public String getEmpleado(int id_empleado) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	
		Session session = sessionFactory.openSession();
	
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, id_empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return empleado.toString();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return "Empleado no encontradoD:";
		
	}
			
}
	