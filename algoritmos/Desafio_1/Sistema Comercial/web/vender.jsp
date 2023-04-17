<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>

<jsp:useBean class="model.DAOProduto" id="d" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOVenda" id="v" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Listagem de Produtos</title>
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
            <h2 style="text-align: center; margin:20px 0">Vender</h2>
        </header>
        
        <form class="form-control" data-bs-theme="dark" style="max-width: 80vw; margin: auto; " action="/SistemaComercial/SvVenda" method="POST">
            <label for="cpf">CPF do Cliente:</label>
            <input class="form-control" type="text" name="cpf" id="cpf">
        <table class="table table-dark table-striped" " border="1">
            <thead>
                <tr>
                    <th>NOME</th>
                    <th>Valor</th>
                    <th>Quantidade</th>
                </tr>
            </thead>
            <tbody>
                <%

                    ArrayList<Produto> ap = d.pesquisar("SELECT * FROM produto");
                    
                    for (Produto p : ap)
                    {
                %>
             
                <tr>
                    <td><%=p.getNome() %></td>
                    <td><%=p.getValor_unidade() %></td>
                    
                    <td>
                        <input type="number" id="quantidade" name="<%=p.getCod_produto()%>" min="0" max="100" step="1" value="0">
                    </td>
                </tr>
                   
                <%
                    }
                %>
            </tbody>
        </table>
                <input type="hidden" name="ACAO" value="INSERIR"/><br>
                <input class="btn btn-success" type="submit" value="confirmar" name="confirmar" />
            </form>
     
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>            
    </body>
</html>
