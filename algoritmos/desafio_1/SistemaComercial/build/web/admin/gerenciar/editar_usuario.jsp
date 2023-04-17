<%-- 
    Document   : editar_usuario
    Created on : 16 de abr. de 2023, 22:06:46
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
    
    String s_cod_cliente = request.getParameter("cod_cliente");
    
    if(!conectado || s_cod_cliente == null) {
        response.sendRedirect("/SistemaComercial/admin/sign_in.jsp");
    } else {
%>

<style>
    * {
        font-family: system-ui;
    }

    form {
        margin: auto;
        margin-top: 3rem;
        width: 20%;
        text-align: center;
        border: #777 1px solid;
        border-radius: 1rem;
        padding: 3rem;
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

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Cliente"%>
<jsp:useBean class="model.DAOCliente" id="d" scope="page"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Editar usuário</title>
        </head>
        <body>
            <div class="header">
                <span class="logo">Sistema Comercial</span>
                <div class="header-right">
                    <a class="active" href="/SistemaComercial/admin/index.jsp">Home</a> 
                    <a href="/SistemaComercial/admin/sairAdmin.jsp">Sair</a>
                </div>
            </div>
            <form method="POST" action="/SistemaComercial/SvCliente">
            <%
                Cliente c = d.getById(s_cod_cliente);
            %>
            <h1>Editar conta</h1>
            <div>
                <input type="hidden" name="ACAO" value="EDITAR">
                <input type="hidden" name="cod_cliente" value="<%=s_cod_cliente%>"/>
            </div>
            <div>
                <h3>Nome:</h3>
                <input type="text" name="nome" value="<%=c.getNome()%>"/>
            </div><br>
            <div>
                <h3>Email:</h3>
                <input type="text" name="email" value="<%=c.getEmail()%>"/>
            </div><br>
            <div>
                <h3>Cpf:</h3>
                <input type="text" name="cpf" value="<%=c.getCpf()%>"/>
            </div><br>
            <div>
                <h3>Telefone:</h3>
                <input type="text" name="telefone" value="<%=c.getTelefone()%>"/>
            </div><br>
            <div>
                <h3>Senha:</h3>
                <input type="password" name="senha" value="<%=c.getSenha()%>"/>
            </div><br>
            <div>
                <input type="submit" value="Atualizar usuário">
            </div><br>
        </form>
    </body>
</html>
<%
    };
%>