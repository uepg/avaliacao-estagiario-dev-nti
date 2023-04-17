<%-- 
    Document   : pedidos
    Created on : 16 de abr. de 2023, 12:43:58
    Author     : mathe
--%>

<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    Boolean conectado = false;
    String user_id = "";
    
    cookies = request.getCookies();
    String sign_name = "cliente_sign_in";
    String sign_value = "true";
    
    for(int i = 0; i < cookies.length; ++i) {
        cookie = cookies[i];
        if(cookie.getName().equals(sign_name)) {
            conectado = true;
            user_id = cookie.getValue();
        }
    }
    
    if(!conectado) {
        response.sendRedirect("sign_in.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Cliente, model.Pedido, model.InfoPedido, java.util.List, java.util.ArrayList, java.text.DecimalFormat"%>
<jsp:useBean class="model.DAOCliente" id="d" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOPedido" id="pe" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOInfoPedido" id="ip" scope="page"></jsp:useBean>


<%
    DecimalFormat format = new DecimalFormat("R$#0.00");
%>

<!DOCTYPE html>

<style>
    * {
        font-family: system-ui;
        text-align: center;
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

<%
    if(conectado) {
        Cliente c = d.getById(user_id);
        ArrayList<Pedido> pedidos = pe.pesquisar("SELECT * FROM pedidos WHERE cod_cliente = "+c.getCod_cliente());
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meus pedidos</title>
    </head>
    <body>
        <div class="header">
            <span class="logo">Sistema Comercial</span>
            <div class="header-right">
                <a class="active" href="index.jsp">Home</a> 
                <a href="/SistemaComercial/cliente/sairCliente.jsp">Sair</a>
            </div>
        </div>

        <h1>Meus pedidos</h1>
        <%
            if(pedidos.size() > 0) {
        %>
        <table style="collapse: collapse; border: 1px black">
            <thead>
            <th>Id do pedido:</th>
            <th>Informação do pedido:</th>
            <th>Preço total:</th>
        </thead>
        <tbody>
            <%
                for(Pedido p : pedidos) {
                    out.println("<tr><td>" + p.getCod_pedido() + "</td>");
            %>
        <td>
            <%
                    ArrayList<InfoPedido> info_pedidos = ip.pesquisar("SELECT * FROM info_pedidos WHERE cod_pedido = "+ p.getCod_pedido());
                        
                    for(InfoPedido i : info_pedidos) {
                        out.print("<p>" + i.getNome() + " : " + i.getQuantidade_produto() + " ; " + format.format(i.getPreco_produto()) + " ; " + format.format(i.getPreco_total()) + "</p>");
                    }
            %>
        </td> 
        <%
                out.println("<td>" + format.format(p.getPreco()) + "</td></tr>");
            }
        %>
    </tbody>
</table>
    <%
        } else {
            out.println("Você não realizou nenhum pedido ainda.");
        }
    %>
</body>
</html>

<%
    };
%>