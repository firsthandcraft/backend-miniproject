package productController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.Product;
import service.MemberService;
import service.MemberServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

/**
 * Servlet implementation class AlbumDetailProductSearchContoller
 */
@WebServlet("/AlbumDetailProductSearchContoller")
public class AlbumDetailProductSearchContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumDetailProductSearchContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ProductService service = new ProductServiceImpl();
		MemberService serviceM= new MemberServiceImpl();
		//HttpSession session = request.getSession();
		Member m =serviceM.findMember(getServletInfo());
		
		
		String p_title= request.getParameter("p_title");
		Product p = service.findProduct(p_title);
		request.setAttribute("p",p);
		String path = "/AlbumList/AlbumDetail.jsp";
		System.out.println("p :AlbumDetailProductSearchContoller: " +p);
		RequestDispatcher dispatcher= request.getRequestDispatcher(path);
		dispatcher.forward(request, response);		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
