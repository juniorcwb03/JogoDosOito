package main;

import model.Tabuleiro;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		 Scanner entrada = new Scanner(System.in);	
         
      try {
    	   do{ 
    			 System.out.println("\n Menu: \n 1-Iniciar Jogo \n 2-Movimentar numero \n 5-Sair ");
    		  tabuleiro.setOp(entrada.nextInt());
    		  switch(tabuleiro.getOp()){
    		  	
    		          case 1:
    		        
    		        tabuleiro.iniciarTabuleiro();
    		         System.out.println("\nJogo Iniciado,tabuleiro embaralhado");
    		          tabuleiro.mostrarTabuleiro();
    		                break;
    		          case 2: 
    		          System.out.println("\n Movimentar numero");
    		          System.out.println("Digite qual numero deseja movimentar :");
    		          tabuleiro.setNumeroAMovimento(entrada.nextInt());
    		          tabuleiro.buscaPosicaoNumero(tabuleiro.getNumeroAMovimento());
    		          
    		          if(tabuleiro.buscaPosicaoNumero(tabuleiro.getNumeroAMovimento())) {
    		          System.out.println("\nDigite para qual posição quer movimentar ? \nOBS : lembrando que deve digital o numero da linha e da coluna. \n");
    		          System.out.println("Digite o numero da linha \n");
    		          tabuleiro.setLinha(entrada.nextInt());
    		          System.out.println("Digite o numero da coluna \n");
    		          tabuleiro.setColuna(entrada.nextInt());
    		          
    		          tabuleiro.movimentarNumero(tabuleiro);
    		          }
    		          System.out.println("Tabuleiro :");
    		          tabuleiro.mostrarTabuleiro();
    		          System.out.println("\n");
    		          tabuleiro.setOp(tabuleiro.getNumeroAMovimento());
    		          
    		          		break;
    		          case 5: System.out.println("fim");
    		          		break;
    		          default : System.out.println("opcao invalida");
    		          		break;
    		  }
    		  	}while(tabuleiro.getOp()!=5);
		
	} catch (Exception e) {
		System.out.println("Opção digitada incorretamente !!");
	}   
 
    
}	

	}