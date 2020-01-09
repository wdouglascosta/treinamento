package treinamento.mauro.junior;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import treinamento.dia2.Parcela;


public class TesteDoAgrupamentoDeParcelasPorVencimento {

	@Test
	public void test() {
		List<Parcela> parcelas = new ArrayList<>();
		final LocalDate trezeDoUm = LocalDate.of(2020, 1, 13);
		final LocalDate dezesseteDoDois = LocalDate.of(2020, 2, 17);
		final LocalDate vinteCincoDoTres = LocalDate.of(2020, 3, 25);
		
		parcelas.add(new Parcela(1, trezeDoUm, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, trezeDoUm, new BigDecimal("2000.00")));
		parcelas.add(new Parcela(1, dezesseteDoDois, new BigDecimal("3000.00")));
		parcelas.add(new Parcela(1, dezesseteDoDois, new BigDecimal("4000.00")));
		parcelas.add(new Parcela(1, dezesseteDoDois, new BigDecimal("5000.00")));
		parcelas.add(new Parcela(1, vinteCincoDoTres, new BigDecimal("6000.00")));
		
		Map<LocalDate, List<Parcela>> parcelasAgrupadas = App.agrupar(parcelas);
					App.agrupar(parcelas);
		
		Set<LocalDate> vencimentos = new HashSet<>();
		vencimentos.add(trezeDoUm);
		vencimentos.add(dezesseteDoDois);
		vencimentos.add(vinteCincoDoTres);
		assertEquals(vencimentos, parcelasAgrupadas.keySet());
		
		assertEquals(
				Arrays.asList(parcelas.get(0), parcelas.get(1)),
				parcelasAgrupadas.get(trezeDoUm));
		assertEquals(
				Arrays.asList(parcelas.get(0), parcelas.get(1)),
				parcelasAgrupadas.get(dezesseteDoDois));
		assertEquals(
				Arrays.asList(parcelas.get(0), parcelas.get(1)),
				parcelasAgrupadas.get(vinteCincoDoTres));
				
		parcelasAgrupadas.keySet();
	}
}