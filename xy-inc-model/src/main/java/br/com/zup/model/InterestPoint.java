package br.com.zup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class InterestPoint {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "O nome do ponto de interesse deve ser informado.")
	@Size(max = 100, message = "O nome do ponto de interesse deve conter no máximo 100 caracteres.")
	private String name;

	@Min(value = 0, message = "A coordenada 'x' do ponto de interesse deve ser maior que zero.")
	private int x;

	@Min(value = 0, message = "A coordenada 'y' do ponto de interesse deve ser maior que zero.")
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
	
	@Override
	public String toString() {
		return "[name = " + name + ", x =" + x + ", y = " + y + "]";
	}
}
