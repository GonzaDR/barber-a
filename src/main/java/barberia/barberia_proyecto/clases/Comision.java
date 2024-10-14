package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;

public interface Comision<T> {
	BigDecimal calcular(T objeto);
}
