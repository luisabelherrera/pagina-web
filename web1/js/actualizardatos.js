function agregarUsuario() {
    $.ajax({
        type: 'POST',
        url: 'agregarUsuario', 
        success: function() {
           
            $.ajax({
                type: 'GET',
                url: 'obtenerUsuarios', 
                dataType: 'json',
                success: function(data) {

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
}
