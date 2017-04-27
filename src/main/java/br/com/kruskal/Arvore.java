package br.com.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arvore {

	private Set<Aresta> arestas = new HashSet<>();
	private Set<Vertice> vertices = new HashSet<>();

	public final Set<Aresta> getArestas() {
		return arestas;
	}

	public final Set<Vertice> getVertices() {
		return vertices;
	}

	public void add(Aresta aresta) {
		this.arestas.add(aresta);
		this.vertices.add(aresta.getOrigem());
		this.vertices.add(aresta.getDestino());
	}

	public List<Aresta> getOrdened() {
		List<Aresta> list = new ArrayList<>(arestas);
		Collections.sort(list);
		return list;
	}

	@Override
	public String toString() {
		return "Arvore [" + arestas + "], size: " + arestas.size();
	}

}
