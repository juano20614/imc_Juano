package imc;

import java.util.ArrayList;

public class Logica {

	double IMC;
	ArrayList<PersonaVO> listaPersonas = new ArrayList<PersonaVO>();
	public String registrarPersona(PersonaVO persona) {
		String resultado="Registro Exitoso\n";
		resultado+="Documento: "+persona.getDocumento()+"\n";
		resultado+="Nombre: "+persona.getNombre()+"\n";
		resultado+="Edad: "+persona.getEdad()+"\n";
		resultado+="Talla: "+persona.getTalla()+"\n";
		resultado+="Peso: "+persona.getPeso()+"\n";
		
		String menIMC = calcularIMC(persona.getTalla(), persona.getPeso());
		resultado+= menIMC;
		persona.setImc(IMC);
		
		listaPersonas.add(persona);
		return resultado;
	}
	
	public String calcularIMC(double talla, double peso) {
		 IMC = peso/(talla*talla);
	String men="";
		if (IMC <18) {
			men="Anorexia";
		}else {
			if (IMC>=18 && IMC<20) {
				men="Delgadez";
			}else if (IMC>=20 && IMC<27) {
				men="normalidad";
			}else if (IMC>=27 && IMC<30) {
					men="Obesidad Grado 1";
				}else if (IMC>=30 && IMC<35) {
						men="Obesidad Grado 2";
					}else if (IMC>=35 && IMC<40) {
							men="Obesidad Grado 3";
						}else {
							men="Obesidad Morbida";
						}
		}
		return "IMC: "+IMC+"\nsu imc indica que tiene "+men;
	}

	public String consultarLista() {

		String resultado="";
		PersonaVO p= null;
		for (int i = 0; i < listaPersonas.size(); i++) {
			p=listaPersonas.get(i);
			resultado+="Documento: "+p.getDocumento()+"\n";
			resultado+="Nombre: "+p.getNombre()+"\n";
			resultado+="Edad: "+p.getEdad()+"\n";
			resultado+="Talla: "+p.getTalla()+"\n";
			resultado+="Peso: "+p.getPeso()+"\n";
			resultado+="IMC: "+p.getImc()+"\n";
			resultado+="________________________________\n";
		}
		return resultado;
	}
}
