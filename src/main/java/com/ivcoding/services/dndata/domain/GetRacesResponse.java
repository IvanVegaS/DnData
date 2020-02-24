package com.ivcoding.services.dndata.domain;

import java.util.ArrayList;
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

@Setter
@Getter
@ToString
@AllArgsConstructor
public class GetRacesResponse {
	private String id;
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

	public GetRacesResponse() {
		this.modifiers = new ArrayList<>();
		this.descriptions = new ArrayList<>();
		this.features = new ArrayList<>();
		this.languages = new ArrayList<>();
		this.subraces = new ArrayList<>();

	}

}
