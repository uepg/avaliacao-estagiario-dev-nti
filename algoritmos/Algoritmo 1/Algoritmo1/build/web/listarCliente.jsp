<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="modelo.Cliente" %>

<jsp:useBean class="modelo.DAOCliente" id="dc" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
        <h2>Clientes</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Excluir</th>
                <th>Alterar</th> 
                <th>Nome</th>
            </tr>
            </thead>
            <tbody>
                
            <%
                    ArrayList<Cliente> cc = dc.pesquisar("SELECT * FROM cliente");
                    
                    for(Cliente c : cc){
            %>
            
                        <tr> 
                            <td> <a href="/Algoritmo1/SvCliente?ACAO=EXCLUIR&id=<%=c.getIdCliente()%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;X&nbsp;&nbsp;&nbsp;&nbsp; </a> </td>
                            <td> <a href="alterarCliente.jsp?id=<%=c.getIdCliente()%>"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E&nbsp;&nbsp;&nbsp;&nbsp; </a> </td>
                            <td> <%=c.getNomeCliente() %> </td>
                        </tr>
                <% 
                    }
                %>
            
            </tbody>
        </table>
        </table>
        <br>
        <a href="cadCliente.jsp"> <button>Cadastrar Novo</button></a> 
        <a href="index.html"> <button>Voltar</button></a>
    </body>
</html>
