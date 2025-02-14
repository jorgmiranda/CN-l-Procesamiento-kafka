package com.cloud.procesamiento_kafka.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cloud.procesamiento_kafka.dto.AlertaDTO;
import com.cloud.procesamiento_kafka.dto.SignosVitalesKafkaDTO;

public class EvaluadorSignosVitales {
    public static List<AlertaDTO> evaluarCriticidad(SignosVitalesKafkaDTO signosVitales) {
        List<AlertaDTO> alertas = new ArrayList<>();

        evaluarAlerta(alertas, signosVitales.getFrecuenciaCardiaca(), 50, 90, 120,
                "Frecuencia cardíaca", "bpm", "bradicardia", "frecuencia cardiaca elevada",
                "frecuencia cardiaca crítica", signosVitales);

        evaluarAlerta(alertas, signosVitales.getFrecuenciaRespiratoria(), 12, 16, 25,
                "Frecuencia respiratoria", "rpm", "bradipnea", "taquipnea moderada", "taquipnea severa", signosVitales);

        evaluarAlerta(alertas, signosVitales.getPresionSistolica(), 90, 120, 180,
                "Presión arterial sistólica", "mmHg", "hipotensión", "hipertensión moderada", "hipertensión severa",
                signosVitales);

        evaluarAlerta(alertas, signosVitales.getPresionDiastolica(), 60, 80, 120,
                "Presión arterial diastólica", "mmHg", "hipotensión", "hipertensión moderada", "hipertensión severa",
                signosVitales);

        evaluarAlerta(alertas, signosVitales.getTemperatura(), 35, 37.5, 39,
                "Temperatura", "°C", "hipotermia", "fiebre moderada", "hipertermia severa", signosVitales);

        evaluarAlerta(alertas, signosVitales.getSaturacionOxigeno(), 90, 95, 100,
                "Saturación de oxígeno", "%", "hipoxia leve", "hipoxia moderada", "hipoxia severa", signosVitales);

        return alertas.isEmpty() ? null : alertas;
    }

    private static void evaluarAlerta(List<AlertaDTO> alertas, double valor, double limiteBajo, double limiteNormal,
            double limiteAlto,
            String tipoSigno, String unidad, String tipoLeve, String tipoModerado, String tipoCritico,
            SignosVitalesKafkaDTO signosVitales) {
        String mensaje = null;
        String tipo = null;
        String severidad = null;

        if (valor < limiteBajo) {
            mensaje = tipoSigno + " baja: " + valor + " " + unidad + ". Posible " + tipoLeve + ".";
            tipo = tipoLeve;
            severidad = "crítico";
        } else if (valor >= limiteAlto) {
            mensaje = tipoSigno + " muy elevada: " + valor + " " + unidad + ". Posible " + tipoCritico + ".";
            tipo = tipoCritico;
            severidad = "crítico";
        } else if (valor > limiteNormal) {
            mensaje = tipoSigno + " elevada: " + valor + " " + unidad + ". Posible " + tipoModerado + ".";
            tipo = tipoModerado;
            severidad = "moderado";
        }

        if (mensaje != null) {
            AlertaDTO alerta = new AlertaDTO();
            alerta.setMensaje(mensaje);
            alerta.setTipo(tipo);
            alerta.setSeveridad(severidad);
            alerta.setFechaGeneracion(LocalDateTime.now());
            alerta.setAtendida(false);
            alerta.setPacienteId(signosVitales.getPacienteId());
            alerta.setSignoVitalId(signosVitales.getId());
            alertas.add(alerta);
        }
    }
}
