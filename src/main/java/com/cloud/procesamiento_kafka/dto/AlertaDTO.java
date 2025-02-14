package com.cloud.procesamiento_kafka.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AlertaDTO {

    private String mensaje; // Mensaje de alerta descriptivo
    private String tipo; // Tipo de alerta (e.g., "frecuencia cardiaca crítica", "hipotermia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS")
    private LocalDateTime fechaGeneracion; // Fecha y hora en que se generó la alerta
    private Boolean atendida; // Indica si la alerta ha sido gestionada
    private String severidad; //Severidad de la alerta (Leve, Moderado, Crítico)
    private Long pacienteId;
    private Long signoVitalId;
    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
    public Boolean getAtendida() {
        return atendida;
    }
    public void setAtendida(Boolean atendida) {
        this.atendida = atendida;
    }
    public String getSeveridad() {
        return severidad;
    }
    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }
    public Long getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    public Long getSignoVitalId() {
        return signoVitalId;
    }
    public void setSignoVitalId(Long signoVitalId) {
        this.signoVitalId = signoVitalId;
    }

    
}
