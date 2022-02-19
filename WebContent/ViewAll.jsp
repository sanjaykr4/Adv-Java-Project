<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List, com.sanjay.Product" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product details</title>
</head>
<body style="background-image: url(Images/PageBackground.png)">

<p><a href="AdminWelcome.html"><img src="Images/HomeLogo.png" style="width:50px" title="Home"></a></p>
<center><h1>Displaying Product List</h1></center>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Product-Id</b></th>
          <th><b>Name</b></th>
          <th><b>Price</b></th>
          <th><b>Quantity</b></th>
          <th><b>Discount</b></th>
         </tr>
                         
             
             <%
                
             List<Product> prodlist=(List<Product>)request.getAttribute("prodlist");
             
             for(Product pdt:prodlist){
             %>
         
            <tr>
                
                <td><% out.println(pdt.getProductId()); %></td>
                <td><% out.println(pdt.getName()); %></td>
                <td><% out.println(pdt.getPrice()); %></td>
                <td><% out.println(pdt.getQuantity()); %></td>
                <td><% out.println(pdt.getDiscount()); %></td>
            </tr>
          <% } %>
          
        </table> 

</body>
</html>