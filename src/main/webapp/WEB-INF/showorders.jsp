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
        Order List
    </jsp:attribute>
    <jsp:body>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Order ID</th>
                <th>User</th>
                <th>Cupcake type</th>
                <th>Total price</th>
                <th>Quantity</th>

            </tr>

                <c:forEach items="${requestScope.orderListView}" var="order">
            <tr>
                <td>${order.order_id}</td>
                    <td>${order.email}</td>
                <td>${order.cupcake_type}</td>
                <td>${order.total_price * order.quantity}</td>
                <td>${order.quantity}</td>


            </tr>
                </c:forEach>









            </tr>
            </thead>
        </table>
    </jsp:body>
</t:pagetemplate>