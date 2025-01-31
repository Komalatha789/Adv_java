<%@page import="com.sathya.servlet.ProductDao" import="java.util.Base64"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Product List</title>
<!--  BootStrap CDN Link to Get the Support of BootStrap -->
	<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></link> 
</head>

<body>
      <div class="text-center text-success">
	   <h1 class="text-success text-center"> List of Available Products..</h1>
	</div>
	<div>
  <a  href="Addproduct.html" class="btn btn-success">SavaProduct
  </a>
  </div>
   <div>
	   <input type="text" placeholder="search">
	</div>

   <div>
     <c:if test="${saveResult==1 }">
     <h1 class="text-danger text-centre">Data inserted successfully....</h1>
     </c:if>
   </div>
   
   <div>
     <c:if test="${deleteResult==1 }">
     <h1 class="text-danger text-centre">Data deleted successfully....</h1>
     </c:if>
   </div>
   <div>
     <c:if test="${deleteResult==0 }">
     <h1 class="text-danger text-centre">Data deleted fail check once....</h1>
     </c:if>
   </div>
	<table class="table table-bordered table-striped">
	<thead class="thead-dark">
	<tr>
		<th>Product proId</th>
		<th>Product proName</th>
		<th>Product proPrice</th>
		<th>Product proBrand</th>
		<th>Product proMadeIn</th>
		<th>Product proMfgDate</th>
		<th>Product proExpDate</th>
		<th>Product proImage</th>
		
		<th> Actions </th>	
		</tr>
</thead>
<tbody>
	<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
	<tr>
	<td>${product.proId}</td> 
	<td>${product.proName}</td> 
	<td>${product.proPrice}</td> 
	<td>${product.proBrand}</td> 	
	<td>${product.proMadeIn}</td> 
	<td>${product.proMfgDate}</td> 
	<td>${product.proExpDate}</td>
	<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}"alt="Product image" style="max-width: 100px; max-height:100px;"> </td>
	
	<td><audio controls style="width: 200px;"><source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"></audio></td>

<td><video width="160" height="120" controls><source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}"></video></td>
<td>
	<a class="btn btn-primary" href ="./DeleteProductServlet?proId=${product.proId}">Delete</a>
	<a class="btn btn-primary" href ="./EditProductServlet?proId=${product.proId}">Edit</a>
	</td>
	</tr>
	</c:forEach>
</tbody>
	</table>
</body>
</html>