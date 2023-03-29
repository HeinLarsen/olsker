<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Users
    </jsp:attribute>

  <jsp:body>

    <table class="table table-striped table-bordered">
        <tr>
            <th>id</th>
            <th>Email</th>
            <th>Rolle</th>
            <th>Balance</th>
            <th>Handlinger</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
                <td>${user.balance}</td>
                <td>
                    <a href="balance?id=${user.id}" value="${user.id}" class="btn btn-primary">Opdater balance</a>
                    <a href="showallorderitemsbyorderid?id=${user.id}" value="${user.id}" class="btn btn-primary">Se alle brugerens ordrer</a>
                </td>
            </tr>
        </c:forEach>

    </table>


  </jsp:body>

</t:pagetemplate>