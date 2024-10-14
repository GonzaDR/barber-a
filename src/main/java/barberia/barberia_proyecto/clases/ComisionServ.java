package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;

public class ComisionServ implements Comision<Servicio>{

	@Override
	public BigDecimal calcular(Servicio servicio) {
		return servicio.getPrecio_servicio().multiply(new BigDecimal("0.1"));
	}
}