<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Vendas | <?php echo $this->renderSection('titulo'); ?> </title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="robots" content="all,follow">
  <!-- Bootstrap CSS-->
  <link rel="stylesheet" href="<?php echo site_url('Resources/'); ?>vendor/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome CSS-->
  <link rel="stylesheet" href="<?php echo site_url('Resources/'); ?>vendor/font-awesome/css/font-awesome.min.css">
  <!-- Custom Font Icons CSS-->
  <link rel="stylesheet" href="<?php echo site_url('Resources/'); ?>css/font.css">
  <!-- Google fonts - Muli-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
  <!-- theme stylesheet-->
  <link rel="stylesheet" href="<?php echo site_url('Resources/'); ?>css/style.default.css" id="theme-stylesheet">
  <!-- Custom stylesheet - for your changes-->
  <link rel="stylesheet" href="<?php echo site_url('Resources/'); ?>css/custom.css">
  <!-- Favicon-->
  <link rel="shortcut icon" href="<?php echo site_url('Resources/'); ?>img/favicon.ico">
  <!-- Tweaks for older IEs-->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

  <!-- espaço para renderizar os estilos de cada view-->
  <?php echo $this->renderSection('estilos'); ?>

</head>

<body>
  <header class="header">
    <nav class="navbar navbar-expand-lg">
      <div class="search-panel">
        <div class="search-inner d-flex align-items-center justify-content-center">
          <div class="close-btn">Close <i class="fa fa-close"></i></div>
          <form id="searchForm" action="#">
            <div class="form-group">
              <input type="search" name="search" placeholder="What are you searching for...">
              <button type="submit" class="submit">Search</button>
            </div>
          </form>
        </div>
      </div>
      <div class="container-fluid d-flex align-items-center justify-content-between">
        <div class="navbar-header">
          <!-- Sidebar Toggle Btn-->
          <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
        </div>
        <div class="right-menu list-inline no-margin-bottom">
      </div>
    </nav>
  </header>
  <div class="d-flex align-items-stretch">
    <!-- Sidebar Navigation-->
    <nav id="sidebar">
      <!-- Sidebar Header-->
      <div class="sidebar-header d-flex align-items-center">
        <div class="avatar">
            <img src="<?php echo site_url("Resources/img/usuario_sem_imagem.png"); ?>" class="img-fluid rounded-circle">
        </div>
        <div class="title">
            <p>Administrador</p>
        </div>
      </div>
      <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
      <ul class="list-unstyled">


        <li class="<?php echo (url_is('/') ? 'active' : '') ?>"><a href="<?php echo site_url('/'); ?>"> <i class="icon-home"></i>Home </a></li>

        <li class="<?php echo (url_is('Vendas*') ? 'active' : '') ?>"><a href="<?php echo site_url('Vendas'); ?>"> <i class="icon-list"></i>Vendas </a></li>

        <li class="<?php echo (url_is('Itens*') ? 'active' : '') ?>"><a href="<?php echo site_url('Itens'); ?>"> <i class="icon-list"></i>Itens </a></li>

    </nav>
    <!-- Sidebar Navigation end-->
    <div class="page-content">
      <div class="page-header">
        <div class="container-fluid">
          <h2 class="h5 no-margin-bottom"><?php echo $titulo; ?></h2>
        </div>
      </div>
      <section class="no-padding-top no-padding-bottom">

        <div class="container-fluid">

          <?php echo $this->include('/Layouts/_mensagens'); ?>

          <!-- espaço para renderizar os conteudo de cada view-->
          <?php echo $this->renderSection('conteudo'); ?>
        </div>

      </section>

      <footer class="footer">
        <div class="footer__block block no-margin-bottom">
          <div class="container-fluid text-center">
            <!-- Please do not remove the backlink to us unless you support us at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
            <p class="no-margin-bottom"><?php echo date('Y'); ?> Sistema Vendas.</p>
          </div>
        </div>
      </footer>
    </div>
  </div>
  <!-- JavaScript files-->
  <script src="<?php echo site_url('Resources/'); ?>vendor/jquery/jquery.min.js"></script>
  <script src="<?php echo site_url('Resources/'); ?>vendor/popper.js/umd/popper.min.js"> </script>
  <script src="<?php echo site_url('Resources/'); ?>vendor/bootstrap/js/bootstrap.min.js"></script>
  <script src="<?php echo site_url('Resources/'); ?>js/front.js"></script>

  <!-- espaço para renderizar os scripts de cada view-->
  <?php echo $this->renderSection('scripts'); ?>

  <script>
    $(function() {
      $('[data-toggle="popover"]').popover({
        html: true,
      })
    })
  </script>
</body>

</html>