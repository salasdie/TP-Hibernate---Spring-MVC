package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne
    private Ubicacion ubicacionGeografica;
    @ManyToOne
    private Pais pais;

	public Ciudad(String nombre, Ubicacion ubicacionGeografica, Pais pais) {
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
		this.pais = pais;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ubicacion getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(Ubicacion ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
