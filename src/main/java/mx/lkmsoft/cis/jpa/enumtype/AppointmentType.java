package mx.lkmsoft.cis.jpa.enumtype;

public enum AppointmentType {
	FIRST("appointment.type.first.time"),
	SUBSEQUENT("appointment.type.subsequent"),
	CONTROL("appointment.type.control"),
	EPISODIC("appointment.type.episodic");
	
	private final String value;

	AppointmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public AppointmentType fromValue(String v) {
        return valueOf(v);
    }
}