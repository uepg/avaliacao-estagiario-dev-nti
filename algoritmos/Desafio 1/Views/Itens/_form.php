<div class="row">

    <div class="form-group col-md-6">
        <label class="form-control-label">Nome</label><span class="text-danger">*</span>
        <input type="text" name="nome" placeholder="Insira o nome do serviço" class="form-control" value="<?php echo esc($item->nome); ?>">
    </div>

</div>

<div class="form-row">

    <div class="form-group col-md-4">
        <label class="form-control-label">Preço de venda</label><span class="text-danger">*</span>
        <input type="text" name="valor_unitario" placeholder="Valor de venda" class="form-control money" value="<?php echo esc($item->valor_unitario); ?>">
    </div>

</div>


<div class="form-group mt-3">
    <span class="text-danger">* Campos Obrigatórios.</span>
</div>