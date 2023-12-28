document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('filtroButton').addEventListener('click', function () {
        var input = document.getElementById('filtroInput').value.toLowerCase();
        var tableRows = document.querySelectorAll('.table tbody tr');
        var noResultados = true;

        tableRows.forEach(function (row) {
            var visible = false;
            var cells = row.getElementsByTagName('td');

            Array.from(cells).forEach(function (cell) {
                if (cell.textContent.toLowerCase().includes(input)) {
                    visible = true;
                    noResultados = false;
                }
            });

            if (visible) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });

        if (noResultados) {
            document.getElementById('mensajeNoResultados').style.display = 'block';
        } else {
            document.getElementById('mensajeNoResultados').style.display = 'none';
        }
    });

    document.getElementById('mostrarTodoButton').addEventListener('click', function () {
        var tableRows = document.querySelectorAll('.table tbody tr');
        tableRows.forEach(function (row) {
            row.style.display = ''; // Mostrar todas las filas
        });

        document.getElementById('mensajeNoResultados').style.display = 'none';
    });
});
