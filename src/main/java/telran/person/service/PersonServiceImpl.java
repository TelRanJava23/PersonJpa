package telran.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.person.dao.PersonRepository;
import telran.person.domain.Address;
import telran.person.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository repository;

	@Override
	public void addPerson(Person person) {
		repository.save(person);

	}

	@Override
	public Person getPerson(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public boolean removePerson(int id) {
		Person person = repository.findById(id).orElse(null);
		if (person == null) {
			return false;
		}
		repository.delete(person);
		return true;
	}

	@Override
	public boolean updateAddress(int id, Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Person> getPersonByAge(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> getPersonByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> getEmployeeBySalary(int minSalary, int maxSalary) {
		// TODO Auto-generated method stub
		return null;
	}

}
