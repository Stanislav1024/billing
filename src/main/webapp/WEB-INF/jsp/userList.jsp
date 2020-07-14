<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вас приветствует система ведения счетов пользователей!</title>
    <style>
        p {
            text-indent: 100px; /* Отступ первой строки в пикселах */
        }
    </style>
</head>
<body>

<div class="starter-template">
    <h1><p>Список пользователей со счетами</p></h1>
</div>

<div class="container">

    <table border="1" width="80%" align="center">

    <tr>
        <td><b>Фамилия</b></td>
        <td><b>Имя</b></td>
        <td><b>Отчество</b></td>
        <td><b>Дата рождения</b></td>
        <td><b>Счет</b></td>
        <td><b>Действия</b></td>
    </tr>

        <c:forEach items="${userBills}" var="user">
            <tr>
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td>${user.patronymicName}</td>
                <td>${user.birthdayString}</td>
                <td>${user.bill}</td>
                <td><a href="editbill/${user.id}">Изменить счет</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <h2><p><a href="adduser">Добавить нового пользователя</a></p></h2>

</div>
</body>
</html>
