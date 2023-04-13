<%@page contentType="text/html" pageEncoding="UTF-8" import="modelo.Cliente"%>

<jsp:useBean class="modelo.DAOCliente" id="dc" scope = "page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de Clientes</title>
    </head>
    
    <%
        Cliente c = dc.getById(request.getParameter("id"));
    %>
    
    <body>
        <h3>Edição de Clientes</h3>
        <form action="/Algoritmo1/SvCliente" method="POST">
            Nome : <br> <input type="text" name="nomeCliente" value="<%=c.getNomeCliente() %>"/> <br>

            <input type="hidden" name="cod" value="<%=c.getIdCliente() %>"/> <br>
            <input type="hidden" name="ACAO" value="ALTERAR"/>
           
            <input type="submit" value="Alterar" />
            <a href="index.html"> <button>Cancelar</button></a>
        </form>
    </body>
</html>
