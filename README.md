# Algoritmo de Kruskal

Esta aplicação possui a implementação do [Algoritmo de Kruskal](https://pt.wikipedia.org/wiki/Algoritmo_de_Kruskal) para geração da árvore mínima, fazendo uso da biblioteca: http://jgrapht.org/ para gerar uma representação gráfica do resultado.

1) Como resultado da execução, terá a escrita no console onde é apresentado: 

 > Caminho 
 
 > Arestas Selecionadas
 
 > Custo total da árvore.
 
 > Ex: ([a, b, c, d, e], [(d,e), (b,c), (a,b), (c,e)]) Z = 213
 

2) Representação gráfica da Árvore Mínima.

<html>
	<img src="https://github.com/fernandogodoy/algoritmo-kruskal/blob/master/print.PNG"/>

</html>

# Arquivo de configuração:
A arvore mínima é gerada com base no arquivo: https://github.com/fernandogodoy/algoritmo-kruskal/blob/master/src/main/resources/kruskal

Este arquivo deve conter representação das florestas, onde cada linha representa uma árvore contendo: 
 > Origem (,) Destino (-) Peso

 > Ex: A,B-120
