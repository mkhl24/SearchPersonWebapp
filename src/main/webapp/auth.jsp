<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test project - Auth form</title>

<script src="jquery/jquery-3.6.0.js" ></script>
<script src="jquery/auth.js" ></script>

</head>
<body>

<h1>Авторизация в сервисе</h1>

<form id="authForm" method="post" name="authForm" >

<table>
	<tbody>
		<tr>
			<td>Логин</td>
			<td><input type="text" id="username" name="username"></td>
		</tr>
		<tr>
			<td>Пароль</td>
			<td><input type="password" id="password" name="password"></td>
		</tr>	
		<tr>
			<td><input type="checkbox" id="rememberUser" name ="rememberUser"> Запомнить </td>
			<td><input type="submit" id="authSubmit" value="Войти"></td>
		</tr>
	</tbody>
</table>

<br>
<div id="message"></div>
</form>
</body>
</html>