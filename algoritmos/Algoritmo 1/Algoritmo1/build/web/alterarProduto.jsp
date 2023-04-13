<%@page contentType="text/html" pageEncoding="UTF-8" import="modelo.Produto"%>

<jsp:useBean class="modelo.DAOProduto" id="dp" scope = "page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de Produtos</title>
    </head>
    
    <%
        Produto p = dp.getById(request.getParameter("id"));
    %>
    
    <body>
        <h3>Edição de Produtos</h3>
        <form action="/Algoritmo1/SvProduto" method="POST">
            Nome : <br> <input type="text" name="nomeProduto" value="<%=p.getNomeProduto() %>"/> <br>
            Quantidade : <br> <input type="text" name="qtdeProduto" value="<%=p.getQtdeProduto() %>"/> <br>
            Valor unitario : <br> <input type="text" name="valorProduto" value="<%=p.getValorProduto() %>"/> <br>

            <input type="hidden" name="cod" value="<%=p.getIdProduto() %>"/> <br>
            <input type="hidden" name="ACAO" value="ALTERAR"/>
           
            <input type="submit" value="Alterar" />
            <a href="index.html"> <button>Cancelar</button></a>
        </form>
    </body>
</html>