<?php echo $this->extend('Layouts/principal'); ?>



<?php echo $this->section('titulo') ?><?php echo $titulo; ?><?php echo $this->endSection() ?>



<?php echo $this->section('estilos') ?>

<!-- estilos da view -->

<?php echo $this->endSection() ?>



<?php echo $this->section('conteudo') ?>

<!-- conteudo da view -->
<div class="row">
    <div class="col-lg-5">
        <div class="user-block block">

            <h5 class="card-title mt-2"><?php echo esc($item->nome); ?></h5>
            <p class="card-text">Valor de venda: R$&nbsp;<?php echo $item->valor_unitario; ?></p>
            <p class="card-text">Criado em <?php echo date('d/m/Y',strtotime($item->criado_em)); ?></p>
            <p class="card-text">Atualizado <?php echo date('d/m/Y',strtotime($item->atualizado_em)); ?></p>

            <!-- Example single danger button -->
            <div class="btn-group">
                <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Ações
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="<?php echo site_url("itens/editar/$item->id"); ?>">Editar item</a>

                    <div class="dropdown-divider"></div>

                    <?php if ($item->deletado_em == null) : ?>
                        <a class="dropdown-item" href="<?php echo site_url("itens/excluir/$item->id"); ?>">Excluir item</a>
                    <?php else : ?>
                        <a class="dropdown-item" href="<?php echo site_url("itens/restauraritem/$item->id"); ?>">Restaurar item</a>
                    <?php endif ?>
                </div>
            </div>

            <a href="<?php echo site_url("itens"); ?>" class="btn btn-secondary ml-2">Voltar</a>

        </div>

    </div>

</div>

<?php echo $this->endSection() ?>



<?php echo $this->section('scripts') ?>

<!-- scripts da view -->

<?php echo $this->endSection() ?>