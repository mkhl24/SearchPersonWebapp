package dao;

import java.util.List;

import entity.Person;

public interface PersonDAO {
	
	List<Person> getByName(String name);
	List<Person> getByPatronymic(String patronymic);
	List<Person> getBySurname(String surname);
	List<Person> getByCity(String city);
	List<Person> getByCar(String car);
	List<Person> getByNameAndSurname(String name, String surname);
	List<Person> getByFio(String name, String patronymic, String surname);
	
}
