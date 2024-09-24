package barberia.barberia_proyecto.clases;

public class ValidarCPF {

	    public static boolean isCPF(String CPF) {
	        // Considera-se erro CPFs formados por uma sequência de números iguais
	        if (CPF == null || CPF.length() != 11 || CPF.matches("(\\d)\\1{10}")) {
	            return false;
	        }

	        String dig10, dig11;
	        int sm, i, r, num, peso;

	        try {
	            // Cálculo do 1o. Dígito Verificador
	            sm = 0;
	            peso = 10;
	            for (i = 0; i < 9; i++) {
	                num = Character.getNumericValue(CPF.charAt(i));
	                sm += num * peso;
	                peso--;
	            }

	            r = 11 - (sm % 11);
	            dig10 = (r >= 10) ? "0" : Integer.toString(r);

	            // Cálculo do 2o. Dígito Verificador
	            sm = 0;
	            peso = 11;
	            for (i = 0; i < 10; i++) {
	                num = Character.getNumericValue(CPF.charAt(i));
	                sm += num * peso;
	                peso--;
	            }

	            r = 11 - (sm % 11);
	            dig11 = (r >= 10) ? "0" : Integer.toString(r);

	            // Verifica se os dígitos calculados conferem com os dígitos informados
	            return dig10.equals(CPF.substring(9, 10)) && dig11.equals(CPF.substring(10, 11));
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public static String imprimeCPF(String CPF) {
	        if (CPF == null || CPF.length() != 11) {
	            return "CPF inválido";
	        }
	        return CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
	               CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
	    }
	}