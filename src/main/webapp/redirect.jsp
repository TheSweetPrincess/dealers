<%-- 
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.

    Document   : redirect
    Created on : Aug 19, 2015, 8:58:56 AM
    Author     : Amira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("admin/dealers"); %>