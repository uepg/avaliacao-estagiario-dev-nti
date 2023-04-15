
<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Cliente" %>
<jsp:useBean class="model.DAOCliente" id="d" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente - Alterar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <%
        Cliente c = d.getById(request.getParameter("id"));
    %>
    
    <body>
       <header style="display: flex; justify-content: space-between; ">
            <h2>Alterar - Clientes</h2>
            <a class="btn btn-primary" style="display: flex; align-items: center" href="/SistemaComercial">Voltar</a>
        </header>
        
        <fieldset style="width: 50vw; margin: auto" >
            <legend></legend>
        <form class="form-control" action="/SistemaComercial/SvCliente" method="POST">
            <label for="nome">Nome:</label>
            <input class="form-control" type="text" name="nome" id="nome" value="<%=c.getNome()%>">
            </br>
            <label for="cpf">CPF:</label>
            <input class="form-control" type="text" name="cpf" id="cpf" value="<%=c.getCpf()%>">
            </br>
            <label for="email">Email:</label>
            <input class="form-control" type="text" name="email" id="email" value="<%=c.getEmail()%>">
            </br>
            <label for="celular">Celular:</label>
            <input class="form-control" type="text" name="celular" id="tel" value="<%=c.getCelular()%>">
            </br>
            
            <input type="hidden" name="ACAO" value="ALTERAR"/><br>
            <input type="hidden" name="cod" value="<%=c.getCod_cliente()%>"/><br>
            
            <input class="btn btn-success" type="submit" value="alterar" name="alterar" />
        </form>
        </fieldset>
        
    </body>
</html>
