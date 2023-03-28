<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Sign up
    </jsp:attribute>

    <jsp:body>


        <form action="signup" method="post">
            <div class="row justify-content-center mt-5">
                <div class="email col-2">
                    <label for="email">Email: </label>
                    <input class="m_right" type="text" id="email" name="email"/>
                </div>
                <div class="password col-2">
                    <label for="password">Password: </label>
                    <input class="m_right" type="password" id="password" name="password"/>
                </div>
                <div class="signup col-8">
                    <button type="submit" class="btn btn-success">Opret</button>
                </div>
            </div>
        </form>


    </jsp:body>

</t:pagetemplate>