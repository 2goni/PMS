package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GroupcodeDAOImpl;
import model.GroupcodeVO;
import model.ProductDAOImpl;
import model.ProductVO;

@WebServlet("*.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("utf-8");

		if(action.equals("main.do")) {
			// 다른 페이지로 전송 main.jsp
			response.sendRedirect("main.html");
		}else if(action.equals("product_input.do")){
			//1.그룹이름 읽어오기(DB)
			GroupcodeDAOImpl gcodedao = new GroupcodeDAOImpl();
			List<GroupcodeVO> list = null;
			try {
				list = gcodedao.readList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//2.그룹이름 전송하면서
			//3.페이지 열기
			//dispatcher 방식으로 페이지를 열기
			RequestDispatcher dispatcher = request.getRequestDispatcher("product_input.jsp");
			request.setAttribute("list", list);
			dispatcher.forward(request, response);
		}else if(action.equals("pdbinput.do")) {
			// 1. 저장할 데이터 셋팅(vo)
			ProductVO vo = new ProductVO();
			vo.setCode(request.getParameter("code"));
			vo.setPname(request.getParameter("pname"));
			vo.setCost(Integer.parseInt(request.getParameter("cost")));
			vo.setPnum(Integer.parseInt(request.getParameter("pnum")));
			vo.setInum(Integer.parseInt(request.getParameter("inum")));
			vo.setSale(Integer.parseInt(request.getParameter("sale")));
			vo.setGcode(request.getParameter("gcode"));
			
			//2. 데이터 저장
			ProductDAOImpl dao = new ProductDAOImpl();
			try {
				dao.create(vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//3. 페이지 이동
			response.sendRedirect("product_input.do");
		}else if(action.equals("product_output.do")) {
			GroupcodeDAOImpl gcodedao = new GroupcodeDAOImpl();
			List<GroupcodeVO> list = null;
			try {
				list = gcodedao.readList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//2.그룹이름 전송하면서
			//3.페이지 열기
			//dispatcher 방식으로 페이지를 열기
			RequestDispatcher dispatcher = request.getRequestDispatcher("product_output.jsp");
			request.setAttribute("list", list);
			dispatcher.forward(request, response);
		}else if(action.equals("search.do")) {
			ProductVO vo = new ProductVO();
			vo.setCode(request.getParameter("code"));
			System.out.println(vo.getPname());
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
