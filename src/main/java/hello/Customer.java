// tag::sample[]
package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    private String groupName; 
    //have to follow naming convention of varName, it converts to table column var_name
    
    protected Customer() {}

    public Customer(String firstName, String lastName, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

// end::sample[]

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
}

