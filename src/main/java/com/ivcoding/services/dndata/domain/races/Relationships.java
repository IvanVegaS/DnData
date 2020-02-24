package com.ivcoding.services.dndata.domain.races;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Relationships {
	private List<String> allies;
	private List<String> enemies;

	public Relationships() {
		this.allies = new ArrayList<>();
		this.enemies = new ArrayList<>();
	}
}