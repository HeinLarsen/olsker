<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        <div class="loginHeader">
            Login
        </div>
    </jsp:attribute>

    <jsp:body>


        <form class="grid_form" action="login" method="post">
            <label for="email">Email:</label>
            <label for="password">Password:</label>

            <input class="m_right" type="text" id="email" name="email"/>
            <input class="m_right" type="password" id="password" name="password"/>
        </form>

        <div class="login">
            <input type="submit" class="btn btn-primary mb-2" value="Log in"/>
        </div>


        <div class="signup">
            <a href="signup.jsp" class="btn btn-primary">Opret profil</a>
        </div>

    </jsp:body>
</t:pagetemplate>