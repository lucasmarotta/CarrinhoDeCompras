package carrinho;


import static org.junit.jupiter.api.Assertions.*;

//import java.lang.reflect.Executable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carrinho.CarrinhoCompras;

class CarrinhoComprasTest {
	
	private final Item itemA = new Item(10.0); //NAO MUDAR
	private final Item itemB = new Item(20.0); //NAO MUDAR
	private final Item itemC = new Item(15.0); //NAO MUDAR
	private CarrinhoCompras carrinhoVazio;
	private CarrinhoCompras carrinhoCheio; 
	private final double totalVazio = 0.0;
	private double totalCheio;

	@BeforeEach
	void setUp() throws Exception {
		carrinhoVazio = new CarrinhoCompras();
		carrinhoCheio = new CarrinhoCompras();
		carrinhoCheio.adicionarItem(itemA, 1);
		carrinhoCheio.adicionarItem(itemB, 2);
		totalCheio = carrinhoCheio.getTotal();
	}

	@Test
	void carrinhoVazio() {
		double total = carrinhoVazio.getTotal();
		assertEquals(0.0, total);
	}
	
	@Test
	void carrinhoCheio() {
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio, total);
	}
	
	@Test
	void adicionaUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(itemA, 1); 
		});
		
		double total = carrinhoVazio.getTotal();
		assertEquals(10.0, total);
	}
	
	@Test
	void adicionaDoisItensDiferentes() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(itemA, 1);
			carrinhoVazio.adicionarItem(itemB, 1);			
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(30.0, total);
	}
	
	@Test
	void adicionaDoisDoMesmoItem() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(itemB, 2);
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(40.0, total);
	}
	
	@Test
	void adicionaUmItemDuasVezes() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(itemB, 1);
			carrinhoVazio.adicionarItem(itemB, 1);
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(40.0, total);
	}
	
	@Test
	void adicionaZeroDeUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoVazio.adicionarItem(itemB, 0);
		});
		double total = carrinhoVazio.getTotal();
		assertEquals(0.0, total);
	}
	
	@Test
	void adicionaQuantidadeNegativa() {	
		assertThrows(
				ImpossivelAdicionarException.class, 
				() -> { carrinhoVazio.adicionarItem(itemA, -1); }
		);
		double total = carrinhoVazio.getTotal();
		assertEquals(0.0, total);
	}
	
	@Test
	void removeUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(itemA, 1);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio - 10.0, total);
	}
	
	@Test
	void removeDoisItensDiferentes() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(itemA, 1);
			carrinhoCheio.removerItem(itemB, 1);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio - 30.0, total);
	}
	
	@Test
	void removeDoisDoMesmoItem() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(itemB, 2);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio - 40.0, total);
	}
	
	@Test
	void removeUmItemDuasVezes() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(itemB, 1);
			carrinhoCheio.removerItem(itemB, 1);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio - 40.0, total);
	}
	
	@Test
	void removeZeroDeUmItem() {
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(itemB, 0);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio, total);
	}
	
	/*Com a nova implementção, não faz mais sentido. 
	 * Este caso agora é coberto por removeMaisDeUmItemQueOContido()*/
//	@Test
//	void removeValorMaiorQueTotal() {	
//		assertThrows(
//				ImpossivelRemoverException.class, 
//				() -> { carrinhoCheio.removerItem(itemB, 3); }
//		);
//		double total = carrinhoCheio.getTotal();
//		assertEquals(totalCheio, total);
//	}
	
	@Test
	void removeQuantidadeNegativa() {	
		assertThrows(
				ImpossivelRemoverException.class, 
				() -> { carrinhoCheio.removerItem(itemA, -1); }
		);
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio, total);
	}
	
	@Test
	void removeItemInexistente() {	
		assertThrows(
				ImpossivelRemoverException.class, 
				() -> { carrinhoCheio.removerItem(itemC, 1); }
		);
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio, total);
	}
	
	@Test
	void removeMaisDeUmItemQueOContido() {	
		assertThrows(
				ImpossivelRemoverException.class, 
				() -> { carrinhoCheio.removerItem(itemA, 2); }
		);
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio, total);
	}
	
	@Test
	void removeTodosDeUmItem() {	
		assertDoesNotThrow(() -> { 
			carrinhoCheio.removerItem(itemB, 2);
		});
		double total = carrinhoCheio.getTotal();
		assertEquals(totalCheio - 40.0, total);
	}
}
