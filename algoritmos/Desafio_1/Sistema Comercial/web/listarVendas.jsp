<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="model.*"%>

<jsp:useBean class="model.DAOProduto" id="d" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOVenda" id="vd" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOVenda_Produto" id="vp" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOCliente" id="dc" scope="page"></jsp:useBean>

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
                    <th>Cod_Venda</th>
                    <th>Data</th>
                    <th>Cliente</th>
                    <th>Produtos</th>
                    <th>Valor Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Venda> vendas = vd.pesquisar("SELECT * FROM venda");
                    for (Venda ve : vendas)
                    {
                    ArrayList<ProdutoVendido> produtos = vp.pesquisar("SELECT * FROM venda_produto WHERE cod_venda="+ve.getCod_venda());
                    String nome = dc.getById(Integer.toString(ve.getCliente())).getNome();
                %>
             
                <tr>
                    <td><%=ve.getCod_venda() %></td>
                    <td><%=ve.getData() %></td>
                    <td><%=nome%></td>
                    <td><ul>
                        <%
                        for(ProdutoVendido p : produtos){
                        %>
                            <li><%=p.getNome()%> <%=p.getQuantidade()%> </li>
                        <%
                             }
                        %>
                        </ul>
                    </td>
                    <td><%=ve.getValorTotal() %></td>
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
