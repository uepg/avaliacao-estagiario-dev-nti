<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Vendas</title>
    </head>
    <body>
        <h1>Cadastro de Vendas</h1>
        <form action="/Algoritmo1/SvVenda" method="POST">
            Data: <br><input type="text" name="dataVenda" value=""/> <br>
            Id Produto: <br><input type="text" name="idProduto" value=""/> <br>
            Quantidade: <br><input type="text" name="qtdeVenda" value=""/> <br>
            Desconto: <br><input type="text" name="desconto" value=""/> <br>
            Total: <br><input type="text" name="totalVenda" value=""/> <br>
            Id Cliente <br><input type="text" name="idCliente" value=""/> <br>
            <input type="hidden" name="ACAO" value="INSERIR"/> <br>
           
            <input type="submit" value="Cadastrar" />
            
        </form>
        <br>
        <a href="index.html"> <button>Cancelar</button></a>
        
        <%
            String id = request.getParameter("ins");
            
            if (id != null)
                out.println("Venda cadastrada com sucesso! ID: "+id);
        %>
    </body>
</html