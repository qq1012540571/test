package webtest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import webtest.dao.GuestBookDao;
import webtest.model.GuestBookEntry;

@WebServlet(urlPatterns = "/Guestbook", loadOnStartup = 1)
public class Guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<GuestBookEntry> guests;

	public Guestbook() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		}

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GuestBookDao guestBookDao=new GuestBookDao();
		List<GuestBookEntry> list=guestBookDao.select();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String a= JSON.toJSONString(list);
		out.write(a);
        }
}