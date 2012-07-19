package za.co.fnb.insurance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="person")
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="personId", nullable=false)
	@Id
	@SequenceGenerator(name="personid_seq_gen", sequenceName="person_personid_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="personid_seq_gen")
	private Long personId;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="surname", nullable=false)
	private String surname;
	@Column(name="idNumber")
	private String idNumber;
	@Column(name="dateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name="physicalAddress")
	private String physicalAddress;
	@Column(name="postalAddress")
	private String postalAddress;
	@Column(name="contactNumber")
	private String contactNumber;
	@Column(name="personRole")
	@Enumerated(EnumType.STRING)
	private PersonRole personRole;
	
	public Person() {
		super();
	}
	
	public Person(String name, String surname, String idNumber, Date dateOfBirth,
			String physicalAddress, String postalAddress, String contactNumber,
			PersonRole personRole) {
		super();
		this.name = name;
		this.surname = surname;
		this.idNumber = idNumber;
		this.dateOfBirth = dateOfBirth;
		this.physicalAddress = physicalAddress;
		this.postalAddress = postalAddress;
		this.contactNumber = contactNumber;
		this.personRole = personRole;
	}

	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public PersonRole getPersonRole() {
		return personRole;
	}
	public void setPersonRole(PersonRole personRole) {
		this.personRole = personRole;
	}	
}
