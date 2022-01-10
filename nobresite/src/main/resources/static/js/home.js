/*
   @Ricban
   email:ricardobandeira197@gmail.com
*/
function logout(){
        localStorage.clear();
        window.location.href="/home";
}
var mangas={};
//fim declaraçoes
window.onscroll = function(){rolar();}
function rolar(){
    var cab  = document.getElementById("header");
    var logo = document.getElementById("logo");
    var roda = document.getElementById("rodape");
    var desc = document.getElementById("descricao");
    if(document.documentElement.scrollTop>52){    //topo
        cab.style.padding ="0px 0px";
        cab.style.top="-20%";
        desc.style.top="0%";
        desc.style.height="95%";
       //logo.style.bottom ="0px";
       
    }else{//rolando pra baixo
      //  logo.style.bottom ="80px";
      desc.style.top="16%";
        cab.style.padding="5px";
        cab.style.top="0%"
         desc.style.height="80%";
        
    }   
    
    if(document.body.scrollTop<1000){//fim da pagina
        roda.style.padding ="0px 0px";
        
    }else{
        roda.style.padding ="65px 0px";
        
    }
    
}
function add(){
window.location='/add';
}
function esconde(){
    desc = document.getElementById("descricao");
    desc.style.visibility="hidden";
}
window.onload = function() {
    user = localStorage.getItem('userData');
    user = JSON.parse(localStorage.getItem('userData'));
    if(user != null){
        document.getElementById("user").innerHTML="Olá, "+user["nickname"];
    }else{
        document.getElementById("user").innerHTML="Olá, "+"visitante";
    }
    if(user["autorizacao"] != 0){
            document.getElementById("admin").innerHTML="<input type='button' value='admin' onclick='add()' class='botao' id='add'/>";
    }

   busca();//Carega pagina com os mangas desponiveis
   esconde();
};
window.addEventListener("keyup", function(e){
    console.log(pesquisaSelecionada);
     if(pesquisaSelecionada){  //pede a busca somente quando a barra esta selecionada
        busca();
     }
});
function busca(){
     var info = {}
        info["nome"] = $('#nome').val();
        console.log($('#nome').val());
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
                //var res="<div id='lista'>";
                //var j=0
                for(var i =0; i<data.length;i++){
                    //j++;
                  //  if(j>10){
                    //    res=res+"</div><div id='lista'>";
                     //   j=1;
                    //}

                    res=res+""+
                    "<div id='capa' onclick='descricao("+i+")'>"+
                    "<img id='ima' src='/manga/capa/"+data[i].src_capa +"' alt='"+data[i].nome+"'>"+
                    "<div id='titulo'><p name='titulo'>"+data[i].nome+"</p> </div>"+
                    "</div>";


            }
            //res=res+"</div>"
                document.getElementById("corpo").innerHTML=res;
            },
            error: function (e) {
                console.log("ERROR : ", e);
                      }
        });
}
function ler(id){
    console.log(1+id-1);
    console.log(mangas[1+id-1]);   
    console.log();
    localStorage.setItem('manga', JSON.stringify(mangas[1+id-1]) );

    window.location="/ler";
}
function descricao(id){
   document.getElementById("descricao").style.visibility="visible";
   document.getElementById("info").innerHTML=mangas[id].nome+"</br>"+
   "<div id='texto_descricao'>"+mangas[id].descricao+"</div>"+
   "<input type='button' value='Ler' id='ler' class='botao' onclick='ler("+id+")'/>"


   "";


}
/*        barra de pesquisa config             */
    var pesquisa = document.getElementById('nome');
    var pesquisaSelecionada= false;
    pesquisa.addEventListener('focus',function(){
        pesquisaSelecionada =true;
    });
    pesquisa.addEventListener('blur',function(){
        pesquisaSelecionada =false;
    });
/*      fim  barra de pesquisa config          */

