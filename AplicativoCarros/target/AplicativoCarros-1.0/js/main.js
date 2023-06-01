const username = new URL(location.href).searchParams.get("username");
let user;
const converBool = {
    1: "checked",
    0: ""
};

$(document).ready(() => {

    $(() => {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUser()
        .then(() => {
            $("#perfil").attr("href", "profile.html?username="+username);
            $("#saldo").html("$ " + user.saldo.toFixed(2));
            getCarros(false,"ASC");
            $("ordernar-carros").click(ordenarCarros());
        });
});


async function getUser()
{
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function(result) {
            const parsedResult = JSON.parse(result);
            if(parsedResult)
            {
                user = parsedResult;
                
            }
        }
    }).fail(() => {
        console.log("Error to recover data");
    });
}

function getCarros(ordenar, orden)
{
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletCarroListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: (result) => {
            const parsedResult = JSON.parse(result);
            if(parsedResult)
            {
               mostrarCarros(parsedResult);
            }
        }
    });
}

function mostrarCarros(carros)
{
    let contenido = "";
    
    $.each(carros, (index, carro) => {
        let precio;
        console.log(carro)
        if(carro.novedad !== 1)
        {
            if(user.premiun)
            {
                precio = (2 - (2*0.1));
            }
            else
            {
                precio = carro.price;
            }
        }
        
        contenido += '<tr><th scope="row">' + carro.ID + '</th>' +
            '<td>' + carro.marca + '</td>' +
            '<td>' + carro.model + '</td>' +
            '<td>' + carro.anio_lanzamiento.substring(0,10) + '</td>' +
            '<td>' + carro.price + '</td>' +
            '<td><button onclick="alquilarCarro(' + carro.ID + ',' + precio + ')" class="btn btn-primary"';
            if(converBool[carro.novedad] === "checked")
            {
                 contenido += ' disabled >Reservar</button></td>';
            }
            else
            {
                contenido += '>Reservar</button></td>';
            }
               
            contenido += '<td><input type="checkbox" name="novedad" id="novedad" '+ converBool[carro.novedad];
            if(converBool[carro.novedad] === "checked")
            {
                 contenido += ' disabled >';
            }else
            {
                contenido += '>';
            }
            
        contenido +=  '</td></tr>';

    });
    
    $("#tbody").html(contenido);
}

function ordenarCarros()
{
    if($("#icono-ordenar").hasClass("fa-sort"))
    {
        getCarros(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    }
    else if($("#icono-ordenar").hasClass("fa-sort-down"))
    {
        getCarros(true, "DESC");
        $("#icono-ordenar").addClass("fa-sort-down");
        $("#icono-ordenar").removeClass("fa-sort-up");
    }
    else if($("#icono-ordenar").hasClass("fa-sort-up"))
    {
        getCarros(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}