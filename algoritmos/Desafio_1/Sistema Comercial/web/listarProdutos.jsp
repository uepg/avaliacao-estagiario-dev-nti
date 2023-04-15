<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>

<jsp:useBean class="model.DAOProduto" id="d" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Listagem de Produtos</title>
    </head>
    <body>
        <header style="display: flex; justify-content: space-between; ">
            <h2>Listagem - Produtos</h2>
            <a class="btn btn-primary" style="display: flex; align-items: center" href="/SistemaComercial">Voltar</a>
        </header>
        
        <table class="table table-striped" border="1">
            <thead>
                <tr>
                    <th>NOME</th>
                    <th>Valor</th>
                    <th>AÇÕES</th>
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
                    
                    <td><a class="btn btn-danger" href="/SistemaComercial/SvProduto?ACAO=EXCLUIR&id=<%=p.getCod_produto()%>"><ion-icon name="trash-outline"></ion-icon>Deletar</a>
                    <a class="btn btn-info" href="alterarProduto.jsp?id=<%=p.getCod_produto()%>"><ion-icon name="pencil-outline"></ion-icon>Alterar</a></td>
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
