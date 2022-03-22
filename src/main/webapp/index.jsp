<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test project - Search form</title>
<script src="jquery/jquery-3.6.0.js" ></script>
<script src="jquery/basic.js" ></script>
<script src="jquery/logout.js" ></script>

<style>
table {
	border-collapse : collapse;
}
td, th {
	border : 1px solid;
}
th {
	font-weight : bold;
}
</style>

</head>

<body>

	<h1>Поиск</h1>
	<form id="searchPerson" method="post" name="searchPerson" >
	
	<input type="button" id="logout" name="logout" value="Выход">
	
	<h3> Пользователь: 
	
	
		<% 
			Object sessionUsernameAttribute = null;
			Object servletUsernameAttribute = null;
			
			if (session.getAttribute("username") != null) {
				sessionUsernameAttribute = session.getAttribute("username");	
			}
			ServletContext sc = request.getServletContext();
			if (sc.getAttribute("username") != null) {
				servletUsernameAttribute = sc.getAttribute("username");	
			}
		
			if (sessionUsernameAttribute != null) {
				out.println(sessionUsernameAttribute);
			} else if(servletUsernameAttribute != null) {
				out.println(servletUsernameAttribute);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("auth.jsp");
	            dispatcher.forward(request, response);
			}
		%> 
		
		
	</h3>
	
		<table >
		<tbody>
			<tr>
				<td>Фамилия</td>
				<td><input type="text" id="surname" name="surname" ></td>
			</tr>
			<tr>
				<td>Имя</td>
				<td><input type="text" id="name" name="name" ></td>
			</tr>
			<tr>
				<td>Отчество</td>
				<td><input type="text" id="patronymic" name="patronymic" ></td>
			</tr>
			<tr>
				<td>Город</td>
				<td><input type="text" id="city" name="city" ></td>
			</tr>
			<tr>
				<td>Рег. номер машины</td>
				<td><input type="text" id="car" name="car" ></td>
			</tr>
		</tbody>
	</table>
	<br>
	<input type="submit" id="submit" value="Поиск">
	
	<br>
	<br>
	
	<table>
	<thead>
		<tr>
			<td>Имя</td>
			<td>Отчество</td>
			<td>Фамилия</td>
			<td>Город</td>
			<td>Рег. номер машины</td>
		</tr>
	<thead>
	<tbody id="tableData"> </tbody>
	</table>
	
	</form>
	
	
</body>
</html>