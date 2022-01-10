var idmanga = JSON.parse(sessionStorage.getItem('chave'));
var urlcarregapahttp = '//localhost/scan2_0/php/carregaPags.php';
$(window).on("load", function(){//Carregas os caps disponiveis
    

    var manga={};
    manga["manga"] = localStorage.getItem('manga');
    console.log(manga);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/capitulo/todos",
        data: JSON.stringify(manga),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
             document.getElementById('corpo').innerHTML="<div id='caps'>";
                        for(var i=0;i<data.length;i++){
                            document.getElementById('corpo').innerHTML="<div class='cap'>"+
                            "Capitulo: "+data.nome+" pag:"+data.total_paginas+
                            "</div>"
                        }
                        document.getElementById('corpo').innerHTML="</div>";
        },
        error: function (e) {
            console.log("ERROR : ", e);
                  }
    });

   /* $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/capitulo/todos",
        data: info,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {         
        document.getElementById('corpo').innerHTML="<div id='caps'>";
            for(var i=0;i<data.length;i++){
                document.getElementById('corpo').innerHTML="<div class='cap'>"+
                "Capitulo: "+data.nome+" pag:"+data.total_paginas+
                "</div>"
            }
            document.getElementById('corpo').innerHTML="</div>"; 
        },
        error: function (e) {
            console.log("ERROR : ", e);
                  }
    });*/

});
/*
 
*/ 




/*
function abre(ID){//Carrega o cap selecionado
    $.ajax({
        url: urlcarregapahttp,
        method: 'POST',
        data: {idpassado:ID},
        dataType: "html",
        success: function(respota){
            document.getElementById('corpo').innerHTML ='';
            document.getElementById('corpo').innerHTML =respota;
     
        }
    });
}*/
window.onscroll = function(){rolar();}
function rolar(){
    var cab  = document.getElementById("header");
    var Logo = document.getElementById("logo");
    if(document.body.scrollTop>80 || document.documentElement.scrollTop>66){    //topo    
        cab.style.padding ="0px 0px";
        cab.style.top="-20%";
        Logo.style.top="-20%";
    }else{//rolando pra baixo
        cab.style.padding="5px";
        cab.style.top="0%";
        Logo.style.top="-50px";
        
    }
}
function logout(){
    localStorage.clear();
    header("/home");

}