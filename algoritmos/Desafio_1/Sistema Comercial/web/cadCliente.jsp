<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    </head>
    <body>
        <header style="display: flex; justify-content: space-between; ">
            <h2>Cadastrar - Clientes</h2>
            <a class="btn btn-primary" style="display: flex; align-items: center" href="/SistemaComercial">Voltar</a>
        </header>
        
        <fieldset style="width: 50vw; margin: auto" >
            <legend></legend>
        <form class="form-control" action="/SistemaComercial/SvCliente" method="POST">
            <label for="name">Nome:</label>
            <input class="form-control" type="text" name="name" id="name">
            </br>
            <label for="cpf">CPF:</label>
            <input class="form-control" type="text" name="cpf" id="cpf">
            </br>
            <label for="email">Email:</label>
            <input class="form-control" type="text" name="email" id="email">
            </br>
            <label for="celular">Telefone:</label>
            <input class="form-control" type="text" name="celular" id="tel">
            </br>
            <input type="hidden" name="ACAO" value="INSERIR"/><br>
            <input class="btn btn-success" type="submit" value="confirmar" name="confirmar" />
        </form>
        </fieldset>
          <%
              String r = request.getParameter("r");
              if(r != null)
              out.println(r);
          %>
    </body>
</html>
