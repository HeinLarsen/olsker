<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Sign up
    </jsp:attribute>

    <jsp:body>

        <form class="grid_form" action="signup" method="post">
            <label for="email">email: </label>
            <label for="password">Password: </label>
            <input class="m_right" type="text" id="email" name="email"/>
            <input class= "m_right" type="password" id="password" name="password"/>
            <button type="submit" class="btn btn-success item5">Opret</button>
        </form>



    </jsp:body>

</t:pagetemplate>