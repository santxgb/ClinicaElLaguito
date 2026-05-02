package co.edu.uptc.laguito.repository;

import co.edu.uptc.laguito.domain.Doctor;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * <b>Descripción: </b> Clase repositorio que gestiona el almacenamiento
 * y consulta de los médicos del sistema <br>
 *
 * @author Santiago
 */

public class DoctorRepository {
	
	/** Atributo que determina el mapa de médicos registrados en el sistema */
	private HashMap<Integer, Doctor> doctors;

	/**
     * <b>Descripción: </b> Constructor de la clase
     */
	public DoctorRepository() {
		super();
		this.doctors = new HashMap<>();
	}
	
	/**
     * <b>Descripción: </b> Agrega un médico al sistema validando que no exista
     * un registro con el mismo identificador <br>
     * @param doctor Parámetro que determina el médico a registrar
     * @return true si el médico fue registrado, false si el identificador ya existe
     */
	public boolean addDoctor(Doctor doctor) {
		if(doctors.containsKey(doctor.getMedicalId())) {
			return false;
		}
		doctors.put(doctor.getMedicalId(), doctor);
		return true;
	}
	
	/**
     * <b>Descripción: </b> Retorna todos los médicos registrados en el sistema <br>
     * @return HashMap con todos los médicos registrados
     */
	public HashMap<Integer, Doctor> findAll(){
		return doctors;
	}
	
	/**
     * <b>Descripción: </b> Busca y retorna un médico por su número de identificación médica <br>
     * @param medicalId Parámetro que determina el número de identificación médica
     * @return El médico encontrado, o null si no existe
     */
	public Doctor findById(Integer medicalId) {
		return doctors.get(medicalId);
	}
	
}
