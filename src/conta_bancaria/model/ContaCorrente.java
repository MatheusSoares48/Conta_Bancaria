package conta_bancaria.model;

// Herdando a classe conta
public class ContaCorrente extends Conta {

	// Parametro limite, especifico da classe conta corrente
	private float limite;

	// metodo contrutor que herda a classe Conta / O super pega os atributos da
	// classe Conta
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {

		// Atualiza o limite caso o saldo seja negativo
		if (this.getSaldo() < 0)
			return this.limite - Math.abs(this.getSaldo());

		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {

		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		
		return true;
	}

	

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite da Conta: " + this.limite);
	}
}
