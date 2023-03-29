<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:body>
        <div class="row justify-content-center">
            <t:cart title="Kvittering" type="get" btnText="Til forsiden" url="index" showPaymentBtn="true" prop="${requestScope.shoppingcart}"/>
        </div>
    </jsp:body>
</t:pagetemplate>