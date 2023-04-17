<%-- 
    Document   : usuarios
    Created on : 16 de abr. de 2023, 22:06:35
    Author     : mathe
--%>

<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    Boolean conectado = false;
    String user_id = "";
    
    cookies = request.getCookies();
    String sign_name = "admin_sign_in";
    String sign_value = "true";
    
    for(int i = 0; i < cookies.length; ++i) {
        cookie = cookies[i];
        if(cookie.getName().equals(sign_name)) {
            conectado = true;
            user_id = cookie.getValue();
        }
    }
    
    if(!conectado) {
        response.sendRedirect("/SistemaComercial/admin/sign_in.jsp");
    } else {
%>

<style>
    * {
        font-family: system-ui;
        font-weight: bold;
    }

    form {
        margin: auto;
        width: 40%;
        text-align: center;
        border: #777 1px solid;
    }

    h3 {
        margin: 0px;
    }

    a:link, a:hover, a:active, a:visited {
        text-decoration: none;
        color: blue;
    }

    .header {
        overflow: hidden;
        background-color: #f1f1f1;
        margin: auto;
        padding: 20px;
    }

    .header span, .header a {
        float: left;
        color: black;
        text-align: center;
        padding: 12px;
        text-decoration: none;
        font-size: 18px;
        line-height: 25px;
        border-radius: 4px;
        font-size: 25px;
        font-weight: bold;
    }

    .header a {
        margin-left: 1rem;
    }

    .header a:hover {
        background-color: #d1d1d1;
    }

    .header-right {
        float: right;
    }

    table, thead, tbody, th, tr, td {
        border: 1px black solid;
        border-collapse: collapse;
    }

    td, th {
        padding: 1rem 0.5rem 1rem 0.5rem;
    }

    td, th, tr {
        width: 20%;
    }

    tbody tr:nth-child(odd) {
        background: #9A9;
    }

</style>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Cliente, java.util.ArrayList"%>
<jsp:useBean class="model.DAOCliente" id="d" scope="page"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Gerenciar usuários</title>
        </head>
        <body>
            <div class="header">
                <span class="logo">Sistema Comercial</span>
                <div class="header-right">
                    <a class="active" href="/SistemaComercial/admin/index.jsp">Home</a> 
                    <a href="/SistemaComercial/admin/sairAdmin.jsp">Sair</a>
                </div>
            </div>
            
            <h2 style="text-align: center">Produtos:</h2>
        
            <table>
                <thead>
                <th>id usuário</th>
                <th>nome</th>
                <th>email</th>
                <th>telefone</th>
                <th>cpf</th>
                <th>senha</th>
                <th>editar</th>
                <th>excluir</th>
            </thead>
            <tbody>
            <%
                ArrayList<Cliente> c = d.pesquisar("SELECT * FROM clientes");
            
                for(Cliente cliente : c) {
                    out.print("<tr><td>" + cliente.getCod_cliente() + "</td>");
                    out.print("<td>" + cliente.getNome() + "</td>");
                    out.print("<td>" + cliente.getEmail() + "</td>");
                    out.print("<td>" + cliente.getTelefone() + "</td>");
                    out.print("<td>" + cliente.getCpf() + "</td>");
                    out.print("<td>" + cliente.getSenha() + "</td><td>");
            %>
        <form method="POST" action="/SistemaComercial/admin/gerenciar/editar_usuario.jsp">
            <input type="hidden" name="ACAO" value="EDITAR">
            <input type="hidden" name="cod_cliente" value="<%=cliente.getCod_cliente()%>">
            <input type="submit" value="Editar">
        </form>
    </td><td>
        <form method="POST" action="/SistemaComercial/SvCliente">
            <input type="hidden" name="ACAO" value="EXCLUIR">
            <input type="hidden" name="cod_cliente" value="<%=cliente.getCod_cliente()%>">
            <input type="submit" value="Excluir">
        </form>
        <%
            out.print("</td></tr>");
        }
        %>
        </tbody>
</table>
</body>
</html>
<%
    };
%>