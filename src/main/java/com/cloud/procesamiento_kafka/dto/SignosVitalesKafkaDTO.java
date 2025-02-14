package com.cloud.procesamiento_kafka.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SignosVitalesKafkaDTO {
    
    private Long id;
    private Long pacienteId;
    private Double frecuenciaCardiaca;
    private Double frecuenciaRespiratoria;
    private Double presionSistolica;
    private Double presionDiastolica;
    private Double temperatura;
    private Double saturacionOxigeno;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS")
    private LocalDateTime fechaRegistro;

    public SignosVitalesKafkaDTO() {
    }

    // Constructor
    public SignosVitalesKafkaDTO(Long id, Long pacienteId, Double frecuenciaCardiaca, 
            Double frecuenciaRespiratoria, Double presionSistolica, 
            Double presionDiastolica, Double temperatura, 
            Double saturacionOxigeno, LocalDateTime fechaRegistro) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
        this.temperatura = temperatura;
        this.saturacionOxigeno = saturacionOxigeno;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Double getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(Double frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public Double getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(Double presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public Double getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(Double presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    public void setSaturacionOxigeno(Double saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
}
