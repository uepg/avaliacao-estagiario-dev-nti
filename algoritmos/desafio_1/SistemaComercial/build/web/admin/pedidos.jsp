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
        response.sendRedirect("sign_in.jsp");
    } else {
%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Cliente, model.Produto, java.util.ArrayList, java.text.DecimalFormat"%>
<jsp:useBean class="model.DAOCliente" id="d" scope="page"></jsp:useBean>
<jsp:useBean class="model.DAOProduto" id="pr" scope="page"></jsp:useBean>

<%
    DecimalFormat format = new DecimalFormat("R$#0.00");
%>


<!DOCTYPE html>

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

<%
    ArrayList<Produto> produtos = pr.pesquisar("SELECT * FROM produtos");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar pedido</title>
    </head>
    <body>
        <div class="header">
            <span class="logo">Sistema Comercial</span>
            <div class="header-right">
                <a class="active" href="index.jsp">Home</a> 
                <a href="sairAdmin.jsp">Sair</a>
            </div>
        </div>

        <h1 style="text-align: center">Realizar pedidos</h1>

        <form method="POST" action="/SistemaComercial/admin/pedidos.jsp">
            <input type="hidden" name="PEDIDO_REALIZADO">
            <table style="collapse: collapse; border: 1px black">
                <thead>
                <th>Id do Produto:</th>
                <th>Nome do produto:</th>
                <th>Preço do produto:</th>
                <th>Quantidade:</th>
                <th>Preço individual:</th>
                </thead>
                <tbody>
                    <%
                        int produto_cont = 0;
                        
                        for(Produto p : produtos) {
                            out.println("<tr><td>" + p.getCod_produto() + "</td>");
                            out.println("<td>" + p.getNome() + "</td>");
                            out.println("<td>" + format.format(p.getPreco()) + "</td>");
                            out.println("<td>" + p.getQtd_estoque() + "</td>");
                    %>
                <td><input type="number"
                           name="produto_<%=p.getCod_produto()%>"
                           value="<%
                                String old_value = request.getParameter("produto_" + Integer.toString(p.getCod_produto()));
                                if(old_value == null) {
                                    out.print("0");
                                } else {
                                    out.print(old_value);
                                }
                           %>"></td>
                    <%
                            ++produto_cont;
                        }
                    %>
                <input type="hidden" name="qtd_elementos" value="<%=produto_cont%>">
                </tbody>
            </table>
            <br>
            Código do cliente: <input type="text" name="cod_cliente">
            <input type="submit" value="Calcular pedido" style="margin: 2rem">
        </form>

        <%
            String tem_pedido = request.getParameter("PEDIDO_REALIZADO");
            if(tem_pedido != null) {
                ArrayList<Cliente> cliente = d.pesquisar("SELECT * FROM clientes WHERE cod_cliente='" + request.getParameter("cod_cliente") + "'");
                    
                if(cliente.size() > 0) {

                double total = 0, preco = 0;
                String color = "";
                int qtd_elementos = Integer.parseInt(request.getParameter("qtd_elementos"));
                
                int cont = 0;
        %>

        <h3 style="text-align: center; padding-top: 3rem; padding-bottom: 1rem;">Carrinho:</h3>
        <form>
            <table>
                <thead>
                <th>Id do Produto:</th>
                <th>Nome do produto:</th>
                <th>Preço do produto:</th>
                <th>Quantidade:</th>
                <th>Preço individual:</th>
                </thead>
                <tbody>
                    <%
                    boolean tem = false;
                    for(Produto p : produtos) {
                        String aux = request.getParameter("produto_" + Integer.toString(p.getCod_produto()));

                        if(aux != null && Integer.parseInt(aux) > 0) {
                            int qtd = Integer.parseInt(aux);
                            tem = true;
                            
                            out.println("<tr><td>" + p.getCod_produto() + "</td>");
                            out.println("<td>" + p.getNome() + "</td>");
                            out.println("<td>" + format.format(p.getPreco()) + "</td>");
                            out.println("<td>" + qtd + "</td>");
                            
                            if(qtd > 30) {
                                preco = qtd * p.getPreco() * (1 - 0.2);
                                color = "red";
                            } else if(qtd > 20) {
                                preco = qtd * p.getPreco() * (1 - 0.1);
                                color = "green";
                            } else if(qtd > 10) {
                                preco = qtd * p.getPreco() * (1 - 0.05);
                                color = "blue";
                            } else {
                                preco = qtd * p.getPreco() * (1);
                                color = "black";
                            }
                            
                            out.println("<td style=\"color: " + color + "\">" + format.format(preco) + "</td>");
                            total += preco;
                        }
                    }
                    
                    if(!tem) {
                        out.println("<td colspan=\"5\" colrow=\"2\"><h2>Nenhum produto foi adicionado.</h2></td>");
                    }
                    %>
                </tbody>
            </table>
            <br>
            <h4 style="padding: 0px; margin: 0px; text-align: right;">Preto: 0% de desconto</h4>
            <h4 style="padding: 0px; margin: 0px; text-align: right;">Azul: 5% de desconto</h4>
            <h4 style="padding: 0px; margin: 0px; text-align: right;">Verde: 10% de desconto</h4>
            <h4 style="padding: 0px; margin: 0px; text-align: right;">Vermelho: 20% de desconto</h4>
            <br>
            <h2>Preço total: <span style="color: red"><%=format.format(total)%></span></h2>
        </form>
        <form method="POST" action="/SistemaComercial/SvPedido">
            <h2>Confirmar compra</h2>
            <input type="hidden" name="ACAO" value="FAZER_PEDIDO">
            <%
                for(Produto p : produtos) {

            %>
            <td><input type="hidden"
                       name="produto_<%=p.getCod_produto()%>"
                       value="<%
                            String old_value = request.getParameter("produto_" + Integer.toString(p.getCod_produto()));
                            if(old_value == null) {
                                out.print("0");
                            } else {
                                out.print(old_value);
                            }
                       %>"></td>
                <%
                    }
                %>
        </tbody>
    </table>
    <br>
    <input type="hidden" name="cod_cliente" value="<%=request.getParameter("cod_cliente")%>">
    <input type="submit" value="Confirmar" style="margin-bottom: 2rem">

</form>
<%
} else {
%>
<h3 style="text-align: center; padding-top: 2rem">Cliente não consta no sistema</h3>
<%
}
}
%>
</body>
</html>

<%
    };
%>