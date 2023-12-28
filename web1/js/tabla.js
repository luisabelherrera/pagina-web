
function filtrarPorNombre(nombreFiltrado, ueasList) {
 
    const nombreFiltradoLowerCase = nombreFiltrado.toLowerCase();

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

    var found = false; 

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
                found = true; 
            } else {
                tr[i].style.display = "none";
            }


        }
    }

    if (!found) {
        table.style.display = 'none';
    } else {
        table.style.display = 'table';
    }
}

function mostrarTabla() {

    document.getElementById('selectorTabla').style.display = 'none';

    document.getElementById('contenidoTabla').style.display = 'block';


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


$(document).ready(function () {
    $('.mostrarDetallesBtn').click(function (event) {
        event.preventDefault();
        var clave = $(this).data('clave');
        var nombre = $(this).data('nombre');
        var trimestre = $(this).data('trimestre');
        var requisito = $(this).data('requisito');
        var dias = $(this).data('dias');
        var lugar = $(this).data('lugar');
        var hora = $(this).data('hora');
        mostrarDetalles(clave, nombre, trimestre, requisito, dias, lugar, hora);
    });

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

    for (var i = 0; i < celdasClave.length; i++) {
        textoValor = celdasClave[i].textContent || celdasClave[i].innerText;

        if (textoValor.toUpperCase() === filtro) {
  
            var nombreAsignatura = document.querySelector('.nombre:nth-child(' + (i + 1) + ')').textContent.trim();
            alert("Consulta de asignatura: " + nombreAsignatura);
        
            break; 
        }
    }
}