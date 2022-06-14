<%@page contentType="text/html" pageEncoding="UTF-8" import="modelo.Venda"%>

<jsp:useBean class="modelo.DAOVenda" id="dv" scope = "page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de Vendas </title>
    </head>
    
    <%
        Venda v = dv.getById(request.getParameter("id"));
    %>
    
    <body>
        <h3>Edição de Vendas</h3>
        <form action="/Algoritmo1/SvVenda" method="POST">
            Data: <br> <input type="text" name="dataVenda" value="<%=v.getDataVenda() %>"/> <br>
            Id Produto: <br> <input type="text" name="idProduto" value="<%=v.getIdProduto() %>"/> <br>
            Quantidade: <br> <input type="text" name="qtdeVenda" value="<%=v.getQtdeVenda() %>"/> <br>
            Desconto: <br> <input type="text" name="desconto" value="<%=v.getDesconto() %>"/> <br>
            Total: <br> <input type="text" name="totalVenda" value="<%=v.getTotalVenda() %>"/> <br>
            Id Cliente <br> <input type="text" name="idCliente" value="<%=v.getIdCliente() %>"/> <br>

            <input type="hidden" name="cod" value="<%=v.getIdVenda() %>"/> <br>
            <input type="hidden" name="ACAO" value="ALTERAR"/>
           
            <input type="submit" value="Alterar" />
            <a href="index.html"> <button>Cancelar</button></a>
        </form>
    </body>
</html>
