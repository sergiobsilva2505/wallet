
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista de transações</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>
    <div class="container">
        <form action="<c:url value="/transacoes" />" method="POST">
            <div class="form-group">
                <label for="ticker">Ticker</label>
                <input class="form-control" id="ticker" name="ticker"/>
            </div>
            <div class="form-group">
                <label for="data">Data</label>
                <input class="form-control" id="data" name="data"/>
            </div>
            <div class="form-group">
                <label for="preco">Preço</label>
                <input class="form-control" id="preco" name="preco"/>
            </div>
            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input class="form-control" id="quantidade" name="quantidade"/>
            </div>
            <div class="form-group">
                <label for="tipo">Tipo</label>
                <input class="form-control" id="tipo" name="tipo"/>
            </div>
            <input type="submit" value="Gravar" class="mt-2 btn-primary">
        </form>

        <h1 class="text-center">Lista de transações:</h1>
        <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr class="bg-primary">
                    <th>TICKER</th>
                    <th>DATA</th>
                    <th>PRECO</th>
                    <th>QUANTIDADE</th>
                    <th>TIPO</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${ transacoes }" var="transacao">
                <tr>
                    <td>${ transacao.ticker }</td>
                    <td>${ transacao.data }</td>
                    <td>${ transacao.preco }</td>
                    <td>${ transacao.quantidade }</td>
                    <td>${ transacao.tipoTransacao }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
