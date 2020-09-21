package br.com.ibm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import br.com.ibm.domain.Arquivo;
import br.com.ibm.services.ReceitaService;

class ReceitaServiceTest {
	/* 
	 Regras:
	 Formato agencia deve possuir 4 dígitos (ex.:0000).Se null ou diferente de 4 ocorre erro.
     Formato conta deve possuir 6 dígitos (ex.:000000). Se null ou diferente de 6 ocorre erro.
     Tipos de status validos: A, I, B, P. Se null ou diferente, ocorre erro
   */
	Arquivo DadosCorretos = new Arquivo();
	Arquivo DadosIncorretos = new Arquivo();
	Arquivo DadosNulos = new Arquivo();
	ReceitaService ReceitaService = new ReceitaService();
	
	@BeforeEach
	public void setup() {		
		DadosCorretos.setAgencia("0001");
		DadosCorretos.setConta("000001");		
		DadosCorretos.setStatus("A");
		
		DadosIncorretos.setAgencia("001");
		DadosIncorretos.setConta("00001");				
		DadosIncorretos.setStatus("C");
		
		DadosNulos.setAgencia(null);
		DadosNulos.setConta(null);				
		DadosNulos.setStatus(null);		
	}

		
	@Test
	public void validaContaDadosCorretos() throws RuntimeException, InterruptedException  {
		assertTrue(ReceitaService.atualizarConta(DadosCorretos.getAgencia(), DadosCorretos.getConta(), DadosCorretos.getSaldo(), DadosCorretos.getStatus()));
		assertEquals(DadosCorretos.getAgencia().length(), (4));
		assertEquals(DadosCorretos.getConta().length(), (6));
		assertEquals(DadosCorretos.getStatus(), ("A"));		
	}

	@Test
	public void validaContaDadosIncorretos() throws RuntimeException, InterruptedException  {
		assertFalse(ReceitaService.atualizarConta(DadosIncorretos.getAgencia(), DadosIncorretos.getConta(), DadosIncorretos.getSaldo(), DadosIncorretos.getStatus()));
		assertNotEquals(DadosIncorretos.getAgencia().length(), (4));
		assertNotEquals(DadosIncorretos.getConta().length(), (6));
		assertNotEquals(DadosIncorretos.getStatus(), ("A"));		
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void validaDadosNulos() throws Exception {
	    expectedEx.expect(RuntimeException.class);	    
	    ReceitaService.atualizarConta(DadosNulos.getAgencia(), DadosNulos.getConta(), DadosNulos.getSaldo(), DadosNulos.getResultado());
	}
	
}
