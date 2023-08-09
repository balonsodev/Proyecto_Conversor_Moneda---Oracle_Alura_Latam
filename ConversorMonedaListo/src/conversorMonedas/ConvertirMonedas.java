package conversorMonedas;

import javax.swing.JOptionPane;

public class ConvertirMonedas {

	public double dolar = 547.99;
	public double euro = 601.72;
	public double yenJapones = 3.94;
	public double wonSulCoreano = 0.43;
	public double libraEsterlina = 700.92;
	public double cordobaNicaraguense = 14.77;

	
	public void ConvertirColonesADolares(double valor) {
		double monedaDolar = valor / dolar;
		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes $ " +monedaDolar+ " Dolares");
	}
	
	public void ConvertirColonesAEuros(double valor) {
		double monedaEuro = valor / euro;
		monedaEuro = (double) Math.round(monedaEuro *100d)/100;
		JOptionPane.showMessageDialog(null, "Tienes € " +monedaEuro+ " Euros");
	}
	
	public void ConvertirColonesALibras(double valor) {
		double monedaLibra = valor / libraEsterlina;
        monedaLibra = (double) Math.round(monedaLibra *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes £ " +monedaLibra+ " Libras Esterlinas");
	}
	
	public void ConvertirColonesAYen(double valor) {
		double monedaYen = valor / yenJapones;
        monedaYen = (double) Math.round(monedaYen *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ¥ " +monedaYen+ " Yuanes");
	}
	
	public void ConvertirColonesAWon(double valor) {
		double monedaWon = valor / wonSulCoreano;
        monedaWon = (double) Math.round(monedaWon *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes ₩ " +monedaWon+ " Wons");
	}
	public void ConvertirColonesACordobas(double valor) {
		double monedaCordoba = valor / cordobaNicaraguense;
        monedaCordoba = (double) Math.round(monedaCordoba *100d)/100;
        JOptionPane.showMessageDialog(null, "Tienes C$ " +monedaCordoba+ " Cordobas ");
	}
	
}
