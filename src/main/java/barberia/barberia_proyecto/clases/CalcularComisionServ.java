package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;

public class CalcularComisionServ {
	public BigDecimal calcular(Servicio servicio, Comision<Servicio> comision) {
		return comision.calcular(servicio);
	}
}
