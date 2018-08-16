package hello;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import hello.taggedInterfaces.First;
import hello.taggedInterfaces.Second;

@GroupSequence({ First.class, Second.class, PersonForm.class })
public class PersonForm {

    @NotBlank( message = "{empty.name}", groups= First.class)
    @Pattern( regexp = "[ A-Za-z ]", message = "{invalid.name}", groups= Second.class )
    private String name;

    
    @NotBlank( message = "{empty.email}", groups= First.class )
    @Email( message = "{invalid.email}", groups= Second.class )
    private String email;
    
    @NotNull( message = "{empty.age}", groups= First.class )
    @Min(value=18, message = "{invalid.age}", groups= Second.class )
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ", Email: "+ this.email + ")";
    }
}
