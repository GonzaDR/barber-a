package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;

public class ComisionProd implements Comision<Producto>{

	@Override
	public BigDecimal calcular(Producto producto) {
		return producto.getPrecio().multiply(new BigDecimal("0.1"));
	}
}