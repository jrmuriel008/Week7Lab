<%-- 
    Document   : users
    Created on : 19-Oct-2022, 1:28:51 PM
    Author     : user
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Database</title>
    </head>
    <body>
        <div class ="manage">
            <h1>Manage Users</h1>
            <table>
                <tr>
                    <td>Email</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Role</td>
                </tr>


                <c:forEach var ="user" items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>

                        <c:if test="${user.role eq 1}"><td>System Admin</td></c:if>
                        <c:if test="${user.role eq 2}"><td>Regular User</td></c:if>

                        <form method="POST" action="user">
                            <input type="hidden" name="newEmail" value="${user.email}">
                        <input type="hidden" name="newFirst" value="${user.firstName}">
                        <input type="hidden" name="newLast" value="${user.lastName}">
                        <input type="hidden" name="newPass" value="${user.password}">
                        <input type="hidden" name="newRole" value="${user.role}">
                        <td><input type="submit" value="Edit" >
                            <input type="hidden" name="action" value="edit"></td>
                    </form>
                    
                    <form method="POST" action="user">
                        <input type="hidden" name="deleteEmail" value="${user.email}">
                        <td><input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete"></td>
                    </form>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class ="add">
            <h1>Add User</h1>
            <form method = "POST" action="user">
                Email: <input type = "text" name="addEmail"/><br>
                First Name: <input type = "text" name ="addFirst"/><br>
                Last Name: <input type ="text" name ="addLast"/><br>
                Password: <input type="text" name ="addPass"/><br>
                Role: <select name="addRole">
                    <option value ="1">System Admin</option>
                    <option value ="2">Regular User</option>
                </select><br> 
                <input type ="submit" value ="Add user">
                <input type ="hidden" name="action" value ="add">
            </form>
        </div>

        <div class ="edit">
            <h1>Edit User</h1>
            <form method = "POST" action="user">
                Email: <input type = "text" name="editEmail" value="${editEmail}"/><br>
                First Name: <input type = "text" name ="editFirst" value="${editFirst}"/><br>
                Last Name: <input type ="text" name ="editLast" value="${editLast}"/><br>
                Password: <input type="text" name ="editPass" value="${editPass}"/><br>
                Role: <select name="editRole" value="${editRole}">
                    <option value ="1">System Admin</option>
                    <option value ="2">Regular User</option>
                </select><br> 
                <input type ="submit" value ="Update">
                <input type ="hidden" name="action" value ="update">
                <input type ="submit" value ="Cancel">
                <input type ="hidden" name="action" value ="cancel">
            </form>
        </div>


    </body>
</html>
