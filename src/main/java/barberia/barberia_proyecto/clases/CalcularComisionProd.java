package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;

public class CalcularComisionProd {
	public BigDecimal calcular(Producto producto, Comision<Producto> comision) {
		return comision.calcular(producto);
	}
}
