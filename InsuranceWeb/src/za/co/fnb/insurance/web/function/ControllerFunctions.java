package za.co.fnb.insurance.web.function;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.fnb.insurance.entity.Person;
import za.co.fnb.insurance.entity.PersonRole;
import za.co.fnb.insurance.session.PersonInterface;

public class ControllerFunctions {
	
	public String searchPersonByID(HttpServletRequest request, HttpServletResponse response, String idNo, PersonInterface personBean) {
		Collection<Person> resultList = personBean.getPersonByIdNumber(idNo);
		
		String outMessage = "";
		for (Person p : resultList) {
			String tempLine = "";
			tempLine = tempLine + p.getName() + "<br/>";
			tempLine = tempLine + p.getSurname() + "<br/>";
			tempLine = tempLine + p.getIdNumber() + "<br/>";
			tempLine = tempLine + p.getDateOfBirth() + "<br/>";
			tempLine = tempLine + p.getPhysicalAddress() + "<br/>";
			tempLine = tempLine + p.getPostalAddress() + "<br/>";
			tempLine = tempLine + p.getContactNumber() + "<br/>";
			tempLine = tempLine + p.getPersonRole() + "<br/>";
			
			outMessage = outMessage + tempLine;
		}
		if (outMessage.length() == 0) {
			outMessage = "No results match search";
		}
		return "<span style='color:black;'>"+outMessage+"</span>";
	}
	
	public String addPerson(HttpServletRequest request, HttpServletResponse response, PersonInterface personBean) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String idNumber = request.getParameter("idNo");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String physicalAddress = request.getParameter("physicalAddress");
		String postalAddress = request.getParameter("postalAddress");
		String contactNumber = request.getParameter("contactNumber");
		String personRole = request.getParameter("personRole");
		
		Person p = personBean.addPerson(name, surname, idNumber, new Date(convertStringToDate(dateOfBirth)), physicalAddress, postalAddress, contactNumber, PersonRole.valueOf(personRole));
		
		if (p == null) {
			return "<span style='color:black;'>There was an error proccessing your request. Please click the back button in your browser, and try again.</span>";
		}
		else {
			return "<span style='color:black;'>Person saved succecssfully. Person ID is: "+p.getPersonId()+"</span>";
		}
	}
	
	public String getAllPersons(HttpServletRequest request, HttpServletResponse response, PersonInterface personBean) {
		Collection<Person> resultList = personBean.getAllPersons();
		
		String outMessage = "";
		for (Person p : resultList) {
			String tempLine = "";
			tempLine = tempLine + p.getName() + "<br/>";
			tempLine = tempLine + p.getSurname() + "<br/>";
			tempLine = tempLine + p.getIdNumber() + "<br/>";
			tempLine = tempLine + p.getDateOfBirth() + "<br/>";
			tempLine = tempLine + p.getPhysicalAddress() + "<br/>";
			tempLine = tempLine + p.getPostalAddress() + "<br/>";
			tempLine = tempLine + p.getContactNumber() + "<br/>";
			tempLine = tempLine + p.getPersonRole() + "<br/>";
			
			outMessage = outMessage + tempLine;
		}
		return "<span style='color:black;'>"+outMessage+"</span>";
	}
	
	private long convertStringToDate(String date) {
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
			Date dateNew = (Date)formatter.parse(date);
			return dateNew.getTime();
		}
		catch (Exception e) {
			return new Date().getTime();
		}
	}

}
