package carrinho;

public class Item {
	private static int proxCodigo = 0; //Devia ser uma Factory
	private int codigo;
	private double valor;
	
	public Item(double valor) {
		this.valor = valor;
		this.codigo = Item.proxCodigo;
		Item.proxCodigo++;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	@Override
	public int hashCode() { //Gerado automaticamente
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	
	/*Gerado automaticamente.
	 * Não é coberto pelos testes porque hashCode() 
	 * sempre dá diferente.*/
//	@Override
//	public boolean equals(Object obj) { 
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Item other = (Item) obj;
//		if (codigo != other.codigo)
//			return false;
//		return true;
//	}
}
