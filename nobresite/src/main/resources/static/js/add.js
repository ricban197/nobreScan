 //variaveis
    var   tipo = 0//0 vazio, 1 obra, 2 capitulo
    let confirma;//1 pode postar 0 n pode
    var pesquisa ='';
    var mangas={};
    var id;
 //fim variaveis
window.onload = function() {

    if(add_obra==null){
        var add_capitulo =  document.getElementById("cap");
        var add_obra     =  document.getElementById("obr");
    }
    add_capitulo.style.visibility="hidden";
    add_obra.style.visibility="hidden";


}
function manga(){
    var add_capitulo =  document.getElementById("cap");
    var add_obra     =  document.getElementById("obr");

    add_capitulo.style.visibility="hidden";
    add_obra.style.visibility="visible";

    tipo =1;
}
function cap(){
    var add_capitulo =  document.getElementById("cap");
    var add_obra =      document.getElementById("obr");
    add_capitulo.style.visibility="visible";
    add_obra.style.visibility="hidden";
    tipo =2;
}
async function envia(){
        if(tipo==1){
         enviaManga();
        }
        if(tipo==2){
        enviaCapitulo();
        }
}
async function enviaManga(){
    var user ={};
    user["user"]=$("#userInfo").val();
    user["senha"]=$("#senhaInfo").val();
    var manga={};
    manga["nome"]=$("#nome_obra_ob").val();
    manga["autor"]=$("#autor_obra").val();
    manga["descricao"]=$("#desc_obra").val();
    var dados =new FormData();
    dados.append("user",JSON.stringify(user));
    dados.append("manga",JSON.stringify(manga));
    console.log(dados);
   // dados.append("capa",$("#capa_obra"));
    jQuery.each(jQuery('#capa_obra')[0].files, function(i, file) {
        dados.append('capa', file);
    });

    await $.ajax({
        url: "/manga/salva",
        data: dados,
        cache: false,
        contentType: false,
        processData: false,
        method: 'POST',
        success: function (resposta) {
            console.log(resposta);
        },
        error: function (e) {
            console.log("erro: s", e);
        }
    });
}
async function enviaCapitulo(){
    var user ={};
    user["user"]=$("#userInfo").val();
    user["senha"]=$("#senhaInfo").val();
    var capitulo={}
    var capitulo={};
        capitulo["nome"]=$("#nomeCap").val();
        capitulo["idmanga"]=mangas[id].id;
        capitulo["total_paginas"]=$("#numPags").val();
        capitulo["id"]=null;
        capitulo["upload"]=null;
        capitulo["numCap"]=$("#numCap").val();
        console.log(capitulo);

    var dados =new FormData();
    dados.append("user",JSON.stringify(user));
    dados.append("capitulo",JSON.stringify(capitulo));
    jQuery.each(jQuery('#pags')[0].files, function(i, file) {
        dados.append('pags', file);
    });

    await $.ajax({
        url: "/capitulo/salva",
        data: dados,
        cache: false,
        contentType: false,
        processData: false,
        method: 'POST',
        success: function (resposta) {
            console.log(resposta);
        },
        error: function (e) {
            console.log("erro: s", e);
        }
    });
}
function seleciona(i){

    id=i;
}
/* captura teclado */

window.addEventListener("keyup", function(e){
     if(tipo==2){  //pede a busca somente quando a barra esta selecionada
            busca("resultados","pesquisa_cap");
     }
     if(tipo==1){  //pede a busca somente quando a barra esta selecionada
             busca("result","pesquisa_obra");
     }
});
/* fim captura teclado*/
function busca(destino,origem){
    var info = {}
    info["nome"] ='';
    info["nome"] = $('#'+origem).val();
    if(info["nome"]!=''){
        if(info["nome"]!=pesquisa){
        pesquisa=info["nome"];
         $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/manga/pesquisa",
                    data: JSON.stringify(info),
                    dataType: 'json',
                    cache: false,
                    timeout: 600000,
                    success: function (data) {
                    mangas =data;
                    res= "";
                    if(tipo==1){
                        for(var i =0; i<data.length;i++){
                            res=res+""+
                            "<div id='capa'>"+
                            "<img id='ima' src='/manga/capa/"+data[i].src_capa +"' alt='"+data[i].nome+"'>"+
                            "<nav id='titulo'><p name='titulo'>"+data[i].nome+"</p> </nav>"+
                            "</div>";
                        }
                    }
                    if(tipo==2){
                        for(var i =0; i<data.length;i++){
                            res=res+""+
                            "<div id='capa' onclick='seleciona("+i+")'>"+
                            "<img id='ima' src='/manga/capa/"+data[i].src_capa +"' alt='"+data[i].nome+"'>"+
                            "<nav id='titulo'><p name='titulo'>"+data[i].nome+"</p> </nav>"+
                            "</div>";
                        }
                    }

                        document.getElementById(destino).innerHTML=res;
                    },
                    error: function (e) {
                        console.log("ERROR : ", e);
                              }
                });
        }
     }else{
        pesquisa="";
        res= "";
        document.getElementById(destino).innerHTML=res;
     }

}

