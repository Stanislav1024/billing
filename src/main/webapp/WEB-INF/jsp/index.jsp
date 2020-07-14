<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <!-- Подключаем bootstrap CSS,
        Spring boot автоматически замапит ресурс благодаря зависимости webjars в pom.xml -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="//css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

    <style>
        p {
            text-indent: 400px; /* Отступ первой строки в пикселах */
        }
    </style>
</head>
<body>

<div class="starter-template">
    <h1><p>Вас приветствует система ведения счетов пользователей!</p></h1>
</div>
<br/>
<h2><p><a href="users">Список пользователей со счетами</a></p></h2>
<br/>
<h2><p><a href="adduser">Добавить нового пользователя</a></p></h2>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
