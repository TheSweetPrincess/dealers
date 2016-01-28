<%-- 
    Document   : ExceptionPage
    Created on : Aug 19, 2015, 11:04:35 AM
    Author     : Amira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="img/favicon.png">
        <title>Spring MVC Exception Handling</title>
    </head>

    <body>
        <div class="page-404">
            <h2>Spring MVC Exception Handling</h2>
               <c:if test="${!empty message}">
                <h2> <b>Message :</b> <span>${message}</span></h2>
            </c:if>
            <p>Something went wrong or that page doesn?t exist yet. <br><a href="${pageContext.request.contextPath}/login">Return Home</a></p>  
            <c:if test="${!empty url}">
                <p> <b>Page URL:</b> <span>${url}</span></p>
            </c:if>

            <c:if test="${!empty timestamp}">
                <p> <b>Occurred at Timestamp:</b> <span>${timestamp}</span></p>
            </c:if>

            <c:if test="${!empty status}">
                <p><b>Response Status:</b> <span>${status} status-code</span></p>
            </c:if>
            <c:if test="${!empty error}">
                <p><b>Error:</b> <span>${error}</span></p>
            </c:if>
            <c:if test="${!empty exception.stackTrace}">
                <c:forEach items="${exception.stackTrace}" var="Strace">
                    <p> <span>${Strace}</span></p>
                </c:forEach>
                <p> <b>Error:</b> <span>${error}</span></p>
            </c:if>

        </div>

    </body>
</html>
