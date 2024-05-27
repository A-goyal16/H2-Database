package h2.controller;

import java.util.List;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import h2.dto.Student;


@Controller
public class StudentController 
{
	@Autowired
	EntityManager entityManager;
	
	
	@GetMapping("/")
	public String hello() {
		return "home";
	}
	
	@PostMapping("/save")
	public String saveUser(Student student, ModelMap map) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		map.put("msg", "Inserted Success");
		return "home";
	}
	
	@GetMapping("/load")
	public String loadInsertPage() {
		return "savedata";
	}
	
	
	@GetMapping("/getData")
	@ResponseBody
	public String getData() {
		List<Student> list = entityManager.createQuery("select x from Student x").getResultList();
		list.forEach(x -> System.out.println("Name: "+x.getName() + " Address: " + x.getAddress()));
		return "done";
	}
	
	@GetMapping("/loadupdate")
	public String loadUpdate() {
		return "update";
	}

	@GetMapping("/updatest")
	public ModelAndView updateStudent(@RequestParam int id) {
		Student student = entityManager.find(Student.class, id);
		ModelAndView view=new ModelAndView();
		if (!student.equals(null)) {
			view.addObject("student", student);
			view.setViewName("updatedata");
		} else {
			System.out.println("data not found");
			view.setViewName("home");
		}
		return view;
	}
	
	@PostMapping("/updatesave")
	public ModelAndView updatesave(Student student)
	{
		ModelAndView view=new ModelAndView();
		entityManager.getTransaction().begin();
		entityManager.merge(student);
		entityManager.getTransaction().commit();
		view.setViewName("home");
		return view;
	}

	@GetMapping("/loaddelete")
	public String loaddelete() {
		return "delete";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int id) {
		Student stuid = entityManager.find(Student.class, id);
		if (stuid.equals(null)) {
			System.out.println("Data not found");
		} else {
			Student student = new Student();
			entityManager.getTransaction().begin();
			entityManager.remove(stuid);
			entityManager.getTransaction().commit();
		}
		return "home";
	}
}
