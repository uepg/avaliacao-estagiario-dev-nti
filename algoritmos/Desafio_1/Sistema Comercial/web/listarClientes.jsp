<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>

<jsp:useBean class="model.DAOCliente" id="d" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Listagem de Clientes</title>
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
            <h2 style="text-align: center; margin:20px 0">Listar - Clientes</h2>
        </header>
        
        <table class="table table-dark table-striped" style="max-width: 80vw; margin: auto; " border="1">
            <thead>
                <tr>
                    <th>NOME</th>
                    <th>EMAIL</th>
                    <th>CPF</th>
                    <th>TELEFONE</th>
                    <th>AÇÕES</th>
                </tr>
            </thead>
            <tbody>
                <%

                    ArrayList<Cliente> ac = d.pesquisar("SELECT * FROM cliente");
                    
                    for (Cliente c : ac)
                    {
                %>
             
                <tr>
                    <td><%=c.getNome() %></td>
                    <td><%=c.getEmail() %></td>
                    <td><%=c.getCpf() %></td>
                    <td><%=c.getCelular() %></td>
                    
                    <td><a class="btn btn-danger" href="/SistemaComercial/SvCliente?ACAO=EXCLUIR&id=<%=c.getCod_cliente()%>"><ion-icon name="trash-outline"></ion-icon>Deletar</a>
                    <a class="btn btn-info" href="alterarCliente.jsp?id=<%=c.getCod_cliente()%>"><ion-icon name="pencil-outline"></ion-icon>Alterar</a></td>
                </tr>
                   
                <%
                    }
                %>
            </tbody>
        </table>
        
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>            
    </body>
</html>
