
function fire_ajax_submit() {
    localStorage.clear();
    var info = {}
    info["user"] = $("#user").val();
    info["senha"] = $("#senha").val();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/usuario/logar",
        data: JSON.stringify(info),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if(data['id']==-1){
                console.log("user errado");
            }
            else if(data['id']==-2){
                console.log("senha errada");
            }else
                redireciona(data);


        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });



}
function redireciona(a){

        localStorage.setItem('userData', JSON.stringify(a));
        window.location.href="/home";
    }