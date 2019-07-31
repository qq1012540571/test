<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <script src="js/select.js">
    </script>
    <script src="js/getUrlParam.js">
    </script>
    <body>

        <table id="messages" border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Specialties</th>
                <th>Presentation</th>
                <th>Operation</th>
            </tr>

            <c:forEach var="msg" items="${requestScope.messageList}">
                <tr>
                    <td>${msg[0]}</td>
                    <td>${msg[1]}</td>
                    <td>${msg[2]}</td>
                    <td>${msg[3]}</td>
                    <td><a href="Edit?id=${msg[4]}" >Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="GuestEdit.jsp">Add Candidate</a>
    </body>
</html>