<?php echo $this->extend('Layouts/principal'); ?>



<?php echo $this->section('titulo') ?><?php echo $titulo; ?><?php echo $this->endSection() ?>



<?php echo $this->section('estilos') ?>

<!-- estilos da view -->

<?php echo $this->endSection() ?>



<?php echo $this->section('conteudo') ?>

<!-- conteudo da view -->
<div class="row">
    <div class="col-lg-12">
        <div class="block">

            <div class="tab-content my-3" id="pills-tabContent">
                <div class="tab-pane fade <?php echo (session()->has('transacao') ? '' : 'show active'); ?> " id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="user-block text-center">
                        <div class="user-title">
                            <h5 class="card-title my-2"><?php echo esc($venda->id); ?></h5>
                        </div>

                        <p class="contributions mt-0"><?php echo $venda->situacao; ?></p>
                        <p class="card-text">Nome Identificador: <?php echo $venda->nome; ?></p>
                        <p class="card-text">Criado <?php echo date('d/m/Y H:m', strtotime($venda->criado_em)); ?></p>
                        <p class="card-text">Atualizado <?php echo date('d/m/Y H:m', strtotime($venda->atualizado_em)); ?></p>

                        <hr class="border-secondary">

                        <?php if ($venda->itens === null) : ?>

                            <div class="contributions py-3">

                                <p>Nenhum item foi adicionado à venda</p>

                                <a class="btn btn-outline-info" href="<?php echo site_url("vendasitens/itens/$venda->id") ?>">Adicionar item</a>
                            </div>
                        <?php else : ?>

                            <div class="table-responsive my-5">
                                <table class="table table-hover text-left">

                                    <thead>
                                        <tr>
                                            <th scope="col">Item</th>
                                            <th scope="col">Preço (R$)</th>
                                            <th scope="col">Quantidade</th>
                                            <th scope="col">Subtotal (R$)</th>
                                            <th scope="col">Desconto por Qtd.</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php

                                        $valorProdutos = 0;
                                        $desconto = 0;
                                        ?>

                                        <?php foreach ($venda->itens as $item) : ?>
                                            <?php

                                            $valorProdutos += $item->valor_unitario * $item->item_quantidade;

                                            ?>
                                            <tr>
                                                <th scope="row"><?php echo $item->nome; ?></th>


                                                <td style="text-align: center;"><?php echo esc(number_format($item->valor_unitario, 2)); ?></td>

                                                <td style="text-align: center;">
                                                    <?php echo $item->item_quantidade; ?>
                                                </td>

                                                <td style="text-align: center;"><?php echo esc(number_format($item->item_quantidade * $item->valor_unitario, 2)); ?></td>

                                                <?php if ($item->item_quantidade >= 10 && $item->item_quantidade < 20) : ?>
                                                    <th style="text-align: center;">5%</th>
                                                    <?php $desconto = $valorProdutos * 0.05; ?>

                                                <?php elseif ($item->item_quantidade >= 20 && $item->item_quantidade < 30) : ?>
                                                    <th style="text-align: center;">10%</th>
                                                    <?php $desconto = $valorProdutos * 0.1; ?>

                                                <?php elseif ($item->item_quantidade >= 30) : ?>
                                                    <th style="text-align: center;">20%</th>
                                                    <?php $desconto = $valorProdutos * 0.2; ?>

                                                <?php else : ?>
                                                    <th style="text-align: center;">0%</th>

                                                <?php endif; ?>
                                            </tr>

                                        <?php endforeach; ?>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td class="text-right fort-weight-bold" colspan="4">
                                                <label>Valor produtos:</label>
                                            </td>
                                            <td class="fort-weight-bold">R$ <?php echo esc(number_format($valorProdutos, 2)); ?></td>

                                        </tr>

                                        <tr>
                                            <td class="text-right fort-weight-bold" colspan="4">
                                                <label>Valor desconto:</label>
                                            </td>
                                            <td style="text-align: left;" class="fort-weight-bold">R$ <?php

                                                                                                        if ($venda->valor_desconto == NULL) :
                                                                                                            echo esc(number_format($desconto, 2));

                                                                                                        else :
                                                                                                            echo esc(number_format($venda->valor_desconto, 2));

                                                                                                        endif; ?></td>

                                        </tr>

                                        <tr>
                                            <td class="text-right fort-weight-bold" colspan="4">
                                                <label>Valor total com desconto:</label>
                                            </td>
                                            <td style="text-align: left;" class="fort-weight-bold">R$ <?php

                                                                                                        $valorItens = $valorProdutos;
                                                                                                        if ($venda->valor_desconto == 0) :
                                                                                                            echo esc(number_format($valorItens - $desconto, 2));
                                                                                                        else :
                                                                                                            echo esc(number_format($valorItens - $venda->valor_desconto, 2));
                                                                                                        endif;
                                                                                                        ?>
                                            </td>

                                        </tr>
                                    </tfoot>
                                </table>
                                <div style="text-align: rigth;">
                                    <a class="btn btn-warning btn-sm" href="<?php echo site_url("vendas/encerrar/$venda->id"); ?>">
                                        Finalizar Venda
                                    </a>
                                </div>
                            </div>

                        <?php endif; ?>
                    </div>
                </div>
            </div>

            <!-- Example single danger button -->
            <div class="btn-group">
                <button type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Ações
                </button>
                <div class="dropdown-menu">

                    <a class="dropdown-item" href="<?php echo site_url("vendas/editar/$venda->id"); ?>">Editar venda</a>

                    <a class="dropdown-item" href="<?php echo site_url("vendasitens/itens/$venda->id"); ?>">Gerenciar itens da venda</a>

                    <div class="dropdown-divider"></div>

                    <?php if ($venda->deletado_em === null) : ?>
                        <a class="dropdown-item" href="<?php echo site_url("vendas/excluir/$venda->id"); ?>">Excluir venda</a>
                    <?php else : ?>
                        <a class="dropdown-item" href="<?php echo site_url("vendas/restaurarvenda/$venda->id"); ?>">Restaurar venda</a>
                    <?php endif ?>
                </div>
            </div>

            <a href="<?php echo site_url("vendas"); ?>" class="btn btn-secondary btn-sm ml-2">Voltar</a>

        </div>

    </div>

</div>

<?php echo $this->endSection() ?>



<?php echo $this->section('scripts') ?>

<!-- scripts da view -->
<script src="<?php echo site_url('Resources/vendor/loadingoverlay/loadingoverlay.min.js'); ?>"></script>

<script>
    $(document).ready(function() {

        $("#btn-get-gerencianet").on('click', function() {

            $('.block').LoadingOverlay("show", {
                image: "",
                text: "Processando cancelamento...",
            });
        });
    });
</script>

<?php echo $this->endSection() ?>