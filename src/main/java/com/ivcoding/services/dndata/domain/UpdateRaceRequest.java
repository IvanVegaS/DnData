package com.ivcoding.services.dndata.domain;

import java.util.List;

import com.ivcoding.services.dndata.domain.races.Description;
import com.ivcoding.services.dndata.domain.races.Feature;
import com.ivcoding.services.dndata.domain.races.Modifier;
import com.ivcoding.services.dndata.domain.races.Relationships;
import com.ivcoding.services.dndata.domain.races.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UpdateRaceRequest {
	private String type;
	private String name;
	private List<Modifier> modifiers;
	private List<Description> descriptions;
	private List<Feature> features;
	private Size size;
	private String age;
	private String alignment;
	private List<String> languages;
	private List<String> subraces;
	private Relationships relationships;

	public UpdateRaceRequest() {
		this.modifiers = null;
		this.descriptions = null;
		this.features = null;
		this.languages = null;
		this.subraces = null;
	}
}
