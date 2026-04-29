package co.edu.uptc.laguito.domain;

import co.edu.uptc.laguito.enums.IdentificationType;
import co.edu.uptc.laguito.enums.Priority;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * <b>Descripción: </b> Clase de modelo que representa
 * la información de un paciente en el sistema <br>
 *
 * @author Santiago
 */

public class Patient {
	
		/** Atributo que determina el tipo de identificación del paciente */
	 	private IdentificationType identificationType;
	 	
	 	/** Atributo que determina el id del paciente */
	    private Integer idPatient;
	    
	    /** Atributo que determina el nombre del paciente */
	    private String firstName;
	    
	    /** Atributo que determina los apellidos del paciente */
	    private String lastName;
	    
	    /** Atributo que determina el email del paciente */
	    private String email;
	    
	    /** Atributo que determina el historial de medicamentos recetados al paciente */
	    private LinkedHashSet<String> medicationHistory;
	    
	    /** Atributo que determina la prioridad de atención del paciente */
	    private Priority priority;
	    
	    /**
	     * <b>Descripción: </b> Constructor vacío de la clase
	     */
	    public Patient() {
	    	this.medicationHistory = new LinkedHashSet<>();
	    }
	    
	    /**
	     * <b>Descripción: </b> Constructor de la clase <br>
	     * @param identificationType Parámetro que determina el tipo de identificación
	     * @param idPatient Parámetro que determina el número de identificación
	     * @param firstName Parámetro que determina el nombre del paciente
	     * @param lastName Parámetro que determina los apellidos del paciente
	     * @param email Parámetro que determina el correo electrónico
	     * @param priority Parámetro que determina la prioridad de atención
	     */
		public Patient(IdentificationType identificationType, int idPatient, String firstName, String lastName,
				String email, LinkedHashSet<String> medicationHistory, Priority priority) {
			super();
			this.identificationType = identificationType;
			this.idPatient = idPatient;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.priority = priority;
			this.medicationHistory = new LinkedHashSet<>();
		}
		
		/**
	     * <b>Descripción: </b> Retorna el tipo de identificación del paciente <br>
	     * @return identificationType Tipo de identificación del paciente
	     */
		public IdentificationType getIdentificationType() {
			return identificationType;
		}
		
		/**
	     * <b>Descripción: </b> Asigna el tipo de identificación del paciente <br>
	     * @param identificationType Nuevo tipo de identificación
	     */
		public void setIdentificationType(IdentificationType identificationType) {
			this.identificationType = identificationType;
		}
		
		/**
	     * <b>Descripción: </b> Retorna el número de identificación del paciente <br>
	     * @return idPatient Número de identificación del paciente
	     */
		public Integer getIdPatient() {
			return idPatient;
		}
		
		/**
	     * <b>Descripción: </b> Asigna el número de identificación del paciente <br>
	     * @param idPatient Nuevo número de identificación
	     */
		public void setIdPatient(Integer idPatient) {
			this.idPatient = idPatient;
		}
		
		/**
	     * <b>Descripción: </b> Retorna el nombre del paciente <br>
	     * @return firstName Nombre del paciente
	     */
		public String getFirstName() {
			return firstName;
		}
		
		/**
	     * <b>Descripción: </b> Asigna el nombre del paciente <br>
	     * @param firstName Nuevo nombre del paciente
	     */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		/**
	     * <b>Descripción: </b> Retorna los apellidos del paciente <br>
	     * @return lastName Apellidos del paciente
	     */
		public String getLastName() {
			return lastName;
		}
		
		/**
	     * <b>Descripción: </b> Asigna los apellidos del paciente <br>
	     * @param lastName Nuevos apellidos del paciente
	     */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		/**
	     * <b>Descripción: </b> Retorna el correo electrónico del paciente <br>
	     * @return email Correo electrónico del paciente
	     */
		public String getEmail() {
			return email;
		}
		
		/**
	     * <b>Descripción: </b> Asigna el correo electrónico del paciente <br>
	     * @param email Nuevo correo electrónico
	     */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
	     * <b>Descripción: </b> Retorna el historial de medicamentos del paciente <br>
	     * @return medicationHistory Historial de medicamentos
	     */
		public LinkedHashSet<String> getMedicationHistory() {
			return medicationHistory;
		}
		
		/**
	     * <b>Descripción: </b> Asigna el historial de medicamentos del paciente <br>
	     * @param medicationHistory Nuevo historial de medicamentos
	     */
		public void setMedicationHistory(LinkedHashSet<String> medicationHistory) {
			this.medicationHistory = medicationHistory;
		}
		
		/**
	     * <b>Descripción: </b> Retorna la prioridad de atención del paciente <br>
	     * @return priority Prioridad de atención
	     */
		public Priority getPriority() {
			return priority;
		}
		
		/**
	     * <b>Descripción: </b> Asigna la prioridad de atención del paciente <br>
	     * @param priority Nueva prioridad de atención
	     */
		public void setPriority(Priority priority) {
			this.priority = priority;
		}
		
		/**
		 * <b>Descripción: </b> Compara dos pacientes por su número de identificación <br>
		 * @param obj Objeto a comparar
		 * @return true si los pacientes tienen el mismo ID, false en caso contrario
		 */
		@Override
	    public boolean equals(Object obj) {
	        Patient auxPatient = (Patient) obj;
	        return this.idPatient.equals(auxPatient.getIdPatient());
	    }
		
		/**
		 * <b>Descripción: </b> Genera el código hash del paciente basado en su ID <br>
		 * @return Código hash del paciente
		 */
		@Override 
		public int hashCode() {
			return Objects.hash(this.idPatient);
		}
		
		/**
		 * <b>Descripción: </b> Retorna una representación en texto del paciente <br>
		 * @return String con los datos del paciente
		 */
		@Override
		public String toString() {
			return "Patient [identificationType=" + identificationType + ", idPatient=" + idPatient + ", firstName="
					+ firstName + ", lastName=" + lastName + ", email=" + email + ", priority=" + priority + "]";
		}
	    
	    
}
