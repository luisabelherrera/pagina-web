function agregarUsuario() {
    $.ajax({
        type: 'POST',
        url: 'agregarUsuario', // Ruta para agregar el usuario (usar la correcta)
        success: function() {
            // Hacer una solicitud para obtener los datos actualizados
            $.ajax({
                type: 'GET',
                url: 'obtenerUsuarios', // Ruta para obtener los usuarios actualizados
                dataType: 'json',
                success: function(data) {
                    // Actualizar la tabla con los datos obtenidos
                    // Ejemplo: Limpiar la tabla y volver a cargar los datos
                    actualizarTabla(data);
                },
                error: function(error) {
                    console.error('Error al obtener datos actualizados:', error);
                }
            });
        },
        error: function(error) {
            console.error('Error al agregar usuario:', error);
        }
    });
}

function actualizarTabla(data) {
    // Actualizar la tabla con los datos obtenidos
    // Recorrer 'data' para mostrar los usuarios en tu tabla HTML
}
