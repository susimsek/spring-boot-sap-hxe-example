package io.susimsek.saphxeexample.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;

	@NotBlank
	@Column(name ="firstName", nullable = false)
	String firstName;

	@NotBlank
	@Column(name ="lastName", nullable = false)
	String lastName;

	@Email
	@NotBlank
	@Column(name ="email", unique=true)
	String email;
}