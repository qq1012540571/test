<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script src="js/index.js">
</script>
</head>
<body>
    
        <table id="messages1" border="1">
        
            <tr>
                <th>ID</th>
                <th><input type="text" id="userid" disabled="disabled"></th>
            </tr>
            
            <tr>
                <th>Name</th>
                <th><input type="text" id="name"></th>

            </tr>
            
            <tr>
                <th>Specialties</th>
                <th><input type="text" id="specialties"></th>
            </tr>
            
            <tr>
                <th>Presentation</th>
                <th><input type="text" id="presentation"></th>
            </tr>
        </table>
        <input type="button" id="commit" value='Save' onclick="add()">
        
</body>
</html>