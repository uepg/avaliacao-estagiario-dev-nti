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
    String sign_name = "cliente_sign_in";
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


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar conta</title>
    </head>
    <body>
        <form method="POST" action="/SistemaComercial/SvCliente">
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
                <input type="text" name="senha"/>
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