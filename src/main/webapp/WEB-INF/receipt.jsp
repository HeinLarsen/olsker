<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Kvittering:
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <c:forEach items="${requestScope.shoppingcart.getOrder().getOrderItems()}" var="item">
                <div class="col-7">
                    ${item.getBottom().getName()} med ${item.getTop().getName()} ${item.getQuantity()} stk. ${item.getTotalPrice()}kr,-
                        <hr>
                </div>
            </c:forEach>
            <div class="col-7">
                ${requestScope.shoppingcart.getTotalPrice()}kr,-
            </div>

        </div>
    </jsp:body>

</t:pagetemplate>