package conta_bancaria.model;

// Herdando a classe conta
public class ContaCorrente extends Conta {
	
	//Parametro limite, especifico da classe conta corrente
	private float limite;
	
	//metodo contrutor que herda a classe Conta / O super pega os atributos da classe Conta 
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo,float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	public float getLimite() {
		return limite;
	}
	
	public void setLimite(float limite) {
		this.limite = limite;
	}

	
	
	@Override
	public boolean sacar(float valor) {
		
		if(this.getSaldo() + this.getLimite() < valor ) {
			System.out.println("\nSaldo Insuficiente");
			return false;	
			}
		
		this.setSaldo(this.getSaldo() - valor);
		
			
		
		if(this.getSaldo() < 0) {
			this.setLimite(this.getLimite()+this.getSaldo());
			this.setSaldo(0);
		}
		return true;
				
	}
	
	@Override
	public void depositar(float valor) {
		if(this.getLimite() < 2000) {			
			this.setLimite(this.getLimite() + valor);
		}
		if(this.getLimite() > 2000) {
			 this.setSaldo(this.getSaldo() + (valor-2000));
			 this.setLimite(2000);			 	
		}
		if(this.getLimite() == 2000)
			this.setSaldo(this.getSaldo() + valor);
			this.setLimite(0);
		
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite da Conta: " + this.limite);
	}
}

