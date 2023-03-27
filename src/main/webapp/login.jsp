<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here</h3>
        <form action="login" method="post">

        <div class="row justify-content-center mx-auto">
            <div class="col-12">
                <label for="email">email: </label>
                <input type="text" id="email" name="email"/>
            </div>
            <div class="col-12">
                <label for="password">Password: </label>
                <input type="password" id="password" name="password"/>
            </div>
            <div class="col-12">
                <input type="submit" class="btn btn-primary mb-2"  value="Log in"/>

            </div>
        </div>
        </form>




        <div class="row">
            <div class="col-12">
                <a href="signup.jsp" class="btn btn-primary">Opret profil</a>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>