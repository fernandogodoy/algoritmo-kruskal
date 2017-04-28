package br.com.kruskal.util;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.kruskal.model.Aresta;
import br.com.kruskal.model.Arvore;

public class FileUtil {

	private static final Pattern REGEX = Pattern.compile("(.*),(.*)-(.*)");

	public static Arvore readFile() {
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
		return arvore.toOrder();
	}

	private static Path getPath() {
		try {
			return Paths.get(ClassLoader.getSystemResource("kruskal").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}