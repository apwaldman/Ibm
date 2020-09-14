package br.com.ibm.domain;

public class Arquivo {

	private String agencia;
	private String conta;
	private double saldo;
	private String status;
	private String resultado;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Arquivo: agencia=" + agencia + ", conta=" + conta + ", saldo=" + saldo + ", status=" + status
				+ ", resultado=" + resultado ;
	}
	
	
}
