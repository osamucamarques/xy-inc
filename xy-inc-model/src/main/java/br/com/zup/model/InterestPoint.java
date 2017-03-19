package br.com.zup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class InterestPoint {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Max(100)
	private String name;

	@NotNull
	private int x;

	@NotNull
	private int y;

	public InterestPoint(String name2, int x2, int y2) {
		this.name = name2;
		this.x = x2;
		this.y = y2;
	}

	public InterestPoint() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
