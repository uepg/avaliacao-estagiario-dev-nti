<%-- 
    Document   : produtos
    Created on : 16 de abr. de 2023, 22:06:27
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
        background: #99F;
    }

</style>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Produto, java.util.ArrayList, java.text.DecimalFormat"%>
<jsp:useBean class="model.DAOProduto" id="pr" scope="page"></jsp:useBean>

<%
    DecimalFormat format = new DecimalFormat("R$#0.00");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar produtos</title>
    </head>
    <body>
        <div class="header">
            <span class="logo">Sistema Comercial</span>
            <div class="header-right">
                <a class="active" href="/SistemaComercial/admin/index.jsp">Home</a> 
                <a href="/SistemaComercial/admin/sairAdmin.jsp">Sair</a>
            </div>
        </div>

        <h2 style="text-align: center"><a href="criar_produto.jsp">Adicionar novo produto</a></h2>

        <h2 style="text-align: center">Produtos:</h2>
        <table>
            <thead>
            <th>Id produto</th>
            <th>Nome produto</th>
            <th>Preço produto</th>
            <th>Quantidade estoque</th>
            <th>Quantidade vendida</th>
            <th>Editar</th>
            <th>Remover</th>
        </thead>
        <%
            ArrayList<Produto> produtos = pr.pesquisar("SELECT * FROM produtos");
            
            for(Produto p : produtos) {
                out.println("<tr><td>" + p.getCod_produto() + "</td>");
                out.println("<td>" + p.getNome() + "</td>");
                out.println("<td>" + format.format(p.getPreco()) + "</td>");
                out.println("<td>" + p.getQtd_estoque() + "</td>");
                out.println("<td>" + p.getQtd_vendida() + "</td><td>");
        %>
        <form method="POST" action="/SistemaComercial/admin/gerenciar/editar_produto.jsp">
            <input type="hidden" name="ACAO" value="EDITAR">
            <input type="hidden" name="cod_produto" value="<%=p.getCod_produto()%>">
            <input type="submit" value="Editar">
        </form>
    </td><td>
        <form method="POST" action="/SistemaComercial/SvProduto">
            <input type="hidden" name="ACAO" value="EXCLUIR">
            <input type="hidden" name="cod_produto" value="<%=p.getCod_produto()%>">
            <input type="submit" value="Excluir">
        </form></td></tr>
        <%
        }
        %>
</table>
</body>
</html>
<%
    };
%>