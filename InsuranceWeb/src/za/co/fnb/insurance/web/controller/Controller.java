package za.co.fnb.insurance.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.fnb.insurance.session.PersonInterface;
import za.co.fnb.insurance.web.function.ControllerFunctions;

public class Controller extends HttpServlet {
	
	private ControllerFunctions functions = new ControllerFunctions();
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonInterface personBean;

	protected void doGet(HttpServletRequest request,
		        HttpServletResponse response) throws ServletException, IOException {
		        doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String action = request.getParameter("action");
			PrintWriter out = response.getWriter();
			
			String outMessage = "";
			
			if (action != null) {
				if (action.equalsIgnoreCase("addPerson")) {
					outMessage = functions.addPerson(request, response, personBean);
				}
				else if (action.equalsIgnoreCase("searchPersonByID")) {
					String idNo = request.getParameter("idNo");
					outMessage = functions.searchPersonByID(request, response, idNo, personBean);
				}
				else if (action.equalsIgnoreCase("getAllPersons")) {
					outMessage = functions.getAllPersons(request, response, personBean);
				}
			}			
			out.write(outMessage);
			out.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
