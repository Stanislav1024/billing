
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({
                dateFormat: "dd.mm.yy"
            });
        } );
    </script>
</head>
<body>

<div class="starter-template">
    <h1><p>Добавление нового пользователя</p></h1>
</div>

<form  method = "POST" action = "saveuser" modelAttribute = "UserBillDTO">
    <table border = "0">

        <tr>
            <td> Фамилия: </td>
            <td> <input type = "text" name = "surname" size = "65"/></td>
        </tr>

        <tr>
            <td> Имя: </td>
            <td> <input type = "text" name = "name" size = "65"/></td>
        </tr>

        <tr>
            <td> Отчество: </td>
            <td> <input type = "text" name = "patronymicName" size = "65"/></td>
        </tr>

        <tr>
            <td> Дата рождения: </td>
            <td> <input type = "text" id="datepicker" name = "birthday" size = "65" data-date-format="dd MM yyyy"/></td>
        </tr>

        <tr>
            <td> Счет: </td>
            <td> <input type = "text" name = "bill" size = "65"/></td>
        </tr>

        <tr>
            <td colspan = "2"><input type = "submit" value = "Сохранить"/></td>
        </tr>
    </table>
</form>

</body>
</html>
