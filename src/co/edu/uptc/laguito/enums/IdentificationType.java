package co.edu.uptc.laguito.enums;

public enum IdentificationType {
    CC("Cédula de ciudadanía"),
    TI("Tarjeta de identidad"),
    CE("Cédula de extranjería"),
    PA("Pasaporte");

	private final String officialName;

	private IdentificationType(String officialName) {
		this.officialName = officialName;
	}

	public String getOfficialName() {
		return officialName;
	}

}
