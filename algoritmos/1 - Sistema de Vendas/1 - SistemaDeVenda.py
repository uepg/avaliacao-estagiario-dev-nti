import datetime

print("Sistema de Vendas!")

listavendas = []
numero_venda = 1
valor_total = 0
data = datetime.datetime.now()

while True:
    nomeProduto = str(input("Digite o nome do produto: "))
    codigo = int(input("Digite o código do produto: "))
    quantidade = int(input("Digite a quantidade de produtos: "))
    valorUnitario = float(input("Digite o valor do produto: "))

    itens_vendidos = []

    nome = nomeProduto
    qtde = quantidade
    valor_unitario = valorUnitario

    item = {
        "produto": nome,
        "qtde": qtde,
        "valor_unitario": valor_unitario
    }

    if qtde > 30:
        desconto = 0.2
    elif qtde > 20:
        desconto = 0.1
    elif qtde > 10:
        desconto = 0.05
    else:
        desconto = 0.0

    valor_total_item = qtde * valor_unitario * (1 - desconto)
    item["valor_total"] = valor_total_item

    itens_vendidos.append(item)

    vlr_total_venda = sum([item["valor_total"] for item in itens_vendidos])
    valor_total += valor_total_item
    if valor_total_item > 0:
        venda = {
            "numero_venda": numero_venda,
            "data_hora": datetime.datetime.now(),
            "itens_vendidos": itens_vendidos,
            "vlr_total_venda": vlr_total_venda,
        }

        opcao = str(input("Deseja continuar a compra? (S/N) ")).upper()
        if opcao == "S":
            continue
        else:
            listavendas.append(venda)
            numero_venda += 1
            for venda in listavendas:
                print("-" * 100)
                print("Número da venda: {}".format(venda["numero_venda"]))
                print("Data e hora: {}".format(venda["data_hora"].strftime("%d/%m/%Y %H:%M:%S")))
                print("-" * 100)
                print("{:<30} {:^15} {:^15} {:^15}".format("|Produto|", "|Quantidade|", "|Valor unitário|", "|Valor total|"))
                print("-" * 100)
                for item in venda["itens_vendidos"]:
                    print("{:<30} {:^15} {:^15.2f} {:^15.2f}".format(item["produto"], item["qtde"], item["valor_unitario"], item["valor_total"]))
                print("-" * 100)
                print("Valor total da venda: R${:.2f}".format(venda["vlr_total_venda"]))
    callback = str(input("Gostaria de realizar mais uma compra? (S/N) ")).upper()
    if callback == "S":
        continue
    else:
        break
