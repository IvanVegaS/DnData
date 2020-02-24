package com.ivcoding.services.dndata.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "races")
public class RaceCollection {
	@Id
	private String id;
	private String type;
	private String name;
	private List<Modifier> modifiers;
	private List<Description> descriptions;
	private List<Feature> features;
	private String speed;
	private Size size;
	private String age;
	private String alignment;
	private List<String> languages;
	private List<String> subraces;
	private Relationships relationships;
	private LocalDateTime createdDate;

	public RaceCollection() {
		this.modifiers = new ArrayList<>();
		this.descriptions = new ArrayList<>();
		this.features = new ArrayList<>();
		this.languages = new ArrayList<>();
		this.subraces = new ArrayList<>();
		this.createdDate = LocalDateTime.now();
	}

	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Modifier {
		private String ability;
		private Integer value;
	}

	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Description {
		private String title;
		private String text;
	}

	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Feature {
		private String name;
		private String description;
	}

	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Size {
		private String value;
		private String description;
	}

	@Getter
	@Setter
	@ToString
	@AllArgsConstructor
	public static class Relationships {
		private List<String> allies;
		private List<String> enemies;

		public Relationships() {
			this.allies = new ArrayList<>();
			this.enemies = new ArrayList<>();
		}
	}
}
