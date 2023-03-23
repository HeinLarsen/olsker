<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         User balance
    </jsp:attribute>

    <jsp:body>
        <div class="row">
        <form>
            <div class="col-lg-4 col-12">
                <input type="hidden" value="${requestScope.user.id}" name="id">
                <input type="number" name="balance" value="${requestScope.user.balance}" class="form-control">
            </div>
            <div class="col-auto col-12">
                    <button class="btn btn-success" formaction="balance" formmethod="post">Opdater</button>
                </div>
            </form>
        </div>

    </jsp:body>

</t:pagetemplate>