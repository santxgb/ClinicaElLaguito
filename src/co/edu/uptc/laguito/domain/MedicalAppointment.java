package co.edu.uptc.laguito.domain;

import java.time.LocalTime;
import java.util.Objects;

public class MedicalAppointment {
	
	private Integer idMedicalAppointment;
	private LocalTime timeAppointment;
	private Patient patient;
	private Doctor doctor;
	public MedicalAppointment() {
		
	}
	public MedicalAppointment(Integer idMedicalAppointment, LocalTime timeAppointment, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppointment = idMedicalAppointment;
		this.timeAppointment = timeAppointment;
		this.patient = patient;
		this.doctor = doctor;
	}
	public Integer getIdMedicalAppointment() {
		return idMedicalAppointment;
	}
	public void setIdMedicalAppointment(Integer idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}
	public LocalTime getTimeAppointment() {
		return timeAppointment;
	}
	public void setTimeAppointment(LocalTime timeAppointment) {
		this.timeAppointment = timeAppointment;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@Override
	public boolean equals(Object obj) {
		MedicalAppointment aux = (MedicalAppointment) obj;
		return this.idMedicalAppointment.equals(aux.getIdMedicalAppointment());
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.idMedicalAppointment);
	}
	@Override
	public String toString() {
		return "MedicalAppointment [idMedicalAppointment=" + idMedicalAppointment + ", timeAppointment="
				+ timeAppointment + ", patient=" + patient.getFirstName() + " " + patient.getLastName() + 
				", doctor=" + doctor.getFirstName() + " " + doctor.getLastName() + "]";
	}
	
}
