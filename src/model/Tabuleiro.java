package model;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Tabuleiro {

	int linha;
	int coluna;
	int numeroAMovimento;
	int contMovimento = 0;
	int op;
	int linhaNumero;
	int colunaNumero;


	Random random = new Random();
	Set<Integer> numeroSemRepetir = new HashSet<>(); 
	/*
	 * get e setters atributos
	 */
	
	public int getOp() {
		return op;
	}


	public void setOp(int op) {
		this.op = op;
	}
	
	public int getLinhaNumero() {
		return linhaNumero;
	}


	public void setLinhaNumero(int linhaNumero) {
		this.linhaNumero = linhaNumero;
	}


	public int getColunaNumero() {
		return colunaNumero;
	}


	public void setColunaNumero(int colunaNumero) {
		this.colunaNumero = colunaNumero;
	}
	
	public int getNumeroAMovimento() {
		return numeroAMovimento;
	}


	public void setNumeroAMovimento(int numeroAMovimento) {
		this.numeroAMovimento = numeroAMovimento;
	}
	
	public int getLinha() {
		return linha;
	}


	public void setLinha(int linha) {
		this.linha = linha;
	}


	public int getColuna() {
		return coluna;
	}


	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public int[][] getTabuleiroEspaco() {
		return tabuleiroEspaco;
	}


	public void setTabuleiroEspaco(int[][] tabuleiroEspaco) {
		this.tabuleiroEspaco = tabuleiroEspaco;
	}

	/*
	 * Alocando espaço no tabuleiro (matriz 3x3)
	 */
	private int tabuleiroEspaco[][] = new int[3][3];

	/*
	 * Atribuindo valor aleatorio a matriz
	 */

	public void iniciarTabuleiro() {
		tabuleiroEspaco = new int[3][3];
		    for (int i = 0; i <3; i++) {
		        for (int j = 0; j <3; j++) {
		            int numero;
		            do {
		                numero = random.nextInt(9);
		                if(j == 2 && i == 2) {
		                	numero  = 0;
		                	break;
		                	
		                }
		            } while (numeroJaExiste(numero, tabuleiroEspaco));
		            
		            tabuleiroEspaco[i][j] = numero;
		            
		        }
		    }

		}
	
	public Tabuleiro(int linha,int coluna) {
		this.coluna = coluna;
		this.linha = linha;
	}

	public Tabuleiro() {

	}

/*
 * verifica se o numero adcionado ja existe na matriz
 */

private static boolean numeroJaExiste(int numero, int[][] tabuleiroEspaco) {
    for (int i = 0; i <3; i++) {
        for (int j = 0; j <3; j++) {
            if (tabuleiroEspaco[i][j] == numero) {
                return true;
        }
    }
    }
    return false;
}

	/*
	 * Mostra matriz preenchida
	 */

	public void mostrarTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(tabuleiroEspaco[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * Procurar numero a movimentar
	 */
	
	public boolean buscaPosicaoNumero(int numero) {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(tabuleiroEspaco[i][j] == numero) {
					
					setLinhaNumero(i);
					setColunaNumero(j);
					return true;
					
				}
				
				
			}
		}
		System.out.println("Numero não encontrado,tente novamente");
		return false;
	}
	
	/*
	 * Metodo responsavel por movimentar numero,verificar se é possivel
	 */

	public void movimentarNumero(Tabuleiro tabu) {
		try {
			contMovimento++;
			if(contMovimento <=4) {
				if(tabuleiroEspaco[tabu.getLinha()][tabu.getColuna()] == 0) {
					tabuleiroEspaco[tabu.getLinha()][tabu.getColuna()] = getNumeroAMovimento();
					tabuleiroEspaco[tabu.getLinhaNumero()][tabu.getColunaNumero()] = 0;
				}else {
					System.out.println("Só é possivel movimentar o numero para o campo com valor 0,tente novamente ");
				}
			}else {
				System.out.println("Voce ja movimentou 4 vezes,jogo encerrado");
				contMovimento = 5;
			}
			
		} catch (Exception e) {
			System.out.println("LInha ou coluna digitada fora do existente, deve ser Digitado linha entre 0 a 2 e coluna entre 0 a 2 \n");
		}
		
	}
		
}
