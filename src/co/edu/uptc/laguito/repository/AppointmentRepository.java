package co.edu.uptc.laguito.repository;

import co.edu.uptc.laguito.domain.MedicalAppointment;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * <b>Descripción: </b> Clase repositorio que gestiona el almacenamiento
 * y consulta de las citas médicas del sistema <br>
 *
 * @author Santiago
 */
public class AppointmentRepository {
	
	/** Atributo que determina el mapa de citas médicas registradas en el sistema */
	private HashMap<Integer, MedicalAppointment> appointments;
	
	/**
     * <b>Descripción: </b> Constructor de la clase
     */
	public AppointmentRepository() {
		this.appointments = new HashMap<>();
	}
	
	/**
     * <b>Descripción: </b> Agrega una cita médica al sistema validando que no exista
     * un registro con el mismo identificador <br>
     * @param appointment Parámetro que determina la cita médica a registrar
     * @return true si la cita fue registrada, false si el identificador ya existe
     */
	public boolean addAppointment(MedicalAppointment appointment) {
		if(appointments.containsKey(appointment.getIdMedicalAppointment())) {
			return false;
		}
		appointments.put(appointment.getIdMedicalAppointment(), appointment);
		return true;
	}
	
	/**
     * <b>Descripción: </b> Retorna todas las citas médicas registradas en el sistema <br>
     * @return HashMap con todas las citas médicas
     */
	public HashMap<Integer, MedicalAppointment> findAll(){
		return appointments;
	}
	
	/**
     * <b>Descripción: </b> Busca y retorna una cita médica por su identificador <br>
     * @param idMedicalAppointment Parámetro que determina el identificador de la cita
     * @return La cita médica encontrada, o null si no existe
     */
	public MedicalAppointment findById(Integer idMedicalAppointment) {
		return appointments.get(idMedicalAppointment);
	}
	
	/**
     * <b>Descripción: </b> Retorna todas las citas médicas ordenadas primero por hora
     * de atención y en caso de empate por mayor prioridad del paciente <br>
     * @return TreeSet con las citas médicas ordenadas
     */
	public TreeSet<MedicalAppointment> findAllByTimeAndPriority(){
		TreeSet<MedicalAppointment> orden = new TreeSet<>((a, b) ->{
			int byTime = a.getTimeAppointment().compareTo(b.getTimeAppointment());
			if(byTime == 0) {
				return Integer.compare(b.getPatient().getPriority().getValue(),
					a.getPatient().getPriority().getValue());
				}
				return byTime;
			});
		orden.addAll(appointments.values());
		return orden;
	}

}
