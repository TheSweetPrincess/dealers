<%-- 
    Document   : dealers
    Created on : Aug 19, 2015, 10:22:22 AM
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
        <title>Dealers</title>
    </head>
    <body>
        <h1>Hello Dealers</h1>
        <!-- Form add daily note -->              
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading">
                        Add dealer
                    </header>
                    <div class="panel-body">
                        <div class="form">
                            <c:url var="addAction" value="/admin/dealer/add" ></c:url>
                            <form:form action="${addAction}" commandName="dealer" class="form-validate form-horizontal " id="register_form">
                                <c:if test="${!empty dealer.name}">
                                    <div class="form-group " >
                                        <form:label class="control-label col-lg-2" path="id">
                                            <spring:message text="ID"/><span class="required">*</span>
                                        </form:label>     
                                        <div class="col-lg-10">                                          
                                            <form:input  class=" form-control" path="id" readonly="true" size="8"  disabled="true" />
                                            <form:hidden path="id" />
                                        </div>
                                    </div>
                                </c:if> 

                                <div class="form-group ">
                                    <form:label path="dealer" class="control-label col-lg-2">
                                        <spring:message text="Name"/><span class="required">*</span>
                                    </form:label>
                                    <div class="col-lg-10">
                                        <form:input path="dealer" class="form-control" />
                                        <c:if test="${!empty error}"><span style="color: red;">${error}</span></c:if>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-2" for="countrySelect">Country<span class="required">*</span></label>
                                        <div class="col-lg-10">
                                        <form:select path="countryName" class="form-control m-bot15" id="countrySelect">
                                            <option value=""> Choose Country...</option>
                                            <c:if test="${!empty countryList}">
                                                <c:forEach items="${countryList}" var="country">
                                                    <c:choose>
                                                        <c:when test="${country.countryName}==${dailyNote.countryName}">
                                                            <option value="${country.countryName}" selected>${country.countryName}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:option value="${country.countryName}">${country.countryName}</form:option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </c:if>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <c:if test="${!empty dealer.name}">
                                            <button class="btn btn-primary" type="submit"><spring:message text="Update"/></button>
                                        </c:if>
                                        <c:if test="${empty dealer.name}">
                                            <button class="btn btn-primary" type="submit"><spring:message text="Save"/></button>
                                        </c:if>
                                        <button class="btn btn-default" type="reset">Cancel</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>

        <!-- table --> 
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading">
                        Dealers
                    </header>
                    <c:if test="${!empty listDealers}">
                        <table class="table table-striped table-advance table-hover">
                            <tbody>
                                <tr>
                                    <th><i class="icon_profile"></i> Dealer ID</th>
                                    <th><i class="icon_profile"></i> Dealer Name</th>
                                    <th><i class="icon_profile"></i> Dealer Email</th>
                                    <th><i class="icon_profile"></i> Dealer Phone</th>
                                    <th><i class="icon_profile"></i> Dealer Address</th>
                                    <th><i class="icon_profile"></i> Dealer Website</th>
                                    <th><i class="icon_cogs"></i> Action</th>
                                </tr>
                                <c:forEach items="${listDailyNotes}" var="note">
                                    <tr>
                                        <td>${dealer.id}</td>
                                        <td>${dealer.name}</td>
                                        <td>${dealer.email}</td>
                                        <td>${dealer.phone}</td>
                                        <td>${dealer.address}</td>
                                        <td>${dealer.website}</td>
                                        <td>
                                            <div class="btn-group">
                                                <a class="btn btn-success" href="<c:url value='/admin/editDailyNote/${note.id}' />"><i class="icon_check_alt2"></i></a>
                                                <a class="btn btn-danger" href="<c:url value='/admin/removeDailyNote/${note.id}' />"><i class="icon_close_alt2"></i></a>
                                            </div>
                                        </td>
                                    </tr> 
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </section>
            </div>
        </div>
    </body>
</html>
