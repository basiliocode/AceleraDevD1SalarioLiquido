package br.com.codenation.calculadora;


import jdk.vm.ci.code.CodeUtil;

import javax.swing.*;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if(salarioBase < 1039)
			return 0;

		double salarioLiquido = calcularInss(salarioBase);
		salarioLiquido = calcularIRRF(salarioLiquido);
		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500)
			return salarioBase - salarioBase * 0.08 ;
		else if (salarioBase > 1500 && salarioBase <=4000)
			return salarioBase - salarioBase * 0.09;
		else
			return salarioBase - salarioBase * 0.11;
	}
	private double calcularIRRF(double salarioBase) {
		if (salarioBase <= 3000)
			return salarioBase;
		else if( salarioBase > 3000 && salarioBase <= 6000)
			return salarioBase - salarioBase * 0.075;
		else
			return salarioBase - salarioBase * 0.15;
	}


}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/