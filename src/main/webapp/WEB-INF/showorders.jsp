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
                <th>User ID</th>
                <th>Order Items</th>

            </tr>

                <c:forEach items="${requestScope.orderList}" var="order">
            <tr>
                <td>
                    ${order.id}
                </td>
                    <td>
                        ${order.user_id}
                    </td>
                    <td>
                        <c:forEach items="${order.orderItemsList}" var="items">
                            <p>${items.cupcake_bottom_id} ${items.cupcake_top_id} ${items.cupcake_bottom_price} ${items.cupcake_top_price}
                            ${items.quantity} </p>
                        </c:forEach>
                    </td>


            </tr>
                </c:forEach>









            </tr>
            </thead>
        </table>
    </jsp:body>
</t:pagetemplate>