package entity;

public class Person {
	private String name;
	private String patronymic;
	private String surname;
	private String city;
	private String car;
	
	public Person() {
	}
	
	public Person(String personName, String personPatronymic, String personSurname,
			String personCity, String personCar) {
		this.name = personName;
		this.patronymic = personPatronymic;
		this.surname = personSurname;
		this.city = personCity;
		this.car = personCar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	

}
