

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.All_DB;
import model.Product;

/**
 * Servlet implementation class List_products
 */
@WebServlet("/List_products")
public class List_products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List_products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String list_of_products = "";
		if(All_DB.select_all_products() != null){
			
			for(Product pro:All_DB.select_all_products()){

				list_of_products+= "<nav class=\"navbar navbar-default col-sm-10\">" +
						 " <p class=\"navbar-text navbar-default col-sm-offset-10\" ><b>Product Name: </b>"+ pro.getName() + "</p>" +
						"<ul class=\"nav nav-pills nav-right col-sm-offset-9\">" + "<p class=\"navbar-text navbar-default\"><b>Price: </b>" +  pro.getPrice() +
						"</a> <b> Qty: " + pro.getQuantity() +  "</b></p>";
						
				list_of_products+= "<li role=\"presentation\" class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-plus\">View</a></li>" + "<li role=\"presentation\" class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-plus\">Add</a></li>" +
						"</ul> </nav>" ;
			}
			
			request.setAttribute("products", list_of_products);
			 getServletContext().getRequestDispatcher("/Product_List.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
