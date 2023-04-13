<?php echo $this->extend('Layouts/principal'); ?>



<?php echo $this->section('titulo') ?><?php echo $titulo; ?><?php echo $this->endSection() ?>



<?php echo $this->section('estilos') ?>

<!-- estilos da view -->
<link rel="stylesheet" type="text/css" href="<?php echo site_url('Resources/vendor/datatables/datatables-combinado.min.css')?>"/>
 

<?php echo $this->endSection() ?>



<?php echo $this->section('conteudo') ?>

<!-- conteudo da view -->
<div class="row">

    <div class="col-lg-12">
        <div class="block">

            <div class="table-responsive">
                <table id="ajaxTable" class="table table-striped table-sm" style="width: 100%;">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome Identificador</th>
                            <th>Criada em</th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div style="text-align: right;">
            <a href="<?php echo site_url('Vendas/criar'); ?>" class="btn btn-secondary mt-5">Cadastrar ordem de serviço</a>
            </div>
        </div>
    </div>
</div>

<?php echo $this->endSection() ?>



<?php echo $this->section('scripts') ?>

<!-- scripts da view -->
<script type="text/javascript" src="<?php echo site_url('Resources/vendor/datatables/datatables-combinado.min.js')?>"></script>


<script>

$(document).ready(function() {

    const DATATABLE_PTBR = {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "oAria": {
                "sSortAscending": ": Ordenar colunas de forma ascendente",
                "sSortDescending": ": Ordenar colunas de forma descendente"
            },
            "select": {
                "rows": {
                    "_": "Selecionado %d linhas",
                    "0": "Nenhuma linha selecionada",
                    "1": "Selecionado 1 linha"
                }
            }
        }



    $('#ajaxTable').DataTable( {

        "oLanguage": DATATABLE_PTBR,

        "ajax": "<?php echo site_url('vendas/recuperavendas'); ?>",
        "columns": [
            { "data": "codigo" },
            { "data": "nome"},
            { "data": "criado_em" },
        ],
        "order": [],
        "deferRender": true,
        "processing": true,
        "language": {
            processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>',
        },
        "responsive": true,
        "pagingType": $(window).width() < 768 ? "simple" : "simple_numbers",
    } );
} );

</script>

<?php echo $this->endSection() ?>