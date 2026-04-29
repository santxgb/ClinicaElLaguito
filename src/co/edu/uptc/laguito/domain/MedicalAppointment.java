package co.edu.uptc.laguito.domain;

import java.time.LocalTime;
import java.util.Objects;

/**
 * <b>Descripción: </b> Clase de modelo que representa
 * la información de una cita médica en el sistema <br>
 *
 * @author Santiago
 */
public class MedicalAppointment {
	
	/** Atributo que determina el id de la cita médica */
	private Integer idMedicalAppointment;
	
	/** Atributo que determina la hora de la cita médica */
	private LocalTime timeAppointment;
	
	/** Atributo que determina la información del paciente asociado a la cita */
	private Patient patient;
	
	/** Atributo que determina la información del médico asociado a la cita */
	private Doctor doctor;
	
	/**
     * <b>Descripción: </b> Constructor vacío de la clase
     */
	public MedicalAppointment() {
		
	}
	
	/**
     * <b>Descripción: </b> Constructor de la clase <br>
     * @param idMedicalAppointment Parámetro que determina el identificador de la cita
     * @param timeAppointment Parámetro que determina la hora de la cita
     * @param patient Parámetro que determina el paciente de la cita
     * @param doctor Parámetro que determina el médico de la cita
     */
	public MedicalAppointment(Integer idMedicalAppointment, LocalTime timeAppointment, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppointment = idMedicalAppointment;
		this.timeAppointment = timeAppointment;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	/**
     * <b>Descripción: </b> Retorna el identificador de la cita médica <br>
     * @return idMedicalAppointment Identificador de la cita médica
     */
	public Integer getIdMedicalAppointment() {
		return idMedicalAppointment;
	}
	
	/**
     * <b>Descripción: </b> Asigna el identificador de la cita médica <br>
     * @param idMedicalAppointment Nuevo identificador de la cita médica
     */
	public void setIdMedicalAppointment(Integer idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}
	
	/**
     * <b>Descripción: </b> Retorna la hora de la cita médica <br>
     * @return timeAppointment Hora de la cita médica
     */
	public LocalTime getTimeAppointment() {
		return timeAppointment;
	}
	
	/**
     * <b>Descripción: </b> Asigna la hora de la cita médica <br>
     * @param timeAppointment Nueva hora de la cita médica
     */
	public void setTimeAppointment(LocalTime timeAppointment) {
		this.timeAppointment = timeAppointment;
	}
	
	/**
     * <b>Descripción: </b> Retorna la información del paciente asociado a la cita <br>
     * @return patient Información del paciente
     */
	public Patient getPatient() {
		return patient;
	}
	
	/**
     * <b>Descripción: </b> Asigna la información del paciente asociado a la cita <br>
     * @param patient Nueva información del paciente
     */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
     * <b>Descripción: </b> Retorna la información del médico asociado a la cita <br>
     * @return doctor Información del médico
     */
	public Doctor getDoctor() {
		return doctor;
	}
	
	/**
     * <b>Descripción: </b> Asigna la información del médico asociado a la cita <br>
     * @param doctor Nueva información del médico
     */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	/**
     * <b>Descripción: </b> Compara dos citas médicas por su identificador <br>
     * @param obj Objeto a comparar
     * @return true si las citas tienen el mismo ID, false en caso contrario
     */
	@Override
	public boolean equals(Object obj) {
		MedicalAppointment aux = (MedicalAppointment) obj;
		return this.idMedicalAppointment.equals(aux.getIdMedicalAppointment());
	}
	
	/**
     * <b>Descripción: </b> Genera el código hash de la cita basado en su identificador <br>
     * @return Código hash de la cita médica
     */
	@Override
	public int hashCode() {
		return Objects.hash(this.idMedicalAppointment);
	}
	
	/**
     * <b>Descripción: </b> Retorna una representación en texto de la cita médica <br>
     * @return String con los datos de la cita médica
     */
	@Override
	public String toString() {
		return "MedicalAppointment [idMedicalAppointment=" + idMedicalAppointment + ", timeAppointment="
				+ timeAppointment + ", patient=" + patient.getFirstName() + " " + patient.getLastName() + 
				", doctor=" + doctor.getFirstName() + " " + doctor.getLastName() + "]";
	}
	
}
