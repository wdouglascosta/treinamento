package treinamento.dia6.veiculo;

import java.math.BigDecimal;

public class MotorV6 implements Motor {

	@Override
	public void ligar() {
		System.out.println("ligando v6");
	}

	@Override
	public void desligar() {
		System.out.println("desligando v6");
		
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("190.00");
	}

}
