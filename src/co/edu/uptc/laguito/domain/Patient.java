package co.edu.uptc.laguito.domain;

import co.edu.uptc.laguito.enums.IdentificationType;
import co.edu.uptc.laguito.enums.Priority;
import java.util.LinkedHashSet;
import java.util.Objects;


public class Patient {
	
	 private IdentificationType identificationType;
	    private Integer idPatient;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private LinkedHashSet<String> medicationHistory;
	    private Priority priority;
	    
	    public Patient() {
	    	this.medicationHistory = new LinkedHashSet<>();
	    }
	    
	    
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
		public IdentificationType getIdentificationType() {
			return identificationType;
		}
		public void setIdentificationType(IdentificationType identificationType) {
			this.identificationType = identificationType;
		}
		public int getIdPatient() {
			return idPatient;
		}
		public void setIdPatient(int idPatient) {
			this.idPatient = idPatient;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LinkedHashSet<String> getMedicationHistory() {
			return medicationHistory;
		}
		public void setMedicationHistory(LinkedHashSet<String> medicationHistory) {
			this.medicationHistory = medicationHistory;
		}
		public Priority getPriority() {
			return priority;
		}
		public void setPriority(Priority priority) {
			this.priority = priority;
		}
		
		@Override
	    public boolean equals(Object obj) {
	        Patient auxPatient = (Patient) obj;
	        return this.idPatient.equals(auxPatient.getIdPatient());
	    }
		@Override 
		public int hashCode() {
			return Objects.hash(this.idPatient);
		}
		
		@Override
		public String toString() {
			return "Patient [identificationType=" + identificationType + ", idPatient=" + idPatient + ", firstName="
					+ firstName + ", lastName=" + lastName + ", email=" + email + ", medicationHistory="
					+ medicationHistory + ", priority=" + priority + "]";
		}
	    
	    
}
