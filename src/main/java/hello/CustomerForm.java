package hello;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import hello.taggedInterfaces.First;
import hello.taggedInterfaces.Second;

@GroupSequence({ First.class, Second.class, CustomerForm.class })
public class CustomerForm {

    @NotBlank( message = "{empty.firstName}", groups= First.class)
    @Pattern( regexp = "[ A-Za-z ]", message = "{invalid.firstName}", groups= Second.class )
    private String firstName;

    @NotBlank( message = "{empty.lastName}", groups= First.class)
    @Pattern( regexp = "[ A-Za-z ]", message = "{invalid.lastName}", groups= Second.class )
    private String lastName;
    
    private Long id;


    @NotBlank( message = "{empty.group}", groups= First.class)
    @Pattern( regexp = "[ A-Za-z ]", message = "{invalid.group}", groups= Second.class )
    private String group;
    
    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}



	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}



	public String toString() {
        return "Person(Name: " + this.firstName + this.lastName + ")";
    }
}
