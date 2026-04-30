package co.edu.uptc.laguito.service;

import co.edu.uptc.laguito.domain.Patient;
import co.edu.uptc.laguito.repository.PatientRepository;
import java.util.HashMap;

public class PatientService {
	
	private PatientRepository patientRepository;

	public PatientService() {
		super();
		this.patientRepository = new PatientRepository();
	}
	
	private boolean validate(Patient patient) {
		if (patient.getFirstName() == null || patient.getFirstName().isBlank())
			return false;
		if (patient.getLastName() == null || patient.getLastName().isBlank())
			return false;
		if (patient.getEmail() == null || patient.getEmail().isBlank())
			return false;
		if (patient.getIdPatient() == null || patient.getIdPatient() <= 0)
			return false;
		return true;
	}
	
	public boolean addPatient(Patient patient) {
		if(!validate(patient)) {
			return false;
		}
		return patientRepository.addPatient(patient);
	}
	
	public HashMap<Integer, Patient> findAll(){
		return patientRepository.findAll();
	}
	
	public Patient findById(Integer idPatient) {
		return patientRepository.findById(idPatient);
	}
	
	public boolean addMedication(Integer idPatient, String medication) {
		if(medication == null || medication.isBlank()) {
			return false;
		}
		return patientRepository.addMedication(idPatient, medication);
	}
}
