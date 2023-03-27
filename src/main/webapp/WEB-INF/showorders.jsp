<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<%--
  Created by IntelliJ IDEA.
  User: tobiastonndorff
  Date: 22/03/2023
  Time: 09.31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:pagetemplate>
    <jsp:attribute name="header">
        Customer orders
    </jsp:attribute>
    <jsp:body>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Order ID</th>
                <th>User</th>
                <th>Order Items</th>
                <th>Total Price</th>

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


                </tr>
            </c:forEach>









            </tr>
            </thead>
        </table>
    </jsp:body>
</t:pagetemplate>