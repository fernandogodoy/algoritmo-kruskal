package br.com.kruskal;

import java.util.Objects;

/**
 * Representação de um Vertice
 * 
 * @author Fernando
 *
 */
public class Vertice implements Comparable<Vertice> {

	private String id;

	public Vertice(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Vertice)) {
			return false;
		}
		Vertice castOther = (Vertice) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return id;
	}

	@Override
	public int compareTo(Vertice o) {
		return this.id.compareTo(o.id);
	}
}
