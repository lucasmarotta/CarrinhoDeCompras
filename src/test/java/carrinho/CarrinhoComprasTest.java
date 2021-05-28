package carrinho;


import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carrinho.CarrinhoCompras;

class CarrinhoComprasTest {
	
	private CarrinhoCompras carrinhoVazio;
	private CarrinhoCompras carrinhoCheio; //Total = 50.0
	private double totalCheio;

	@BeforeEach
	void setUp() throws Exception {
		this.carrinhoVazio = new CarrinhoCompras();
		this.carrinhoCheio = new CarrinhoCompras();
		carrinhoCheio.adicionarItem(10.0, 1);
		carrinhoCheio.adicionarItem(20.0, 2);
		totalCheio = carrinhoCheio.getTotal();
	}

	@Test
	void carrinhoVazio() {
		double total = carrinhoVazio.getTotal();
		assertEquals(0.0, total);
	}
	
	@Test
	void adicionaUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(10.0, 1); 
		});
		
		double total = carrinhoVazio.getTotal();
		assertEquals(10.0, total);
	}
	
	@Test
	void adicionaDoisItensDiferentes() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(10.0, 1);
			carrinhoVazio.adicionarItem(20.0, 1);			
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(30.0, total);
	}
	
	@Test
	void adicionaDoisDoMesmoItem() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(20.0, 2);
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(40.0, total);
	}
	
	@Test
	void adicionaUmItemDuasVezes() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(20.0, 1);
			carrinhoVazio.adicionarItem(20.0, 1);
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(40.0, total);
	}
	
	@Test
	void adicionaZeroDeUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(20.0, 0);
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(0.0, total);
	}
	
	@Test
	void adicionaQuantidadeNegativa() {	
		assertThrows(
				ImpossivelAdicionarException.class, 
				() -> { carrinhoVazio.adicionarItem(10.0, -1); }
		);
		double total = carrinhoVazio.getTotal();
		assertEquals(0.0, total);
	}
	
	@Test
	void removeUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(10.0, 1);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(40.0, total);
	}
	
	@Test
	void removeDoisItensDiferentes() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(10.0, 1);
			carrinhoCheio.removerItem(20.0, 1);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(20.0, total);
	}
	
	@Test
	void removeDoisDoMesmoItem() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(20.0, 2);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(10.0, total);
	}
	
	@Test
	void removeUmItemDuasVezes() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(20.0, 1);
			carrinhoCheio.removerItem(20.0, 1);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(10.0, total);
	}
	
	@Test
	void removeZeroDeUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(20.0, 0);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(50.0, total);
	}
	
	@Test
	void removeValorMaiorQueTotal() {	
		assertThrows(
				ImpossivelRemoverException.class, 
				() -> { carrinhoCheio.removerItem(20.0, 3); }
		);
		double total = carrinhoCheio.getTotal();
		assertEquals(50.0, total);
	}
	
	@Test
	void removeQuantidadeNegativa() {	
		assertThrows(
				ImpossivelRemoverException.class, 
				() -> { carrinhoCheio.removerItem(10.0, -1); }
		);
		double total = carrinhoCheio.getTotal();
		assertEquals(50.0, total);
	}
	
	////Remove item inexistente
	////Remove mais de um item que o contido
	
}
