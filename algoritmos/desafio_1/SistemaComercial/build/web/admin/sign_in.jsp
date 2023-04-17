<%-- 
    Document   : sign_in
    Created on : 16 de abr. de 2023, 09:56:24
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signin Admin</title>
    </head>
    <body>

        <form method="POST" action="/SistemaComercial/SvAdmin">
            <h1>Página de Login</h1>
            <div>
                <input type="hidden" name="ACAO" value="SIGN_IN">
            </div>
            <div>
                <h3>Email:</h3>
                <input type="text" name="email"/>
            </div><br>
            <div>
                <h3>Senha:</h3>
                <input type="password" name="senha"/>
            </div><br>
            <div>
                <input type="submit" value="Submit">
            </div><br>
        </form>

        <a style="text-align: right;" href="sign_up.jsp">Não possuo uma conta</a><br><br>
    </body>
</html>

<%
    };
%>