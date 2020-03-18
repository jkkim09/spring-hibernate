package com.hibernate.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="thirdparty_user_info")
public class ThirdpartyUserVO {
	@Id
	private Integer identification_number;
	private Integer user_number;
	@NotNull @NotBlank
	private String user_thirdparty_type;
}
