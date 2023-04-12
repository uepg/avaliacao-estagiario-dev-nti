var btn_catch = document.querySelector('.btn');
var discount  = 0;
const store = [];
var total = 0;


function total_price() {
    let values = [];
    for (let index = 0; index < store.length; index++) {
      values.push(store[index].final);
      
    }
    total = values.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
    console.log(total);
    document.querySelector('.list h2').innerHTML = `Valor total: ${total}`;
}


btn_catch.addEventListener('click',()=>{
    var item_code = document.querySelector('.code').value;
    var item_value = document.querySelector('.valor').value;
    var item_num = document.querySelector('.quantia').value;
    var nome_item = document.querySelector('.nome_item').value;
    var i = i;
    var date  = new Date();
    date = date.toLocaleDateString()
    Final_Price(item_value,item_num);
    const sold = {sold_number:i,code:item_code,date:date,nome:nome_item,value:discount,quantity:item_num,final:discount};

  
    store.push(sold);

    for(var j = 0;j<store.length;j++){
        var render  = document.querySelector(".info_display");
        render.innerHTML =`
        <div class="info_wrapper">
            <span>Item:`+store[j].nome+`</span>
            <span>Preço:`+store[j].value+`</span>
            <span>Data de compra:`+store[j].date+`</span>
        </div>`;
    }
    console.log(store);
    total_price();
    i+=1;
})


function Final_Price(value,quantity){
  
    if(quantity>10){
        discount = (value - (value*0.05))*quantity;
    }else if(quantity>20){
        discount = (value - (value*0.1))*quantity;
    }else if(quantity>30){
        discount = (value - (value*0.20))*quantity;
    }else{
        discount = value*quantity;
    }
}

