package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao;
		
		/*Criar Objetos da Classe Conta para testes*/
		
		Conta c1 = new Conta(1, 123, 1, "Victória Moraes", 100000.00f);
		c1.visualizar();
		System.out.println("Exibir saldo: " + c1.getSaldo());
		c1.setSaldo(200000.00f);
		c1.visualizar();
		c1.depositar(1000.00f);
		
		ContaCorrente cc1 = new ContaCorrente(3,456,1,"Felipe", 100000.00f,2000.00f);
		cc1.visualizar();
		cc1.sacar(102000.00f);
		cc1.visualizar();
		cc1.depositar(2000.00f);
		cc1.visualizar();
		
		ContaPoupanca c2 = new ContaPoupanca(3,678,2,"Matheus",100000.00f,2);
		c2.visualizar();
		
		while (true) {
		
		System.out.print(Cores.TEXT_RED_BOLD_BRIGHT+Cores.ANSI_BLACK_BACKGROUND+
						   "*******************************************************\n"
				         + "§               BANCO GENERATION BRAZIL               §\n"
				         + "*******************************************************\n"
				         + "|                                                     |\n"
				         + "|             1 - Criar Conta                         |\n"
				         + "|             2 - Listar todas as contas              |\n"
				         + "|             3 - Buscar Conta por Numero             |\n"
				         + "|             4 - Atualizar Dados da Conta            |\n"
				         + "|             5 - Apagar Conta                        |\n"
				         + "|             6 - Sacar                               |\n"
				         + "|             7 - Depositar                           |\n"
				         + "|             8 - Transferir valores entre Contas     |\n"
				         + "|             9 - Sair                                |\n"
				         + "|                                                     |\n"
				         + "*******************************************************");
		
		System.out.print(Cores.TEXT_RED_BOLD_BRIGHT+"\nEntre com a opção desejada: ");
		opcao = leia.nextInt();
		
		System.out.println("\n");
		
		if(opcao == 9) {
			System.out.println("Programa finalizado!");
			System.exit(opcao);
		}
		switch(opcao){
			case 1:
				System.out.println("Criar Conta\n");
				break;
			case 2:
				System.out.println("Listar todas as contas");
				break;
			case 3:
				System.out.println("Buscar Conta por Numero");
				break;
			case 4:
				System.out.println("Atualizar Dados da Conta");
				break;
			case 5:
				System.out.println("Apagar Conta");
				break;
			case 6:
				System.out.println("Sacar");
				break;
			case 7:
				System.out.println("Depositar");
				break;
			case 8:
				System.out.println("Transferir valores entre Contas");
				break;
			
				
			}
		}
		
	}
	

}
