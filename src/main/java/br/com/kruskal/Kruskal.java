package br.com.kruskal;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.alg.util.UnionFind;

/**
 * 
 * @author Fernando
 *
 */
public class Kruskal {

	private static final Pattern REGEX = Pattern.compile("(.*),(.*)-(.*)");
	private Arvore arvoreMinima = new Arvore();

	public static void main(String[] args) {
		Kruskal kruskal = new Kruskal();
		kruskal.execute();
		kruskal.printConsole();
		kruskal.printJFrame();
	}

	private void printConsole() {
		Printer printer = new ConsolePrinter(arvoreMinima);
		printer.print();
	}

	private void printJFrame() {
		Printer printer = new JFramePrinter(arvoreMinima);
		printer.print();
	}

	public void execute() {
		Arvore floresta = readFile();
		UnionFind<Vertice> unionFind = new UnionFind<>(floresta.getVertices());
		for (Aresta aresta : floresta.getOrdened()) {
			unionFind.union(aresta.getOrigem(), aresta.getDestino());
			if (unionFind.find(aresta.getOrigem()) == unionFind.find(aresta.getDestino())) {
				arvoreMinima.add(aresta);
			}
		}
	}

	public Arvore readFile() {
		Path path = getPath();
		Arvore arvore = new Arvore();
		try (Scanner scanner = new Scanner(path.toFile())) {
			while (scanner.hasNext()) {
				Matcher matcher = REGEX.matcher(scanner.next().trim());
				if (matcher.find()) {
					Aresta aresta = new Aresta(matcher.group(1), matcher.group(2), matcher.group(3));
					arvore.add(aresta);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arvore;
	}

	private Path getPath() {
		try {
			return Paths.get(ClassLoader.getSystemResource("kruskal").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Arvore getArvore() {
		return arvoreMinima;
	}
}
