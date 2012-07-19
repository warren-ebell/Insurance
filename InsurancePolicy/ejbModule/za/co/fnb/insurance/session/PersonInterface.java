package za.co.fnb.insurance.session;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Remote;

import za.co.fnb.insurance.entity.Person;
import za.co.fnb.insurance.entity.PersonRole;

@Remote
public interface PersonInterface {
	
	public Person addPerson(String name, String surname, String idNumber, Date dateOfBirth, String physicalAddress, String postalAddress, String contactNumber, PersonRole personRole);
	public Collection<Person> getAllPersons();
	public Collection<Person> getPersonByIdNumber(String idNo);

}
