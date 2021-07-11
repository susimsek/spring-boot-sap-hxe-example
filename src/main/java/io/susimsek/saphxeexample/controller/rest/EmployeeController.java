package io.susimsek.saphxeexample.controller.rest;

import io.susimsek.saphxeexample.domain.Employee;
import io.susimsek.saphxeexample.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;

@Log4j2
@Tag(name = "Employee", description = "Retrieve and manage employees")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {

	final EmployeeServiceImpl employeeService;

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = long.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Get total number of employees")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/employees/count")
	public long count() {
		log.info("Search total number of employees");
		return employeeService.getCount();
	}

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok",content = @Content(array = @ArraySchema(schema = @Schema(implementation = Employee.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Get all employees")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		log.info("Searching all employees");
		return employeeService.findAllEmployee();
	}

	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "Created",content = @Content(schema = @Schema(implementation = Employee.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Create new employee")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		log.info("Creation Employee - "+employee.toString());
		return employeeService.insertEmployee(employee);
	}

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = Employee.class))),
			@ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Get existing employee by id")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/employees/{id}" )
	public Employee findById(@PathVariable long id) {
		log.info("Searching employee with ID - "+ id);
		return employeeService.findEmployeeById(id);
	}

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = Employee.class))),
			@ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Update existing employee by id")
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable long id, @Valid @RequestBody Employee employee)
			throws URISyntaxException {
		log.info("request to update Employee with ID : {}, {}", id, employee);
		return employeeService.updateEmployee(id,employee);
	}

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = Employee.class))),
			@ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Partial update given fields of an existing employee by id")
	@PatchMapping(value = "/employees/{id}", consumes = "application/merge-patch+json")
	public Employee partialUpdateEmployee(@PathVariable long id, @NotNull @RequestBody Employee employee)
	{
		log.info("request to update Employee with ID : {}, {}", id, employee);
		return employeeService.partialUpdateEmployee(id,employee);
	}


	@ApiResponses({
			@ApiResponse(responseCode = "204", description = "No Content",content = @Content),
			@ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

	})
	@Operation(summary = "Delete existing employee by id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
	
}