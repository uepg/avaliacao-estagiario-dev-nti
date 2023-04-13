<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="modelo.Venda" %>

<jsp:useBean class="modelo.DAOVenda" id="dv" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Vendas</title>
    </head>
    <body>
        <h2>Vendas</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Excluir</th>
                <th>Alterar</th> 
                <th>Data</th>
                <th>Id Produto</th>
                <th>Quantidade</th>
                <th>Desconto</th>
                <th>Total</th>
                <th>Id Cliente</th>
            </tr>
            </thead>
            <tbody>
                
            <%
                    ArrayList<Venda> vv = dv.pesquisar("SELECT * FROM venda");
                    
                    for(Venda v : vv){
            %>
            
                        <tr> 
                            <td> <a href="/Algoritmo1/SvVenda?ACAO=EXCLUIR&id=<%=v.getIdVenda()%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;X&nbsp;&nbsp;&nbsp;&nbsp; </a> </td>
                            <td> <a href="alterarVenda.jsp?id=<%=v.getIdVenda()%>"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E&nbsp;&nbsp;&nbsp;&nbsp; </a> </td>
                            <td> <%=v.getDataVenda() %> </td>
                            <td> <%=v.getIdProduto() %> </td>
                            <td> <%=v.getQtdeVenda() %> </td>
                            <td> <%=v.getDesconto() %> </td>
                            <td> <%=v.getTotalVenda() %> </td>
                            <td> <%=v.getIdCliente() %> </td>
                        </tr>
                <% 
                    }
                %>
            
            </tbody>
        </table>
        </table>
        <br>
        <a href="cadVenda.jsp"> <button>Cadastrar Nova</button></a> 
        <a href="index.html"> <button>Voltar</button></a>
    </body>
</html>