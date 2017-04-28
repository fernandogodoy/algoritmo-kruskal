package br.com.kruskal;

import org.jgrapht.alg.util.UnionFind;

import br.com.kruskal.model.Aresta;
import br.com.kruskal.model.Arvore;
import br.com.kruskal.model.Vertice;
import br.com.kruskal.printer.ConsolePrinter;
import br.com.kruskal.printer.JFramePrinter;
import br.com.kruskal.printer.Printer;
import br.com.kruskal.util.FileUtil;

/**
 * 
 * @author Fernando
 *
 */
public class Kruskal {

	private Arvore arvoreMinima = new Arvore();

	public static void main(String[] args) {
		Kruskal kruskal = new Kruskal();
		kruskal.execute();
		kruskal.printConsole();
		kruskal.printJFrame();
	}

	public void execute() {
		Arvore arvore = FileUtil.readFile();
		UnionFind<Vertice> unionFind = new UnionFind<>(arvore.getVertices());
		for (Aresta aresta : arvore.getOrdened()) {
			if (isCiclo(unionFind, aresta)) {
				arvoreMinima.add(aresta);
			}
		}
	}

	private boolean isCiclo(UnionFind<Vertice> unionFind, Aresta aresta) {
		unionFind.union(aresta.getOrigem(), aresta.getDestino());
		return unionFind.find(aresta.getOrigem()) == unionFind.find(aresta.getDestino());
	}

	private void printConsole() {
		Printer printer = new ConsolePrinter(arvoreMinima);
		printer.print();
	}

	private void printJFrame() {
		Printer printer = new JFramePrinter(arvoreMinima);
		printer.print();
	}

	public Arvore getArvore() {
		return arvoreMinima;
	}
}
