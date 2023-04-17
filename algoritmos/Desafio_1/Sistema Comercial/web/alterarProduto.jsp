

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Produto" %>
<jsp:useBean class="model.DAOProduto" id="d" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto - Alterar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <%
        Produto p = d.getById(request.getParameter("id"));
    %>
    
    <body style="background-color: white">
       <header >
            <nav class="navbar navbar-expand-lg bg-black bg-gradient border" data-bs-theme="dark">
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link" href="cadCliente.jsp">Cadastrar Cliente</a>
                        <a class="nav-link" href="listarClientes.jsp">Listar Clientes</a>
                        <a class="nav-link" href="cadProduto.jsp">Cadastrar Produto</a>
                        <a class="nav-link" href="listarProdutos.jsp">Listar Produtos</a>
                        <a class="nav-link" href="vender.jsp">Vender</a>
                        <a class="nav-link" href="listarVendas.jsp">Listar Vendas</a>
                    </div>
                </div>
            </nav>
            <h2 style="text-align: center; margin:20px 0">Alerar - Produto</h2>
        </header>
        
        <fieldset style="width: 50vw; margin: auto" >
            <legend></legend>
        <form class="form-control" data-bs-theme="dark" action="/SistemaComercial/SvProduto" method="POST">
            <label for="nome">Nome:</label>
            <input class="form-control bg-light-subtle" type="text" name="nome" id="nome" value="<%=p.getNome()%>">
            </br>
            <label for="cpf">Valor:</label>
            <input class="form-control bg-light-subtle" type="number" name="valor" id="valor" value="<%=p.getValor_unidade()%>">
            </br>
            
            <input type="hidden" name="ACAO" value="ALTERAR"/><br>
            <input type="hidden" name="cod" value="<%=p.getCod_produto()%>"/><br>
            
            <input class="btn btn-success" type="submit" value="alterar" name="alterar" />
        </form>
        </fieldset>
        
    </body>
</html>
