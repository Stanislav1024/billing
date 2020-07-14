
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="starter-template">
    <h1><p>Редактирование счета пользователя</p></h1>
    <h2><p>Для начисления указывается положительное число, для списания - отрицательное</p></h2>
</div>

${user.surname}
${user.name}
${user.patronymicName};
Дата рождения: ${user.birthdayString};
Счет: ${user.bill}

<form  method = "POST" action = "/savebill">
    <table border = "0">

        <tr>
            <td> Начисление/Списание: </td>
            <td> <input type = "hidden" name = "id" value="${user.id}" size = "65"/></td>
            <td> <input type = "text" name = "change" size = "65"/></td>
        </tr>

        <tr>
            <td colspan = "2"><input type = "submit" value = "Изменить счет"/></td>
        </tr>

    </table>
</form>

</body>
</html>
