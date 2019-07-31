package webtest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alibaba.fastjson.JSON;
import webtest.dao.GuestBookDao;
import webtest.model.GuestBookEntry;

@SuppressWarnings("unused")
@WebServlet(urlPatterns = "/AddGuest", loadOnStartup = 1)
public class AddGuest extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public AddGuest()
	{
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{   Map<String,Object> map=new HashMap<>();
		String name = request.getParameter("name");
		String specialties = request.getParameter("specialties");
		String presentation = request.getParameter("presentation");
		GuestBookEntry guestBookEntry=new GuestBookEntry();
		guestBookEntry.setName(name);
		guestBookEntry.setPresentation(presentation);
		guestBookEntry.setSpecialties(specialties);
		GuestBookDao guestBookDao=new GuestBookDao();
		int i=guestBookDao.add(guestBookEntry);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(i>0)
		{
		   map.put("success", true);
		}
		else
		{
			map.put("success", false);
		}
		map.put("guestBookEntry",guestBookEntry);
		String a=JSON.toJSONString(map);
		out.write(a);
		
	}
}
