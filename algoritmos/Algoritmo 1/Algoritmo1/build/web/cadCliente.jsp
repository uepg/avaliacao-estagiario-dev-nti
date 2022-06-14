<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
    </head>
    <body>
        <h3>Cadastro de Clientes</h3>
        <form action="/Algoritmo1/SvCliente" method="POST">
            Nome: <br><input type="text" name="nomeCliente" value=""/> <br>
            <input type="hidden" name="ACAO" value="INSERIR"/> <br>
           
            <input type="submit" value="Cadastrar" />
            
        </form>
        <br>
        <a href="index.html"> <button>Cancelar</button></a>
        
        <%
            String id = request.getParameter("ins");
            
            if (id != null)
                out.println("Cliente inserido com sucesso! ID: "+id);
        %>
    </body>
</html>
