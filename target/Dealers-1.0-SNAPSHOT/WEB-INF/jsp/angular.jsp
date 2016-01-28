<%-- 
    Document   : angular
    Created on : Aug 19, 2015, 9:03:08 AM
    Author     : Amira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a class="btn btn-success" href="<c:url value='/admin/dealers' />"><i class="icon_check_alt2"></i></a>
    </body>
</html>
