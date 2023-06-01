$(document).ready(function(){
    $("#form").submit(function (event){
        event.preventDefault();
        autenticarUsuario();
    });
});

function autenticarUsuario(){

    const username = $("#username").val();
    const contrasena = $("#password").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            password: contrasena
        }),
        success: function (result) {
            const parsedResult = JSON.parse(result);
            console.log(parsedResult);
            if (parsedResult) {
                const user = parsedResult.username;
                document.location.href = "home.html?username="+user;
            }
        }
    }).fail(() => {
        $("#errorLogin").removeClass("d-none");
    });
}
