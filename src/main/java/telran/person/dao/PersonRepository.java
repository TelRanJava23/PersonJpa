package telran.person.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.person.domain.Person;
import telran.person.dto.ChildDto;
import telran.person.dto.CityPopulation;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	List<Person> findByBirthDateBetween(LocalDate from, LocalDate to);

	List<Person> findByAddressCity(String city);
	
	@Query("select p from Person p where p.salary between :from and :to")
	List<Person> findBySalaryBetween(@Param("from") int fromSalary, @Param("to") int toSalary);

	@Query("select new telran.person.dto.ChildDto(p.name, p.address.city, p.kindergarten) from Person p where p.kindergarten is not null")
	Iterable<ChildDto> findChildren();
	
	@Query("select new telran.person.dto.CityPopulation(p.address.city, count(p)) from Person p group by p.address.city order by count(p) desc")
	Iterable<CityPopulation> getCityPopulations();
}
