package carrinho;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoCompras {
	
	//private double total;
	private HashMap<Item, Integer> qtdePorItem;
	
	public CarrinhoCompras() {
//		total = 0.0;
		qtdePorItem = new HashMap<Item, Integer>();
	}
	
	public double getTotal() {
//		return this.total;
		double resultado = 0.0;
		for (Map.Entry<Item, Integer> entrada: qtdePorItem.entrySet()) {
			double valorItem = entrada.getKey().getValor();
			int quantidade = entrada.getValue();
			resultado += valorItem * quantidade;
		}
		return resultado;
	}
	
	public void adicionarItem(Item item, int qtdeAInserir) 
			throws ImpossivelAdicionarException 
	{
		if (qtdeAInserir < 0)  {
			throw new ImpossivelAdicionarException();
		}
		
		Integer qtdeAtual = qtdePorItem.get(item);
		if (qtdeAtual == null) { 
			qtdePorItem.put(item, qtdeAInserir);
		} else {
			qtdePorItem.put(item, qtdeAtual + qtdeAInserir);
		}
//		this.total += item.getValor() * qtdeAInserir;
	}
	
	public void removerItem(Item item, int qtdeARemover) 
			throws ImpossivelRemoverException 
	{
		if (qtdeARemover < 0)  {
			throw new ImpossivelRemoverException();
		}
		Integer qtdeAtual = qtdePorItem.get(item);
		if (qtdeAtual == null) {
			throw new ImpossivelRemoverException();
		}
		if (qtdeARemover > qtdeAtual) {
			throw new ImpossivelRemoverException();
		}
		/*Como está implentado, nunca remove registro do HashMap.
		 * Zerar quantidade e remover registro é equivalente para o cálculo do total. */
		qtdePorItem.put(item, qtdeAtual - qtdeARemover);
//		this.total -= item.getValor() * qtdeARemover;
	}
}
