package br.com.kruskal.printer;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import br.com.kruskal.model.Aresta;
import br.com.kruskal.model.Arvore;
import br.com.kruskal.model.Vertice;

/**
 * 
 * @author Fernando
 *
 */
public class JFramePrinter extends JApplet implements Printer {
	private static final long serialVersionUID = 1L;

	private JGraphXAdapter<Vertice, DefaultEdge> jgAdapter;
	private static final Dimension DEFAULT_SIZE = new Dimension(500, 400);

	private Arvore arvore;
	private JFrame frame = new JFrame();
	private ListenableGraph<Vertice, DefaultEdge> grafo = new DefaultListenableGraph<>(
			new DefaultDirectedGraph<>(DefaultEdge.class));

	public JFramePrinter(Arvore arvore) {
		this.init();
		this.arvore = arvore;
	}

	@Override
	public void init() {
		jgAdapter = new JGraphXAdapter<>(grafo);
		getContentPane().add(new mxGraphComponent(jgAdapter));
		resize(DEFAULT_SIZE);
	}

	@Override
	public void print() {

		for (Vertice vertice : arvore.getVertices()) {
			grafo.addVertex(vertice);
		}
		for (Aresta aresta : arvore.getArestas()) {
			grafo.addEdge(aresta.getOrigem(), aresta.getDestino());
		}
		mxCircleLayout layout = new mxCircleLayout(jgAdapter);
		layout.execute(jgAdapter.getDefaultParent());

		jframeConfig();
	}

	private void jframeConfig() {
		frame.getContentPane().add(this);
		frame.setTitle("Árvore Mínima - Algoritmo de Kruskal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(DEFAULT_SIZE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
