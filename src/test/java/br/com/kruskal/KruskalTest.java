package br.com.kruskal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class KruskalTest {

	Kruskal kruskal;

	@Before
	public void init() {
		kruskal = new Kruskal();
	}

	@Test
	public void lerArquivoTest() throws Exception {
		Arvore arvore = kruskal.readFile();
		assertNotNull(arvore);
		assertEquals(9, arvore.getArestas().size());
	}

	@Test
	public void verticesTest() throws Exception {
		kruskal.execute();
		assertEquals(5, kruskal.getArvore().getVertices().size());
	}

	@Test
	public void getMenorPesoTest() throws Exception {
		kruskal.execute();
		assertEquals(BigDecimal.valueOf(50), kruskal.getArvore().getOrdened().get(0).getPeso());
	}

	@Test
	public void arvoreMinimaTest() throws Exception {
		kruskal.execute();
		assertEquals(4, kruskal.getArvore().getArestas().size());
	}
}
