package co.edu.uptc.laguito.repository;

import co.edu.uptc.laguito.domain.Patient;
import java.util.HashMap;
import java.util.HashSet;

public class PatientRepository {

	private HashMap<Integer, Patient> patients;
	private HashSet<String> registeredEmails;
	public PatientRepository(HashMap<Integer, Patient> patients, HashSet<String> registeredEmails) {
		super();
		this.patients = new HashMap<>();
		this.registeredEmails = new HashSet<>();
	}
	
	public boolean addPatient(Patient patient) {
		if(patients.containsKey(patient.getIdPatient())) {
			return false;
		}
		if(!registeredEmails.add(patient.getEmail())) {
			return false;
		}
		patients.put(patient.getIdPatient(), patient);
		return true;
	}
	
	public HashMap<Integer, Patient> findAll(){
		return patients;
	}
	
	public Patient findById(Integer idPatient) {
		return patients.get(idPatient);
	}
	
	public boolean addMedication(Integer idPatient, String medication) {
		Patient patient = findById(idPatient);
		if(patient == null) {
			return false;
		}
		return patient.getMedicationHistory().add(medication);
	}

}
