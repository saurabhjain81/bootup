package hello;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/employees")
	public List<CustomerForm> getEmployees() {
		Iterable<Customer> employees = repository.findAll();

		List<CustomerForm> employeeForm = new ArrayList<>();
		for (Customer employee : employees) {
			CustomerForm form = new CustomerForm();
			form.setFirstName(employee.getFirstName());
			form.setLastName(employee.getLastName());
			form.setId(employee.getId());
			form.setGroup(employee.getGroupName());

			employeeForm.add(form);

		}

		return employeeForm;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<CustomerForm> getEmployee(@RequestParam(value = "lastName") String lastName) {
		Iterable<Customer> employees = repository.findByLastName(lastName);

		List<CustomerForm> employeeForm = new ArrayList<>();
		for (Customer employee : employees) {
			CustomerForm form = new CustomerForm();
			form.setFirstName(employee.getFirstName());
			form.setLastName(employee.getLastName());
			form.setId(employee.getId());
			form.setGroup(employee.getGroupName());

			employeeForm.add(form);

		}

		return employeeForm;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String create(@Valid CustomerForm customerForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "create";
		}

		repository.save(new Customer(customerForm.getFirstName(), customerForm.getLastName(), customerForm.getGroup()));
		model.addAttribute(customerForm);
		return "success";
	}
}
