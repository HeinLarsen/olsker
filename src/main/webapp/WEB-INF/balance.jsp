<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Bruger balance
    </jsp:attribute>

    <jsp:body>
        <div class="row justify-content-center">
            <h3>Transactions</h3>
        <div class="col-lg-12 col-12">
            <table class="table" style="width:100%">
                <thead>
                <Tr>
                    <th width="500">Balance</th>
                    <th>Dato(timestamp?)</th>

                </Tr>
                </thead>
                <tbody>
                <tr>
                <td>${requestScope.user.balance}kr</td>
                    <td>${requestScope.user.email }</td>
                </tr>
                </tbody>
            </table>
            <form>
                <br/>

            <div class="col-lg-4 col-12">
                <input type="hidden" value="${requestScope.user.balance}" name="currentBalance">
                <input type="hidden" value="${requestScope.user.id}" name="id">
                <input type="number" name="amount" class="form-control" placeholder="Beløb">

            </div>
                <br/>
            <div class="col-auto col-12">
                    <button class="btn btn-success" formaction="balance" formmethod="post">Tilføj Balance</button>
                <button class="btn btn-danger" formaction="removebalance" formmethod="post">Fjern Balance</button>
                </div>
            </form>
        </div>
        </div>

    </jsp:body>

</t:pagetemplate>