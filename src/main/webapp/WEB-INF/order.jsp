<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Betaling
    </jsp:attribute>

    <jsp:body>
        <div class="row justify-content-center">
            <div class="col-9">
                <div class="row">
                    <div class="col-12">
                        <b>balance:</b>  ${sessionScope.user.balance}
                    </div>
                    <div class="col-12">
                        <form action="updatebalance" method="post">
                        <input class="form-control d-inline w-25" type="number" name="balance" value="${sessionScope.user.balance}">
                        <button class="btn btn-primary align-top">
                            Indsæt penge
                        </button>
                        </form>
                    </div>
                </div>
            </div>
            <t:cart type="post" btnText="Betal" url="order" showPaymentBtn="true" prop="${sessionScope.shoppingcart}" title="Kurv"/>
        </div>





    </jsp:body>

</t:pagetemplate>