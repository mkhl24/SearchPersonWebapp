package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import dao.PersonDAO;
import entity.Person;

public class PersonService extends Util implements PersonDAO {
	
	public static final String PS_GET_BY_NAME = "SELECT name, patronymic, surname, city, cars.registration_number"
			+ "	FROM public.persons JOIN public.cars ON persons._id = cars.person_id "
			+ "	WHERE name LIKE ?";
	public static final String PS_GET_BY_PATRONYMIC = "SELECT name, patronymic, surname, city, cars.registration_number"
			+ "	FROM public.persons JOIN public.cars ON persons._id = cars.person_id "
			+ "	WHERE patronymic LIKE ?"; 
	public static final String PS_GET_BY_SURNAME = "SELECT name, patronymic, surname, city, cars.registration_number"
			+ " FROM public.persons JOIN public.cars ON persons._id = cars.person_id "
			+ " WHERE surname LIKE ?";
	public static final String PS_GET_BY_CITY = "SELECT name, patronymic, surname, city, cars.registration_number"
			+ " FROM public.persons JOIN public.cars ON persons._id = cars.person_id"
			+ " WHERE city LIKE ?";
	public static final String PS_GET_BY_CAR = "SELECT persons.name, persons.patronymic," 
			+ " persons.surname, persons.city, registration_number"
			+ "	FROM public.cars JOIN public.persons"
			+ "	ON cars.person_id = persons._id"
			+ "	WHERE registration_number LIKE ?";
	public static final String PS_GET_BY_NAME_AND_SURNAME = "SELECT name, patronymic, surname, city, cars.registration_number"
			+ "	FROM public.persons JOIN public.cars ON persons._id = cars.person_id "
			+ "	WHERE name LIKE ? AND surname LIKE ?";
	public static final String PS_GET_BY_FIO = "SELECT name, patronymic, surname, city, cars.registration_number"
			+ "	FROM public.persons JOIN public.cars ON persons._id = cars.person_id "
			+ "	WHERE name LIKE ? AND patronymic LIKE ? AND surname LIKE ?";
	
	DataSource ds = getDataSource();
	
	private List<Person> parseResultSet(ResultSet resultSet) throws SQLException {
		List<Person> persons = new ArrayList<Person>();
		
		while (resultSet.next()) {
			Person person = new Person();
			person.setName(resultSet.getString(1));
			person.setPatronymic(resultSet.getString(2));
			person.setSurname(resultSet.getString(3));
			person.setCity(resultSet.getString(4));
			if (resultSet.getString(5) == null) {
				person.setCar("");
			} else {
				person.setCar(resultSet.getString(5));
			}
			
			
			persons.add(person);

		}
		return persons;
	}

	@Override
	public List<Person> getByName(String name) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_NAME);
			ps.setString(1, name);			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public List<Person> getByPatronymic(String patronymic) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_PATRONYMIC);
			ps.setString(1, patronymic);
			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public List<Person> getBySurname(String surname) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_SURNAME);
			ps.setString(1, surname);
			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public List<Person> getByCity(String city) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_CITY);
			ps.setString(1, city);
			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public List<Person> getByCar(String car) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_CAR);
			ps.setString(1, car);
			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public List<Person> getByNameAndSurname(String name, String surname) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_NAME_AND_SURNAME);
			ps.setString(1, name);
			ps.setString(2, surname);
			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Person> getByFio(String name, String patronymic, String surname) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(PS_GET_BY_FIO);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, surname);
			
			ResultSet resultSet = ps.executeQuery();
			return parseResultSet(resultSet);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
