<%-- 
    Document   : criar_produto
    Created on : 16 de abr. de 2023, 22:07:46
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
    }

    form {
        margin: auto;
        width: 20%;
        text-align: center;
        border: #777 1px solid;
        border-radius: 1rem;
        margin-top: 3rem;
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

</style>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar produto</title>
    </head>
    <body>
        <div class="header">
            <span class="logo">Sistema Comercial</span>
            <div class="header-right">
                <a class="active" href="/SistemaComercial/admin/index.jsp">Home</a> 
                <a href="/SistemaComercial/admin/sairAdmin.jsp">Sair</a>
            </div>
        </div>
        <form method="POST" action="/SistemaComercial/SvProduto">
            <h1>Adicionar novo produto</h1>
            <div>
                <input type="hidden" name="ACAO" value="CRIAR">
            </div>
            <div>
                <h3>Nome do produto:</h3>
                <input type="text" name="nome"/>
            </div><br>
            <div>
                <h3>Preço do produto:</h3>
                <input type="text" name="preco"/>
            </div><br>
            <div>
                <h3>Quantidade em estoque:</h3>
                <input type="text" name="qtd_estoque"/>
            </div><br>
            <div>
                <input type="submit" value="Submit">
            </div><br>
        </form>
    </body>
</html>
<%
    };
%>