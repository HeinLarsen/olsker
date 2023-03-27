<%@tag description="Cart" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="showPaymentBtn" type="java.lang.String" required="false" %>
<%@ attribute name="title" type="java.lang.String" required="true"  %>
<%@ attribute name="prop" type="dat.backend.model.entities.ShoppingCart" required="true" %>
<%@ attribute name="type" type="java.lang.String" required="false" %>
<%@ attribute name="url" type="java.lang.String" required="false" %>
<%@ attribute name="btnText" type="java.lang.String" required="false" %>

<div class="col-lg-3 col-12">
    <div class="row cart">
        <div class="col-12 text-center">
            <h2 class="cart-heading mb-0 mt-1">${title}</h2>
            <hr class="mt-0 mb-0">
        </div>
        <span class="items">
                    <c:forEach items="${prop.order.orderItems}" var="item">
                        <div class="col-12 cart-item">
                            <p class="mb-0">${item.top.name} ${item.quantity} stk. ${item.totalPrice} kr,- </p>
                            <i>med ${item.bottom.name}</i>
                        </div>
                    </c:forEach>
                        </span>
        <div class="col-12 mt-2 text-center">
            <hr class="mb-1 mt-0">
            <b class="mb-0">Total: ${prop.totalPrice} kr,-</b>
        </div>
        <c:if test="${showPaymentBtn == 'true'}">
        <div class="col-12 text-center">
            <form action="${url}" method="${type}">
                <c:choose>
                    <c:when test="${url == 'order' && type == 'post'}">
                        <c:if test="${sessionScope.user.balance >= prop.totalPrice}">
                            <button class="btn mb-1 btn-primary w-75" type="submit">${btnText}</button>
                        </c:if>
                        <c:if test="${sessionScope.user.balance < prop.totalPrice}">
                            <button class="btn mb-1 btn-danger w-75" type="submit" disabled>Du har ikke nok penge på din konto</button>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <button class="btn mb-1 btn-primary w-75" type="submit">${btnText}</button>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
        </c:if>

    </div>
</div>
