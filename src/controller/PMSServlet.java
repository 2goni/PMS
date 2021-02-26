package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PMSDAO;
import model.PMSDAOImpl;
import model.PMSDTO;

/**
 * Servlet implementation class PMSServlet
 */
@WebServlet("/PMS")
public class PMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PMSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PMSDAO db = new PMSDAOImpl();
		PMSDTO vo = new PMSDTO();
		vo.setCode(request.getParameter("code"));
		vo.setPname(request.getParameter("pname"));
		vo.setCost(Integer.parseInt(request.getParameter("cost")));
		vo.setPnum(Integer.parseInt(request.getParameter("pnum")));
		vo.setInum(Integer.parseInt(request.getParameter("inum")));
		vo.setSale(Integer.parseInt(request.getParameter("sale")));
		vo.setGcode(request.getParameter("gcode"));
		if(request.getParameter("create") != null);
		try {
			db.create(vo);
		} catch (SQLException e) {
			System.out.println("등록 오류");
		}
	}

}
