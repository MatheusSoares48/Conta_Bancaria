package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Criar a Collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variável para receber o numero da Conta
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional <Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodas() {
		if (listaContas.isEmpty())
			System.out.println("Não há Contas criadas.");
		else {
			for (var conta : listaContas) {
				conta.visualizar();
			}
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A Conta numero: " + conta.getNumero() + " foi criada com Sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
				System.out.println("A Conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("A Conta número: " + conta.getNumero() + " não foi encontrada!");


	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A Conta número: " + numero + " foi excluída com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");

	}

	@Override
	public void sacar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.println("O Saque na Conta : " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");


	}

	@Override
	public void depositar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.println("O Deposito da Conta : " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");


	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor) == true)
				contaDestino.get().depositar(valor);
				System.out.println("A Transferencia da Conta : " + numeroOrigem + " para a conta " + numeroDestino
						          + " foi efetuada com sucesso!");
		} else
			System.out.println("A Conta de Origem e/ou Destino não foram encontrada!");

	}

	/* Métodos Auxiliares */

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}
}