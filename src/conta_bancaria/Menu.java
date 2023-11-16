package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opçao;

		System.out.print(Cores.TEXT_RED_BOLD_BRIGHT+
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
				         + "*******************************************************"
				         + "\nEntre com a opção desejada: ");
		opçao = leia.nextInt();
	}
	

}
