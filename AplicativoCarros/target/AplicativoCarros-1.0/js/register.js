$(document).ready(function(){
    $("#createUser").submit(function (event){
        event.preventDefault();
        createUser();
    });
});

function createUser()
{

    const user = $("#usernameC").val();
    const pass1 = $("#pass1").val();
    const pass2 = $("#pass2").val();
    const name = $("#name").val();
    const lastname1 = $("#lastname1").val();
    const lastname2 = $("#lastname2").val();
    const email = $("#email").val();

    if(pass1 === pass2)
    {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletCreateUser",
            data: $.param({
                name: name,
                password: pass1,
                email: email,
                lastname1: lastname1,
                lastname2: lastname2,
                user: user
            }),
            success: function (result) {
                const parsedResult = JSON.parse(result);
                if (parsedResult !== false) {
                    username = parsedResult.username;
                    document.location.href = "home.html?username="+username;
                }
            }
        })
    }
    else
    {
        console.log("errorPassword");
        $("#errorPassword").removeClass("d-none");
    }

}
