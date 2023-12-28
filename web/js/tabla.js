
function filtrarPorNombre(nombreFiltrado, ueasList) {
    // Convierte el nombre filtrado a minúsculas para hacer una comparación insensible a mayúsculas
    const nombreFiltradoLowerCase = nombreFiltrado.toLowerCase();

    // Filtra las UEAs por el nombre
    const ueasFiltradas = ueasList.filter(uea =>
        uea.nombre.toLowerCase().includes(nombreFiltradoLowerCase)
    );

    return ueasFiltradas;
}


function filtrarTabla() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("filtroInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("tablaUEA");
    tr = table.getElementsByTagName("tr");

    var found = false; // Variable para rastrear si se encuentra alguna coincidencia

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        if (td.length > 0) {
            var selectedFilter = document.getElementById("filtroSelect").value;
            var tdContent = td[0].textContent || td[0].innerText;

            if (selectedFilter === 'nombre') {
                txtValue = td[1].textContent || td[1].innerText;
            } else {
                txtValue = tdContent;
            }

            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
                found = true; // Al menos una coincidencia encontrada
            } else {
                tr[i].style.display = "none";
            }


        }
    }

    // Si no se encontraron coincidencias, oculta la tabla completa
    if (!found) {
        table.style.display = 'none';
    } else {
        table.style.display = 'table';
    }
}







function mostrarDetalles(clave, nombre, trimestre, requisito, dias, lugar, hora) {
    var detallesTexto = document.getElementById('detallesTexto');
    detallesTexto.innerHTML = `
       <h3>${nombre} </h3>
        <p><strong>Clave:</strong> ${clave}</p>
        <p><strong>Trimestre:</strong> ${trimestre}</p>
        <p><strong>Requisito:</strong> ${requisito}</p>
        <p><strong>dias:</strong> ${dias}</p>
    <p><strong>lugar:</strong> ${lugar}</p>
       <p><strong>hora:</strong> ${hora}</p>
    `;

    var cuadroDetalles = document.getElementById('cuadroDetalles');
    cuadroDetalles.style.display = 'block';
}


function ocultarDetalles() {
    var cuadroDetalles = document.getElementById('cuadroDetalles');
    cuadroDetalles.style.display = 'none';
}

// Esta sección del código maneja el arrastre del cuadro (draggable)
// Puedes adaptarla si deseas la funcionalidad de arrastrar el cuadro




$(document).ready(function () {
    $('.mostrarDetallesBtn').click(function (event) {
        event.preventDefault(); // Evita la acción predeterminada del botón
        var clave = $(this).data('clave');
        var nombre = $(this).data('nombre');
        var trimestre = $(this).data('trimestre');
        var requisito = $(this).data('requisito');
        var dias = $(this).data('dias');
         var lugar = $(this).data('lugar');
         var hora = $(this).data('hora');
        mostrarDetalles(clave, nombre, trimestre, requisito, dias, lugar, hora);
    });

    // Evento para cerrar el cuadro de detalles al hacer clic en "Cerrar"
    $('#cuadroDetalles button').click(function () {
        ocultarDetalles();
    });
});









function consultarAsignatura() {
    var input, filtro, celdasClave, textoValor;
    input = document.getElementById('filtroInput');
    filtro = input.value.toUpperCase();
    var tipoFiltro = document.getElementById('filtroSelect').value;

    celdasClave = document.querySelectorAll('.clave');

    // Itera sobre las celdas de Clave y verifica si coincide con el filtro
    for (var i = 0; i < celdasClave.length; i++) {
        textoValor = celdasClave[i].textContent || celdasClave[i].innerText;

        if (textoValor.toUpperCase() === filtro) {
            // Aquí puedes realizar acciones con la asignatura seleccionada
            // Por ejemplo, mostrar un cuadro con toda la información
            // o redirigir a una página de detalles de la asignatura
            var nombreAsignatura = document.querySelector('.nombre:nth-child(' + (i + 1) + ')').textContent.trim();
            alert("Consulta de asignatura: " + nombreAsignatura);
            // Puedes modificar esta sección para realizar acciones específicas con la asignatura seleccionada
            break; // Detener el bucle al encontrar la asignatura
        }
    }
}