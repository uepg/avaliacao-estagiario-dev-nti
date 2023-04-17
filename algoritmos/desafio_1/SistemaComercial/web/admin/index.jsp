<%-- 
    Document   : index
    Created on : 16 de abr. de 2023, 09:50:50
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
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Admin"%>
<jsp:useBean class="model.DAOAdmin" id="d" scope="page"></jsp:useBean>

<%
    if(conectado) {
        Admin c = d.getById(user_id);
%>

<style>
    * {
        font-family: system-ui;
        text-align: center;
    }

    form {
        margin: auto;
        width: 20%;
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

</style>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial - Admin</title>
    </head>
    <body>
        <div class="header">
            <span class="logo">Sistema Comercial</span>
            <div class="header-right">
                <a class="active" href="index.jsp">Home</a> 
                <a href="sairAdmin.jsp">Sair</a>
            </div>
        </div>

        <h1>Bem vindo <%=c.getNome()%>.</h1>

        <h2><a href="pedidos.jsp">Anotar pedidos</a></h2>
        <h2><a href="gerenciar/produtos.jsp">Gerenciar produtos</a></h2>
        <h2><a href="gerenciar/usuarios.jsp">Gerenciar usuários</a></h2>
    </body>
</html>

<%
    };  
%>