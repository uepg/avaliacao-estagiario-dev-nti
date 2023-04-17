<%-- 
    Document   : sign_up
    Created on : 16 de abr. de 2023, 10:48:24
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
    
    if(conectado) {
        response.sendRedirect("index.jsp");
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

</style>

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


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar conta</title>
    </head>
    <body>
        <div class="header">
            <span class="logo">Sistema Comercial</span>
            <div class="header-right">
                <a class="active" href="index.jsp">Home</a> 
                <a href="/SistemaComercial/">Sair</a>
            </div>
        </div>
        <form method="POST" action="/SistemaComercial/SvAdmin">
            <%
                String compare = "true";
                String aux = request.getParameter("empty");
                
                if(compare.equals(aux)) {
                    out.print("<h3 style=\"color: red; padding-top: 1rem\">Preencha todos os campos.</h3>");
                }
            %>
            <h1>Criar conta</h1>
            <div>
                <input type="hidden" name="ACAO" value="SIGN_UP">
            </div>
            <div>
                <h3>Nome:</h3>
                <input type="text" name="nome"/>
            </div><br>
            <div>
                <h3>Email:</h3>
                <input type="text" name="email"/>
            </div><br>
            <div>
                <h3>Cpf:</h3>
                <input type="text" name="cpf"/>
            </div><br>
            <div>
                <h3>Telefone:</h3>
                <input type="text" name="telefone"/>
            </div><br>
            <div>
                <h3>Senha:</h3>
                <input type="password" name="senha"/>
            </div><br>
            <div>
                <input type="submit" value="Submit">
            </div><br>
        </form>
        <a style="text-align: right;" href="sign_in.jsp">Já possuo uma conta</a><br><br>
    </body>
</html>

<%
    };
%>