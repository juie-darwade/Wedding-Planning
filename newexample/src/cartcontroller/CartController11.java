package cartcontroller;

import shoppingcart.CartBean;
import shoppingcart.CartItemBean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartController1
 */
public class CartController11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			 
			  String strAction = request.getParameter("action");
			   
			   
			  if(strAction!=null && !strAction.equals("")) {
			   if(strAction.equals("add")) {
			    addToCart(request);
			   } else if (strAction.equals("Update")) {
			    updateCart(request);
			   } else if (strAction.equals("Delete")) {
			    deleteCart(request);
			   }
			  }
			  response.sendRedirect("../ShoppingCart.jsp");
			 }
			  
			 protected void deleteCart(HttpServletRequest request) {
			  HttpSession session = request.getSession();
			  String strItemIndex = request.getParameter("itemIndex");
			  CartBean cartBean = null;
			   
			  Object objCartBean = session.getAttribute("cart");
			  if(objCartBean!=null) {
			   cartBean = (CartBean) objCartBean ;
			  } else {
			   cartBean = new CartBean();
			  }
			  cartBean.deleteCartItem(strItemIndex);
			 }
			  
			 protected void updateCart(HttpServletRequest request) {
			  HttpSession session = request.getSession();
			  String strQuantity = request.getParameter("quantity");
			  String strItemIndex = request.getParameter("itemIndex");
			  
			  CartBean cartBean = null;
			   
			  Object objCartBean = session.getAttribute("cart");
			  if(objCartBean!=null) {
			   cartBean = (CartBean) objCartBean ;
			  } else {
			   cartBean = new CartBean();
			  }
			  cartBean.updateCartItem(strItemIndex, strQuantity);
			 }
			  
			 protected void addToCart(HttpServletRequest request) {
			  HttpSession session = request.getSession();
			  String strModelNo = request.getParameter("modelNo");
			  String strDescription = request.getParameter("description");
			  String strPrice = request.getParameter("price");
			  String strQuantity = request.getParameter("quantity");
			   
			  CartBean cartBean = null;
			   
			  Object objCartBean = session.getAttribute("cart");
			 
			  if(objCartBean!=null) {
			   cartBean = (CartBean) objCartBean ;
			  } else {
			   cartBean = new CartBean();
			   session.setAttribute("cart", cartBean);
			  }
			   
			  cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
			 }
			 
			}



