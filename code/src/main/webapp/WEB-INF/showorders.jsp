<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:pagetemplate>
    <jsp:attribute name="header">
        Bruger ordre oversigt
    </jsp:attribute>
    <jsp:body>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Ordre ID</th>
                <th>Bruger</th>
                <th>Order Linjer</th>
                <th>Total Pris</th>
                <th>Handlinger</th>

            </tr>
            <c:forEach items="${requestScope.orderList}" var="order">
                <tr>
                    <td>
                        <p>${order.getId()}</p>
                    </td>
                    <td>
                        <p>${order.getUser().getEmail()}</p>
                    </td>
                    <td>
                        <c:forEach items="${order.getOrderItems()}" var="items">
                            <p>${items.getBottom().getName()} ${items.getBottom().getPrice()}kr,- ${items.getTop().getName()}  ${items.getTop().getPrice()},- x${items.getQuantity()}  </p>
                        </c:forEach>

                    </td>
                    <td>
                        <p>${order.totalPrice}kr,-</p>
                    </td>
                    <td>
                        <form>
                            <input type="hidden" name="id" value="${order.id}">
                            <button class="btn btn-danger" formaction="deleteorder" formmethod="post">Slet ordre</button>
                        </form>
                    </td>

                </tr>
            </c:forEach>

            </tr>
            </thead>
        </table>
    </jsp:body>
</t:pagetemplate>