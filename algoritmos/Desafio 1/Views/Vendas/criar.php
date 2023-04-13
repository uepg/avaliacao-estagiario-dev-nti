<?php echo $this->extend('Layouts/principal'); ?>



<?php echo $this->section('titulo') ?><?php echo $titulo; ?><?php echo $this->endSection() ?>



<?php echo $this->section('estilos') ?>

<!-- estilos da view -->

<?php echo $this->endSection() ?>



<?php echo $this->section('conteudo') ?>

<!-- conteudo da view -->
<div class="row">
    <div class="col-lg-10">
        <div class="block">

            <div class="block-body">

                <!-- Exibe os retornos do banco -->
                <div id="response">

                </div>

                <?php echo form_open('/', ['id' => 'form'], ['id' => "$venda->id"]) ?>

                <?php echo $this->include('Vendas/_form'); ?>

                <div class="form-group mt-5 mb-2">

                    <input id="btn-salvar" type="submit" value="Salvar" class="btn btn-success btn-sm mr-2">

                    <a href="<?php echo site_url("vendas"); ?>" class="btn btn-secondary btn-sm ml-2">Voltar</a>
                </div>


                <?php echo form_close();?>

            </div>

        </div>

    </div>

</div>

<?php echo $this->endSection() ?>



<?php echo $this->section('scripts') ?>

<script src="<?php echo site_url('Resources/vendor/mask/jquery.mask.min.js'); ?>"></script>
<script src="<?php echo site_url('Resources/vendor/mask/app.js'); ?>"></script>

<!-- scripts da view -->
<script>

    $(document).ready(function(){

        /*
        $("[name=tipo]").on('click', function(){

            if($(this).val() === 'serviço'){

                $('.servico').hide('slow');

                $("[name=marca]").prop("disabled", true);
                $("[name=modelo]").prop("disabled", true);
                $("[name=estoque]").prop("disabled", true);
                $("[name=preco_custo]").prop("disabled", true);
                $("[name=controla_estoque]").prop("disabled", true);
            }else{

                $('.servico').show('slow');
                
                $("[name=marca]").prop("disabled", false);
                $("[name=modelo]").prop("disabled", false);
                $("[name=estoque]").prop("disabled", false);
                $("[name=preco_custo]").prop("disabled", false);
                $("[name=controla_estoque]").prop("disabled", false);
            }

        });*/

        $("#form").on('submit',function(e){

            e.preventDefault();

            $.ajax({

                type: 'POST',
                url: '<?php echo site_url('vendas/cadastrar'); ?>',
                data: new FormData(this),
                dataType: 'json',
                contentType: false,
                cache: false,
                processData: false,
                beforeSend: function(){

                    $("#response").html('');
                    $("#btn-salvar").val('Por favor aguarde...');
                },
                success: function(response){

                    $("#btn-salvar").val('Salvar');
                    $("#btn-salvar").removeAttr("disabled");

                    $('[name=csrf_ordem]').val(response.token);

                    if(!response.erro){

                        window.location.href = "<?php echo site_url("vendas/detalhes/"); ?>"+response.id;

                    }else{
                        
                        //existe erros de validação
                        $("#response").html('<div class="alert alert-danger">' + response.erro + '</div>');

                        if(response.erros_model){

                            $.each(response.erros_model, function(key, value){

                                $("#response").append('<ul class="list-unstyled"><li class="text-danger">' + value + '</li></ul>');    
                            });
                        }

                    }
                },
                error: function(){

                    alert('Não foi possivel processar a solicitação. Erro interno!');
                    $("#btn-salvar").val('Salvar');
                    $("#btn-salvar").removeAttr("disabled");
                },

            });

        });

        $("#form").submit(function(){

            $(this).find(":submit").attr('disabled', 'disabled');
        });

    });

</script>

<?php echo $this->endSection() ?>