package webtest.model;

public class GuestBookEntry {
	private Long id;
	private String name, specialties, presentation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialties() {
		return specialties;
	}

	public void setSpecialties(String specialties) {
		this.specialties = specialties;
	}
	
	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GuestBookEntry [id=" + id + ", name=" + name + ", specialties=" + specialties + ", presentation="
				+ presentation + "]";
	}
	
	


	
	
	

}