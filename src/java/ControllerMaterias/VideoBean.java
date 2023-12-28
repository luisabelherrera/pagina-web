package ControllerMaterias;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VideoBean {
    private String rutaVideo;

    public VideoBean() {
        // Aquí puedes establecer la ruta del video
        rutaVideo = "../imagen/a.mp4"; // Ruta de ejemplo, debes ajustarla a tu estructura de proyecto
    }

    public String getRutaVideo() {
        return rutaVideo;
    }

    public void setRutaVideo(String rutaVideo) {
        this.rutaVideo = rutaVideo;
    }
}
