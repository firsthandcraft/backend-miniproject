package productController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

/**
 * Servlet implementation class ProductSearchController
 */
@WebServlet("/ProductSearchController")
public class ProductSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ProductService service = new ProductServiceImpl();
		//HttpSession session = request.getSession();
		String p_num= request.getParameter("p_num");
		Product p = service.findProduct(p_num);
		request.setAttribute("p",p);
	
		String path = "/product/productEdit.jsp";
		System.out.println("p :::ProductSearchController-: " +p);
		RequestDispatcher dispatcher= request.getRequestDispatcher(path);
		dispatcher.forward(request, response);	
	}

}
