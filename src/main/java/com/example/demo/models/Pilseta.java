package com.example.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

public class Pilseta {
	@Column(name="IdPi")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idPi;
	@Column(name="Nosaukums")
	@NotNull
	@Size(min = 3 , max = 30)
	@Pattern(regexp="[A-Z]{1}[a-z]+", message = "Jabut pirmajam lielajam burtam, un parejie var but mazie")
	private String nosaukums;

	@Column(name="Novads")
	private Novads novads;
	
	@Column(name="IedzivotajuSkaits")
	@Min(1)
	@Max(10000000)	
	private int iedzivotajuSkaits;
	
	
	@OneToMany(mappedBy = "pilseta")
	@ToString.Exclude
	private Collection<Kandidats> kandidatuSaraksts;


	public Pilseta(
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Jabut pirmajam lielajam burtam, un parejie var but mazie") String nosaukums,
			Novads novads, @Min(1) @Max(10000000) int iedzivotajuSkaits) {
	setNosaukums(nosaukums);
	setNovads(novads);
	setIedzivotajuSkaits(iedzivotajuSkaits);

	}
	
	
}
