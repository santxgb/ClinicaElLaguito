package co.edu.uptc.model;

public class Doctor implements Comparable<Doctor>{
	
	private IdentificationType identificationType;
    private int medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;
    
	public Doctor(IdentificationType identificationType, int medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}
    
    
	
}
