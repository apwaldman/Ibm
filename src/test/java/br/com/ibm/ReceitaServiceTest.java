package br.com.ibm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import br.com.ibm.domain.Arquivo;
import br.com.ibm.services.ReceitaService;

class ReceitaServiceTest {
	Arquivo arquivoContasDadosCorretos = new Arquivo();
	Arquivo arquivoContasDadosIncorretos = new Arquivo();
	ReceitaService ReceitaService = new ReceitaService();
	
	@BeforeEach
	public void setup() {		
		arquivoContasDadosCorretos.setAgencia("0001");
		arquivoContasDadosCorretos.setConta("000001");
		arquivoContasDadosCorretos.setSaldo(0.01);
		arquivoContasDadosCorretos.setStatus("A");
		
		arquivoContasDadosIncorretos.setAgencia("001");
		arquivoContasDadosIncorretos.setConta("00001");
		arquivoContasDadosIncorretos.setSaldo(0.01);		
		arquivoContasDadosIncorretos.setStatus("C");
	}

	/* 
	 Regras:
	 Formato agencia deve possuir 4 dígitos (ex.:0000).Se null ou diferente de 4 ocorre erro.
     Formato conta deve possuir 6 dígitos (ex.:000000). Se null ou diferente de 6 ocorre erro.
     Tipos de status validos: A, I, B, P. Se null ou diferente, ocorre erro
    */
	
	@Test
	public void validaContaDadosCorretos() throws RuntimeException, InterruptedException  {
		assertTrue(ReceitaService.atualizarConta(arquivoContasDadosCorretos.getAgencia(), arquivoContasDadosCorretos.getConta(), arquivoContasDadosCorretos.getSaldo(), arquivoContasDadosCorretos.getStatus()));
		assertEquals(arquivoContasDadosCorretos.getAgencia().length(), (4));
		assertEquals(arquivoContasDadosCorretos.getConta().length(), (6));
		assertEquals(arquivoContasDadosCorretos.getStatus(), ("A"));		
	}

	@Test
	public void validaContaDadosIncorretos() throws RuntimeException, InterruptedException  {
		assertFalse(ReceitaService.atualizarConta(arquivoContasDadosIncorretos.getAgencia(), arquivoContasDadosIncorretos.getConta(), arquivoContasDadosIncorretos.getSaldo(), arquivoContasDadosIncorretos.getStatus()));
		assertNotEquals(arquivoContasDadosIncorretos.getAgencia().length(), (4));
		assertNotEquals(arquivoContasDadosIncorretos.getConta().length(), (6));
		assertNotEquals(arquivoContasDadosIncorretos.getStatus(), ("A"));		
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void validaDadosNulos() throws Exception {
	    expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Employee ID is null");
	    ReceitaService.atualizarConta(null, null, 0.01, null);
	}
	
}
