<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>@yield('title')</title>

        <!-- FONTES DO GOOGLE-->
        <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Kanit" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Inter" rel="stylesheet">

        <!-- CSS BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">

        <!--CSS DA APLICAÇÃO-->
        <link rel="stylesheet" href="/css/styles.css">
        <script src="/js/scripts.js"></script>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class ="collapse navbar-collapse" id="navbar">
                    <a href="/" class="navbar-brand">
                        <!--<img src="/img/logo.jpg" alt="Logo">-->
                        <h1>NTIPRODUCTS</h1>
                    </a>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a href="/" class="nav-link">Home</a>
                        </li>
                        <li class="nav-item">
                            <a href="/produtos" class="nav-link">Vendas</a>
                        </li>
                        <li class="nav-item">
                            <a href="/info" class="nav-link">Info</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <main>
            <div class="container-fluid">
                <div class="row">
                    @if(session('msg'))
                        <p class="msg">{{session('msg')}}</p>
                    @endif
                    @yield('content')
                </div>
            </div>
        </main>   
        <footer>
            <p>Site Comercial - FERNANDO CANDIDO MAIA&copy; 2023</p>
        </footer>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script> 
    </body>
</html>