package carrinho;

public class CarrinhoCompras {
	
	private double total;
	
	public CarrinhoCompras() {
		total = 0.0;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public void adicionarItem(double valor, int qtde) 
			throws ImpossivelAdicionarException 
	{
		if (qtde < 0)  {
			throw new ImpossivelAdicionarException();
		}
		this.total += valor * qtde;
	}
	
	public void removerItem(double valor, int qtde) 
			throws ImpossivelRemoverException 
	{
		if (qtde < 0)  {
			throw new ImpossivelRemoverException();
		}
		double aRemover = valor * qtde;
		if (aRemover > this.total)  {
			throw new ImpossivelRemoverException();
		}
		this.total -= aRemover;
	}
}
