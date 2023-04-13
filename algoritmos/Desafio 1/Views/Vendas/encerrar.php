<?php echo $this->extend('Layouts/principal'); ?>



<?php echo $this->section('titulo') ?><?php echo $titulo; ?><?php echo $this->endSection() ?>



<?php echo $this->section('estilos') ?>

<!-- estilos da view -->

<?php echo $this->endSection() ?>



<?php echo $this->section('conteudo') ?>

<!-- conteudo da view -->
<div class="row">
    <div class="col-lg-6">
        <div class="block">

            <div class="block-body">

                <!-- Exibe os retornos do banco -->

                <?php echo form_open("vendas/processaEncerramento/$venda->id") ?>

                <div class="alert alert-warning" role="alert">
                    Tem certeza que deseja finalizar a venda? Não será possível alterar posteriomente.
                </div>

                <div class="form-group mt-5 mb-2">

                    <input id="btn-salvar" type="submit" value="Sim, quero finalizar a venda" class="btn btn-danger btn-sm mr-2">

                    <a href="<?php echo site_url("vendas/detalhes/$venda->id"); ?>" class="btn btn-secondary btn-sm ml-2">Cancelar</a>
                </div>


                <?php echo form_close(); ?>

            </div>

        </div>

    </div>

</div>

<?php echo $this->endSection() ?>



<?php echo $this->section('scripts') ?>

<!-- scripts da view -->


<?php echo $this->endSection() ?>