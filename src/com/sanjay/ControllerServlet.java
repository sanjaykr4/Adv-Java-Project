package com.sanjay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/AddProduct")) {
			addProduct(request, response);
		} else if (action.equals("/SearchProduct")) {
			searchProduct(request, response);
		} else if (action.equals("/RemoveProduct")) {
			removeProduct(request, response);
		} else if (action.equals("/EditProduct")) {
			editProduct(request, response);
		}
		else if (action.equals("/ViewAll")) {
			viewAll(request, response);
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		 if (action.equals("/ViewAll")) {
			viewAll(request, response);
		}
	}
	
	private void viewAll(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ProductDao pdao = new ProductDao();
		List<Product> prodlist = pdao.viewAll();

		
		request.setAttribute("prodlist", prodlist);
		request.getRequestDispatcher("ViewAll.jsp").forward(request, response);

	}

	private void editProduct(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int ProductId = Integer.parseInt(request.getParameter("ProductId"));
		int UpdatedQuantity = Integer.parseInt(request.getParameter("UpdatedQuantity"));

		ProductDao pdao = new ProductDao();

		boolean prod = pdao.editProduct(ProductId, UpdatedQuantity);

		try {
			if (prod) {
				out.println("Record Updated");
				request.getRequestDispatcher("EditProduct.html").include(request, response);
			} else {
				out.println("Record not Updated, Please Enter Valid Id");
				request.getRequestDispatcher("EditProduct.html").include(request, response);
			}
		} catch (Exception e) {

		}

	}

	private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int ProductId = Integer.parseInt(request.getParameter("ProductId"));
		ProductDao pdao = new ProductDao();

		boolean prod = pdao.removeProduct(ProductId);

		try {
			if (prod) {
				out.println("Record Deleted");
				request.getRequestDispatcher("RemoveProduct.html").include(request, response);
			} else {
				out.println("Record not Deleted, Please Enter Valid Id");
				request.getRequestDispatcher("RemoveProduct.html").include(request, response);
			}
		} catch (Exception e) {
		}

	}

	private void searchProduct(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int ProductId = Integer.parseInt(request.getParameter("ProductId"));
		ProductDao pdao = new ProductDao();

		Product prod = (Product) pdao.searchProduct(ProductId);

		request.setAttribute("Prob", prod);
		request.getRequestDispatcher("SearchProduct.jsp").forward(request, response);

	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int ProductId = Integer.parseInt(request.getParameter("ProductId"));
		String Name = request.getParameter("Name");
		int Price = Integer.parseInt(request.getParameter("Price"));
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		int Discount = Integer.parseInt(request.getParameter("Discount"));

		Product p = new Product(ProductId, Name, Price, Quantity, Discount);
		ProductDao pdao = new ProductDao();

		try {

			boolean result = pdao.insertProduct(p);
			if (result != false) {
				out.println("Product Added Successfully");
				request.getRequestDispatcher("AddProduct.html").include(request, response);
			}

		} catch (Exception e) {
		}

	}

}
