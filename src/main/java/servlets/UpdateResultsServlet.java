package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import dao.PersonDAO;
import entity.Person;
import service.AppLogger;
import service.PersonService;


@WebServlet("/update")
public class UpdateResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDAO personDao = new PersonService();
	
	AppLogger logger = AppLogger.getInstance(); 
       

    public UpdateResultsServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		String name = request.getParameter("name");
		String patronymic = request.getParameter("patronymic");
		String surname = request.getParameter("surname");
		String city = request.getParameter("city");
		String car = request.getParameter("car");
		
		List<Person> persons = new ArrayList<Person>();
		
		boolean isValid = false;
		boolean isValidName = false;
		boolean isValidPatronymic = false;
		boolean isValidSurname = false;
		boolean isValidCity = false;
		boolean isValidCar = false;
			
		if (name != null && name.trim().length() != 0) {
			map.put("name", name);
			isValidName = true;
		} 
		
		if (patronymic != null && patronymic.trim().length() != 0) {
			map.put("patronymic", patronymic);
			isValidPatronymic = true;
		} 
		
		if (surname != null && surname.trim().length() != 0) {
			map.put("surname", surname);
			isValidSurname = true;
		} 
		
		if (city != null && city.trim().length() != 0) {
			map.put("city", city);
			isValidCity = true;
		} 

		if (car != null && car.trim().length() != 0) {
			map.put("car", car);
			isValidCar = true;
		} 
		
		if (isValidName || isValidPatronymic || isValidSurname || isValidCity || isValidCar) {
			isValid = true;
		}
		
		map.put("isValid", isValid);
		
		//  only name
		if (isValidName && !isValidPatronymic && !isValidSurname && !isValidCity && !isValidCar) {
			persons = personDao.getByName(name);
			map.put("persons", persons);
		}
		
		//  only patronymic
		if (!isValidName && isValidPatronymic && !isValidSurname && !isValidCity && !isValidCar) {
			persons = personDao.getByPatronymic(patronymic);
			map.put("persons", persons);
		}
		
		//  only surname
		if (!isValidName && !isValidPatronymic && isValidSurname && !isValidCity && !isValidCar) {
			persons = personDao.getBySurname(surname);
			map.put("persons", persons);
		}
		
		//  only city
		if (!isValidName && !isValidPatronymic && !isValidSurname && isValidCity && !isValidCar) {
			persons = personDao.getByCity(city);
			map.put("persons", persons);
		}
		
		//  only car
		if (!isValidName && !isValidPatronymic && !isValidSurname && !isValidCity && isValidCar) {
			persons = personDao.getByCar(car);
			map.put("persons", persons);
		}
		
		//  only name and surname
		if (isValidName && !isValidPatronymic && isValidSurname && !isValidCity && !isValidCar) {
			persons = personDao.getByNameAndSurname(name, surname);
			map.put("persons", persons);
		}
		
		//  full fio
		if (isValidName && isValidPatronymic && isValidSurname && !isValidCity && !isValidCar) {
				persons = personDao.getByFio(name, patronymic, surname);
				map.put("persons", persons);
		}
		
		logger.writeLog(Level.INFO, "Запрос на предоставление информации: " +
				" name=" + name +
				", patronymic=" + patronymic +
				", surname=" + surname +
				", city=" + city +
				", car=" + car);
		write(response, map);
		
	}


	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");	
		response.setCharacterEncoding("UTF-8");
		response.getWriter().
					write(new Gson().
					toJson(map));
	}

}
