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
    <body>
        <header style="display: flex; justify-content: space-between; ">
            <h2>Vender</h2>
            <a class="btn btn-primary" style="display: flex; align-items: center" href="/SistemaComercial">Voltar</a>
        </header>
        <form class="form-control" action="/SistemaComercial/SvVenda" method="POST">
            <label for="cpf">CPF do Cliente:</label>
            <input class="form-control" type="text" name="cpf" id="cpf">
        <table class="table table-striped" border="1">
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
