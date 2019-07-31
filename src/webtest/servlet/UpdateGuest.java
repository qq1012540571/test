package webtest.servlet;

import com.alibaba.fastjson.JSON;
import webtest.dao.GuestBookDao;
import webtest.model.GuestBookEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@WebServlet(urlPatterns = "/UpdateGuest", loadOnStartup = 1)
public class UpdateGuest extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public UpdateGuest()
	{
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{   Map<String,Object> map=new HashMap<>();
	    String id=request.getParameter("userid");
		String name = request.getParameter("name");
		String specialties = request.getParameter("specialties");
		String presentation = request.getParameter("presentation");
		GuestBookEntry guestBookEntry=new GuestBookEntry();
		guestBookEntry.setName(name);
		guestBookEntry.setPresentation(presentation);
		guestBookEntry.setSpecialties(specialties);
		guestBookEntry.setId(Long.valueOf(id));
		GuestBookDao guestBookDao=new GuestBookDao();
		int i=guestBookDao.update(guestBookEntry);
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
