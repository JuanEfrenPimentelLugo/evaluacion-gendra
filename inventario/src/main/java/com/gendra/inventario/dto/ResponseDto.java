package com.gendra.inventario.dto;

public class ResponseDto {

    private Integer estatus;
    private String mensaje;
    private Object objeto; 
    
    public ResponseDto(Integer estatus, String mensaje) {
        this(estatus, mensaje, null);
    }
    
    public ResponseDto(Integer estatus, String mensaje, Object object) {
        this.estatus = estatus;
        this.mensaje = mensaje;
        this.objeto = object;
    }

    public Integer getEstatus() {
        return estatus;
    }
    
    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
}
