package com.example.teamb4spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USERS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "USERS_SEQ", initialValue = 1, allocationSize = 1)
@SuperBuilder
public class User extends BaseModel {
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{email.pattern}")
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@NotNull(message = "{firstname.null}")
	@Column(length = 20, nullable = false)
	private String firstname;

	@NotNull
	@Column(length = 50, nullable = false)
	private String lastname;

	@NotNull
	@Column(length = 50, nullable = false)
	private String address;

	@Min(value = 18)
	@Max(value = 120)
	private Integer age;
}
