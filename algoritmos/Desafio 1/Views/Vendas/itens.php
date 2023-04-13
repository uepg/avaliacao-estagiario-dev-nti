<?php echo $this->extend('Layouts/principal'); ?>



<?php echo $this->section('titulo') ?><?php echo $titulo; ?><?php echo $this->endSection() ?>



<?php echo $this->section('estilos') ?>

<!-- estilos da view -->
<link rel="stylesheet" href="<?php echo site_url("/Resources/vendor/auto-complete/jquery-ui.css"); ?>">

<style>
    .ui-autocomplete {
        max-height: 300px;
        overflow-y: auto;
        overflow-x: hidden;
        z-index: 9999 !important;
    }

    .ui-menu-item.ui-menu-wrapper.ui-state-active {

        background: #fff !important;
        color: #007bff !important;
        border: none;
    }
</style>

<?php echo $this->endSection() ?>



<?php echo $this->section('conteudo') ?>

<!-- conteudo da view -->
<div class="row">
    <div class="col-lg-12">
        <div class="block">

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-outline-secondary btn-lg" data-toggle="modal" data-target="#exampleModal">
                Adicionar Itens
            </button>

            <?php if ($venda->itens === null) : ?>

                <div class="user-block text-center">
                    <div class="contributions pt-3">
                        <p>Nenhum item foi adicionado à venda</p>
                    </div>
                </div>
            <?php else : ?>

                <div class="table-responsive my-5">
                    <table class="table table-hover">

                        <thead>
                            <tr>
                                <th scope="col">Item</th>
                                <th scope="col">Preço (R$)</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Subtotal (R$)</th>
                                <th scope="col" class="text-center">Remover</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            helper(['form', 'url']);

                            $valorProdutos = 0;
                            ?>

                            <?php foreach ($venda->itens as $item) : ?>
                                <?php
                                    $valorProdutos += $item->valor_unitario * $item->item_quantidade;

                                $hiddenAcoes = [
                                    'id_principal' => $item->id_principal,
                                    'item_id' => $item->id,
                                ];
                                ?>
                                <tr>
                                    <th scope="row"><?php echo $item->nome; ?></th>

                                    <td style="text-align: center;"><?php echo esc(number_format($item->valor_unitario, 2)); ?></td>

                                    <td>
                                        <?php echo form_open("vendasitens/atualizarquantidade/$venda->id", ['class' => 'form-inline'], $hiddenAcoes); ?>

                                        <input style="max-width: 80px !important;" type="number" name="item_quantidade" class="form-control" value="<?php echo $item->item_quantidade; ?>" step="1" required>

                                        <button type="submit" class="btn btn-outline-success btn-sm ml-2">
                                            <i class="fa fa-refresh"></i>
                                        </button>
                                        <?php echo form_close(); ?>
                                    </td>

                                    <td style="text-align: center;"><?php echo esc(number_format($item->item_quantidade * $item->valor_unitario, 2)); ?></td>

                                    <td class="pt-2 ">
                                        <?php $atributosRemover = [
                                            'class' => 'form-inline',
                                            'onClick' => 'return confirm("Tem certeza da exclusão")',
                                        ];
                                        ?>

                                        <?php echo form_open("vendasitens/removeritem/$venda->id", $atributosRemover, $hiddenAcoes); ?>

                                        <button type="submit" class="btn btn-outline-success btn-sm ml-2 mx-auto">
                                            <i class="fa fa-times"></i>
                                        </button>
                                        <?php echo form_close(); ?>
                                    </td>

                                </tr>
                            <?php endforeach; ?>
                        </tbody>
                        <tfoot>

                            <tr>
                                <td class="text-right fort-weight-bold" colspan="4">
                                    <label>Valor total:</label>
                                </td>
                                <td style="text-align: left;" class="fort-weight-bold">R$ <?php echo esc(number_format($valorProdutos, 2)); ?></td>

                            </tr>
                        </tfoot>
                    </table>

                </div>

            <?php endif; ?>



            <!-- Example single danger button -->
            <div class="btn-group">
                <button type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Ações
                </button>
                <div class="dropdown-menu">

                    <a class="dropdown-item" href="<?php echo site_url("vendas/editar/$venda->id"); ?>">Editar venda</a>

                    <div class="dropdown-divider"></div>

                    <?php if ($venda->deletado_em === null) : ?>
                        <a class="dropdown-item" href="<?php echo site_url("vendas/excluir/$venda->id"); ?>">Excluir venda</a>
                    <?php else : ?>
                        <a class="dropdown-item" href="<?php echo site_url("vendas/restaurarvenda/$venda->id"); ?>">Restaurar venda</a>
                    <?php endif ?>
                </div>
            </div>

            <a href="<?php echo site_url("vendas/detalhes/$venda->id"); ?>" class="btn btn-secondary btn-sm ml-2">Voltar</a>

        </div>

    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Adicionar itens na venda</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div id="response">

                </div>

                <div class="ui-widget">
                    <input type="text" name="query" id="query" class="form-control form-control-lg mb-5" placeholder="Pesquise pelo nome ou código do item">
                </div>

                <div class="block-body">

                    <?php

                    helper(['form', 'url']);

                    $hiddens = [
                        'id' => $venda->id,
                        'item_id' => '',
                    ];
                    ?>

                    <?php echo form_open('/', ['id' => 'form'], $hiddens) ?>

                    <div class="form-row">
                        <div class="form-group col-md-8">

                            <label class="form-control-label">Item</label>
                            <input type="text" name="item_nome" class="form-control" readonly required>
                        </div>
                        <div class="form-group col-md-2">

                            <label class="form-control-label">Valor</label>
                            <input type="text" name="item_preco" class="form-control money" readonly required>
                        </div>

                        <div class="form-group col-md-2">

                            <label class="form-control-label">Quantidade</label>
                            <input type="number" name="item_quantidade" class="form-control" value="1" min="1" step="1" required>
                        </div>
                    </div>

                    <div class="form-group mt-5">

                        <input id="btn-salvar" type="submit" value="Salvar" class="btn btn-success btn-sm mr-2">

                        <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Cancelar</button>
                    </div>

                    <?php echo form_close(); ?>

                </div>

            </div>
        </div>
    </div>
</div>

<?php echo $this->endSection() ?>



<?php echo $this->section('scripts') ?>

<!-- scripts da view -->
<script src="<?php echo site_url("Resources/vendor/auto-complete/jquery-ui.js"); ?>"></script>
<script src="<?php echo site_url("Resources/vendor/mask/jquery.mask.min.js"); ?>"></script>
<script src="<?php echo site_url("Resources/vendor/mask/app.js"); ?>"></script>

<script>
    $(document).ready(function() {

        $(function() {

            $("#query").autocomplete({

                minLength: 4,
                source: function(request, response) {

                    $.ajax({

                        url: "<?php echo site_url('vendasitens/pesquisaitens'); ?>",
                        dataType: "json",
                        data: {
                            term: request.term
                        },
                        beforeSend: function() {

                            $("#response").html('');

                            $("#form").trigger('reset');
                        },
                        success: function(data) {

                            if (data.length < 1) {

                                var data = [{
                                    label: 'Item não encontrado',
                                    value: -1,
                                }];
                            }

                            response(data);
                        }, //fim success
                    }); //fim ajax

                }, //fim source

                select: function(event, ui) {

                    $(this).val("");

                    event.preventDefault();

                    if (ui.item.value == -1) { //não achou o item

                        //limpa o input da pesquisa
                        $(this).val("");
                        return false;
                    } else {
                        //achou item
                        var item_id = ui.item.id;
                        var item_nome = ui.item.value;
                        var item_preco = ui.item.item_preco;

                        $("[name=item_id]").val(item_id);
                        $("[name=item_nome]").val(item_nome);
                        $("[name=item_preco]").val(item_preco);

                    }
                },

            }).data("ui-autocomplete")._renderItem = function(ul, item) {

                return $("<li class='ui-autocomplete-row'></li>").data("item.autocomplete", item).append(item.label).appendTo(ul);
            };
        });

        $("#form").on('submit', function(e) {

            e.preventDefault();

            $.ajax({

                type: 'POST',
                url: '<?php echo site_url('vendasitens/adicionaritem'); ?>',
                data: new FormData(this),
                dataType: 'json',
                contentType: false,
                cache: false,
                processData: false,
                beforeSend: function() {

                    $("#response").html('');
                    $("#btn-salvar").val('Por favor aguarde...');
                },
                success: function(response) {

                    $("#btn-salvar").val('Salvar');
                    $("#btn-salvar").removeAttr("disabled");

                    $('[name=csrf_venda]').val(response.token);

                    if (!response.erro) {

                        if (response.info) {

                            $("#response").html('<div class="alert alert-info">' + response.info + '</div>');
                        } else {

                            //tudo certo com a atulização do usuario
                            //liberado para redirecionar
                            window.location.href = "<?php echo site_url("vendasitens/itens/$venda->id"); ?>";
                        }

                    } else {

                        //existe erros de validação
                        $("#response").html('<div class="alert alert-danger">' + response.erro + '</div>');

                        if (response.erros_model) {

                            $.each(response.erros_model, function(key, value) {

                                $("#response").append('<ul class="list-unstyled"><li class="text-danger">' + value + '</li></ul>');
                            });
                        }

                    }
                },
                error: function() {

                    alert('Não foi possivel processar a solicitação. Erro interno!');
                    $("#btn-salvar").val('Salvar');
                    $("#btn-salvar").removeAttr("disabled");
                },

            });

        });

        $("#form").submit(function() {

            $(this).find(":submit").attr('disabled', 'disabled');
        });

    });
</script>

<?php echo $this->endSection() ?>