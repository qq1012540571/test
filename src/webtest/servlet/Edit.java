package webtest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import webtest.dao.GuestBookDao;
import webtest.model.GuestBookEntry;


@SuppressWarnings("unused")
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<GuestBookEntry> guests;
	String name, specialties, presentation;
	int id;

	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		       String id=request.getParameter("id");
		GuestBookDao guestBookDao=new GuestBookDao();
		GuestBookEntry guestBookEntry=guestBookDao.selectbyid(Long.valueOf(id));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String  a= JSON.toJSONString(guestBookEntry);
		out.write(a);
        }

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Alter the specific guest
		GuestBookEntry guest = guests.get(id);
		name = request.getParameter("name");
		specialties = request.getParameter("specialties");
		presentation = request.getParameter("presentation");
		guest.setName(name);
		guest.setSpecialties(specialties);
		guest.setPresentation(presentation);
		//Get all guests from application scope
		//Save this guest in all guests
		guests.set(id, guest);
		//Save all guests back into application scope
		getServletContext().setAttribute("guests", guests);
		response.sendRedirect("Guestbook");
	}*/

}