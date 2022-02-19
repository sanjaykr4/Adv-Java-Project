<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page  import  ="com.sanjay.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Product</title>
</head>
<body style="background-image: url(Images/PageBackground.png)">
<style>
    #Head
    {
        text-align: center;
    }
    form
    {
        border: solid;
        margin: auto;
        padding: auto;
        display: block;
        height: 200px;
        width: 900px;
    }  
     label{ padding: 1cm;  }
  
  #12{padding: 1cm;
  }
 </style>

<p><a href="AdminWelcome.html"><img src="Images/HomeLogo.png" style="width:50px" title="Home"></a></p>

<form action="SearchProduct" method="Post">
<h1 id="Head">Search Product</h1>
<hr><br>
<label> <b>Search Product </b></label> <br> <br>
<label>Product ID</label>
<input type="Number" Name="ProductId"> 

<input type="submit" value="Search"> <br>
</form>

<%
try{
Product p=(Product)request.getAttribute("Prob");
out.println( p.getProductId()+ " " + p.getName()+" " + p.getPrice() + " " +p.getQuantity() + " " +p.getDiscount());
}catch(Exception e){}
%>
</body>
</html>