package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Kandidats {
	@Column(name="IdK")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idK;
	
	
	@Column(name="Vards")
	@NotNull
	@Size(min = 3 , max = 30)
	@Pattern(regexp="[A-Z]{1}[a-z]+", message = "Jabut pirmajam lielajam burtam, un parejie var but mazie")
	private String vards;
	
	@Column(name="Uzvards")
	@NotNull
	@Size(min = 3 , max = 30)
	@Pattern(regexp="[A-Z]{1}[a-z]+", message = "Jabut pirmajam lielajam burtam, un parejie var but mazie")
	private String uzvards;

	@ManyToOne
	@JoinColumn(name = "IdPa")
	private Partija partija;
	
	@ManyToOne
	@JoinColumn(name = "IdPi")
	private Pilseta pilseta;
	
	@OneToOne
	@JoinColumn(name = "IdB")
	private Balsojums balsojums;

	public Kandidats(
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Jabut pirmajam lielajam burtam, un parejie var but mazie") String vards,
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Jabut pirmajam lielajam burtam, un parejie var but mazie") String uzvards,
			Partija partija) {
		setVards(vards);
		setUzvards(uzvards);
		setPartija(partija);
	}
	
	
	
}
