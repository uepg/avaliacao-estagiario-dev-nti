<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    </head>
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
            <h2 style="text-align: center; margin:20px 0">Cadastrar - Produtos</h2>
        </header>
        
        <fieldset style="width: 50vw; margin: auto" >
            <legend></legend>
        <form class="form-control bg-dark" data-bs-theme="dark" action="/SistemaComercial/SvProduto" method="POST">
            <label for="name">Nome:</label>
            <input class="form-control bg-light-subtle" type="text" name="name" id="name">
            </br>
            <label for="cpf">Valor:</label>
            <input class="form-control bg-light-subtle" type="number" name="valor" id="valor">
            <br>
            <input type="hidden" name="ACAO" value="INSERIR"/><br>
            <input class="btn btn-success" type="submit" value="confirmar" name="confirmar" />
        </form>
        </fieldset>
          <%
              String r = request.getParameter("r");
              if(r != null)
              out.println(r);
          %>
    </body>
</html>
