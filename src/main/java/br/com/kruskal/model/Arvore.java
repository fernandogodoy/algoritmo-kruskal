package br.com.kruskal.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arvore {

	private Set<Aresta> arestas = new HashSet<>();
	private Set<Vertice> vertices = new HashSet<>();

	private final List<Aresta> ordened = new ArrayList<>();

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
		if (ordened.isEmpty()) {
			toOrder();
		}
		return ordened;
	}

	@Override
	public String toString() {
		return "Arvore [" + arestas + "], size: " + arestas.size();
	}

	public Arvore toOrder() {
		List<Aresta> list = new ArrayList<>(arestas);
		Collections.sort(list);
		this.ordened.addAll(list);
		return this;
	}

}
