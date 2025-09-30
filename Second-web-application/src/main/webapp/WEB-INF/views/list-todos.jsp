<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yahoo!!!!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
        <div class="container">
    <h1>Hi ${name} </h1> <br/>
    <table class="table table-striped">
        <caption>Your Todos are</caption>
        <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Completed</th>
                    <th></th>
                </tr>
        </thead>
        <tbody>
                <c:forEach items="${todos}" var="todo">
                            <tr>
                                <td>${todo.desc}</td>
                                <td>${todo.targetDate}</td>
                                <td>${todo.done}</td>
                                <td>
                                    <a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                                    <a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                </c:forEach>
        </tbody>
    </table>
    <div>
	<a class="btn btn-success" href="/add-todo">Add</a>
	</div>
</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>