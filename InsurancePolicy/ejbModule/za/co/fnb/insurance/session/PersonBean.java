package za.co.fnb.insurance.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import za.co.fnb.insurance.entity.Person;
import za.co.fnb.insurance.entity.PersonRole;

@Stateless
public class PersonBean implements Serializable, PersonInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="insurance")
	EntityManager em;
	
	protected Person person;
	protected Collection<Person> personList;
	
	public PersonBean() {}
	
	public Person addPerson(String name, String surname, String idNumber,
			Date dateOfBirth, String physicalAddress, String postalAddress,
			String contactNumber, PersonRole personRole) {
		if (person == null) {
			person = new Person(name, surname, idNumber, dateOfBirth, physicalAddress, postalAddress, contactNumber, personRole);
			em.persist(person);
			return person;
		}
		else {
			return null;
		}
	}

	public Collection<Person> getAllPersons() {
		personList = em.createQuery("SELECT p FROM Person p").getResultList();
		return personList;
	}

	public Collection<Person> getPersonByIdNumber(String idNo) {
		Query q = em.createQuery("SELECT p FROM Person p WHERE p.idNumber LIKE :personID");
		q.setParameter("personID", idNo);
		personList = q.getResultList();
		return personList;
	}
}
