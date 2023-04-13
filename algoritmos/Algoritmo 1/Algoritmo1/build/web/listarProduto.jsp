<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="modelo.Produto" %>

<jsp:useBean class="modelo.DAOProduto" id="dp" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body>
        <h2>Produtos</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Excluir</th>
                <th>Alterar</th> 
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Valor unitário</th>
            </tr>
            </thead>
            <tbody>
                
            <%
                    ArrayList<Produto> pp = dp.pesquisar("SELECT * FROM produto");
                    
                    for(Produto p : pp){
            %>
            
                        <tr> 
                            <td> <a href="/Algoritmo1/SvProduto?ACAO=EXCLUIR&id=<%=p.getIdProduto()%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;X&nbsp;&nbsp;&nbsp;&nbsp; </a> </td>
                            <td> <a href="alterarProduto.jsp?id=<%=p.getIdProduto()%>"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E&nbsp;&nbsp;&nbsp;&nbsp; </a> </td>
                            <td> <%=p.getNomeProduto() %> </td>
                            <td> <%=p.getQtdeProduto() %> </td>
                            <td> <%=p.getValorProduto() %> </td>
                        </tr>
                <% 
                    }
                %>
            
            </tbody>
        </table>
        </table>
        <br>
        <a href="cadProduto.jsp"> <button>Cadastrar Novo</button></a> 
        <a href="index.html"> <button>Voltar</button></a>
    </body>
</html>
