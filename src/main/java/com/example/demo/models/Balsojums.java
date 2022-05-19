package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

public class Balsojums {
	@Column(name="IdB")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idB;
	
	@Column(name="Balsis")
	@Min(0)
	@Max(10000000)	
	private int balsis;
	
	@OneToOne(mappedBy = "balsojums")
	@ToString.Exclude
	private Kandidats kandidats;

	public Balsojums(@Min(0) @Max(10000000) int balsis, Kandidats kandidats) {
		setBalsis(balsis);
		setKandidats(kandidats);
	}
	
	
	
}
