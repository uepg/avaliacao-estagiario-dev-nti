<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <h3>Cadastro de Produtos</h3>
        <form action="/Algoritmo1/SvProduto" method="POST">
            Nome: <br><input type="text" name="nomeProduto" value=""/> <br>
            Quantidade a adicionar: <br><input type="text" name="qtdeProduto" value=""/> <br>
            Valor unitário: <br><input type="text" name="valorProduto" value=""/> <br>

            <input type="hidden" name="ACAO" value="INSERIR"/> <br>
           
            <input type="submit" value="Cadastrar" />
            
        </form>
        <br>
        <a href="index.html"> <button>Cancelar</button></a>
        
        <%
            String id = request.getParameter("ins");
            
            if (id != null)
                out.println("Produto inserido com sucesso! ID: "+id);
        %>
    </body>
</html>
