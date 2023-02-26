package com.gendra.inventario.util;

public enum ResponseType {
    UI_PROCESS_OK(200, "Operación realizada con éxito."), 
    UI_PROCESS_ERROR_NOT_FOUND(404, "No se encontró el elemento."),
    UI_PROCESS_ERROR(400, "Ocurrio un error en el proceso, intentelo nuevamente."),
    UI_PROCESS_ERROR_FK(400, "No es posible eliminar el registro debido a que ya tiene referencias."),
    UI_LOGIN_OK(200, "Sesión creada satisfactoriamente.");

    private Integer estatus;
    private String descripcion;

    private ResponseType(Integer estatus, String descripcion) {
        this.estatus = estatus;
        this.descripcion = descripcion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
