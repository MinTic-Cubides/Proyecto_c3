const endpoint = "http://localhost:8080/api/Room";

$(document).ready(function(){

    get(),

    $('#save').click(function(){

        save()

    }),

    $('#actualizar').click(function(){

        update()

    })

    /*
    $('#eliminar').click(function(){

        deleteById()

    })*/

})


// Con estas funciones pretendemos limpiar los campos de la etique input
// para cuando se ha enviado un valor.
function cleanDataDelete(){
    $("#idEliminar").val("");
}

function cleanDataUpdate(){
    $("#id").val("");
    $("#name").val("");
    $("#hotel").val("");
    $("#stars").val("");
    $("#description").val("");
}

function cleanDataSave(){
    $("#name").val("");
    $("#hotel").val("");
    $("#stars").val("");
    $("#description").val("");
}


// Petición POST
function save(){
    /* Con esta función guardamos los valores ingresados haciendo uso
    del consumo de nuestra api.
    */

    let room = {
        name: $("#name").val(),
        hotel: $("#hotel").val(),
        stars: $("#stars").val(),
        description: $("#description").val()
    }

    let dataJson = JSON.stringify(room)
    $.ajax({
        url: endpoint + "/save",
        type: "POST",
        data: dataJson,
        contentType: "application/json",
        complete: function(data) {
            if (data.status == "201") {
                //console.log("Guardado")
                alert("Guardo Registro Habitación con exito!!")
                cleanDataSave()
            } else {
                //console.log("Error")
                alert("Problemas al Insertar consulta al Administrador!!")
            }
        }
    })

}

// Petición GET
function get() {
    /* Con esta función pretendemos obtener la cantidad de registros guardados como
    su información (haciendo uso de api), esto también mostrandolos por pantalla haciendo uso de una tabla
    por parte de nuestro documento HTML
    */

    let tam = 0;
    $.ajax({
        url: endpoint + "/all",
        type: "GET",
        dataType: "json",
        success: function(data) {
            let tam = data.length
            if (tam == 0) {
                $("#contenedor").hide() // No mostramos nuestra tabla si no hay registros
                $("#mensaje").show() // enviamos un mensaje para indicar esto
            } else {
                $("#contenedor").show()
                $("#mensaje").hide()
                $("#numregistro").html("Numero de Registros: " + tam)
                //console.log(data)
                let registro = ""
                $.each(data, function(index, room) {
                    /* Obtenemos la informaición de nuestro registro y lo guardamos como un
                    String para luego mostrarlo en #tbody → (Table) 
                     */

                    registro += "<tr>" +
                        "<td>" + room.id + "</td>" +
                        "<td>" + room.name + "</td>" +
                        "<td>" + room.hotel + "</td>" +
                        "<td>" + room.stars + "</td>" +
                        "<td>" + room.description + "</td>" +
                        "<td><button data-bs-toggle='modal'data-bs-target='#modalactualizar' class='btn btn-warning'>Update</button> <button class='btn btn-danger' onclick='deleteById(" + room.id + ")'>Eliminar</button></td>"
                    "</tr>"
                })
                //console.log(registro)
                $("#tbody").html(registro) // llevamos la información a nuestra tabla
            }
        }
    })
}



// Petición PUT
function update() {
    /* Con esta función actualizamos lo valores que obtenemos en nuestro modal 
    → (documento HTML) y lo enviamos consumiendo nuestra api
    */

    let room = {

        id: $("#id").val(),
        name: $("#name").val(),
        hotel: $("#hotel").val(),
        stars: $("#stars").val(),
        description: $("#description").val()

    }

    let dataJson = JSON.stringify(room)
    $.ajax({
        url: endpoint + "/update",
        type: "PUT",
        data: dataJson,
        contentType: "application/json",
        complete: function(data) {
            if (data.status == "201") {
                //console.log("Guardado")
                alert("Se actualizo Registro Habitación con exito!!")
                cleanDataUpdate()
                get()
                
            } else {
                console.log("Error")
                alert("Problemas al Insertar consulta al Administrador!!")
            }
        }
    })

}


// Petición Delete
function deleteById(id) {
    /* Eliminamos alguno de nuestros registros esto haciendo de la id que obtenemos
    automaticamente en nuestra función get y consumiendo nuestra api.
    */

    $.ajax({
            url: endpoint + "/" + id,
            type: 'DELETE',
            dataType: 'json',
            contentType: 'application/json',
            complete: function() {
                alert("Registro eliminado")
                cleanDataDelete()
                get()
                
            }
    })

}
