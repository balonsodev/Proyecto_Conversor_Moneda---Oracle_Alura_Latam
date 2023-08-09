package conversorMonedas;

import javax.swing.JOptionPane;

public class function {

	ConvertirMonedas monedas = new ConvertirMonedas();
	ConvertirMonedasAColones colones = new ConvertirMonedasAColones();
	
    public void ConvertirMonedas(double Minput) {
    	String opcion = (JOptionPane.showInputDialog(null, 
    			"Elije la moneda a la que deseas convertir tu dinero ", "Monedas", 
    			JOptionPane.PLAIN_MESSAGE, null, new Object[] 
    			{"De Colones a Dólar", "De Colones a Euro", "De Colones a Libras","De Colones a Yen","De Colones a Won Coreano","De Colones a Cordobas Nicaraguenses","De Dólar a Colones", "De Euro a Colones", "De Libras a Colones","De Yen a Colones","De Won Coreano a Colones","De Cordobas Nicaraguense a Colones"}, 
    			"Seleccion")).toString();
        switch(opcion) {
        case "De Colones a Dólar":
        	monedas.ConvertirColonesADolares(Minput);
        	break;
        case "De Colones a Euro":
        	monedas.ConvertirColonesAEuros(Minput);
        	break;
        case "De Colones a Libras":
        	monedas.ConvertirColonesALibras(Minput);
        	break;
        case "De Colones a Yen":
        	monedas.ConvertirColonesAYen(Minput);
        	break;
        case "De Colones a Won Coreano":
        	monedas.ConvertirColonesAWon(Minput);
        	break;
        case "De Colones a Cordobas Nicaraguenses":
        	monedas.ConvertirColonesACordobas(Minput);
        	break; 
        case "De Dólar a Colones":
        	colones.ConvertirDolaresAColones(Minput);
        	break;
        case "De Euro a Colones":
        	colones.ConvertirEurosAColones(Minput);
        	break;
        case "De Libras a Colones":
        	colones.ConvertirLibrasAColones(Minput);
        	break;
        case "De Yen a Colones":
        	colones.ConvertirYenAColones(Minput);
        	break;
        case "De Won Coreano a Colones":
        	colones.ConvertirWonAColones(Minput);
            break;
        case "De Cordobas Nicaraguense a Colones":
        	colones.ConvertirCordobasAColones(Minput);
            break;
        }      
    }
        
}
