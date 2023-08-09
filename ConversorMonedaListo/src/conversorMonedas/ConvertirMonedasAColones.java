package conversorMonedas;

import javax.swing.JOptionPane;

public class ConvertirMonedasAColones {
	public double dolar = 547.99;
	public double euro = 601.72;
	public double yenJapones = 3.94;
	public double wonSulCoreano = 0.43;
	public double libraEsterlina = 700.92;
	public double cordobaNicaraguense = 14.77;
	
	public void ConvertirDolaresAColones(double valor) {
		double monedaDolar = valor * dolar;
		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ₡ " +monedaDolar+ " Colones");
	}
	
	public void ConvertirEurosAColones(double valor) {
		double monedaEuro = valor * euro;
		monedaEuro = (double) Math.round(monedaEuro *100d)/100;
		JOptionPane.showMessageDialog(null, "Tienes ₡ " +monedaEuro+ " Colones");
	}
	
	public void ConvertirLibrasAColones(double valor) {
		double monedaLibra = valor * libraEsterlina;
        monedaLibra = (double) Math.round(monedaLibra *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ₡ " +monedaLibra+ " Colones");
	}
	
	public void ConvertirYenAColones(double valor) {
		double monedaYen = valor * yenJapones;
        monedaYen = (double) Math.round(monedaYen *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ₡ " +monedaYen+ " Colones");
	}
	
	public void ConvertirWonAColones(double valor) {
		double monedaWon = valor * wonSulCoreano;
        monedaWon = (double) Math.round(monedaWon *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ₡ " +monedaWon+ " Colones");
	}
	public void ConvertirCordobasAColones(double valor) {
		double monedaCordoba = valor * cordobaNicaraguense;
		monedaCordoba = (double) Math.round(monedaCordoba *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ₡ " +monedaCordoba+ " Colones");
	}
}
