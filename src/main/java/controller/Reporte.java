/* 
    Nombre del programa: Program_6
    Nombre: Andrés David Mojica Ospina
    Fecha: 06-04-2016
    Descripción: Clase que permite realizar el reporte
*/
package controller;

import java.math.BigDecimal;

/**
 * @author David Mojica
 * @version 1.0 6 de Abril de 2016
 */
public final class Reporte 
{
    String reporte;
    /**
    * Constructor de clase
    * @since incluido desde la version 1.0
    */
    public Reporte()
    {
        
        CalculoVariableP calculo_p_1 = new CalculoVariableP();
        CalculoVariableP calculo_p_2 = new CalculoVariableP();
        CalculoVariableP calculo_p_3 = new CalculoVariableP();        
        
        reporte = "<table style='width:400px;border:1px solid black;'><tr><td>p</td><td>dof</td><td>x</td></tr>";
        reporte += "<tr><td>0.2</td><td>5</td><td>" + calculo_p_1.getResultado("0.2","6") + "</td></tr>";
        reporte += "<tr><td>0.45</td><td>15</td><td>" + calculo_p_2.getResultado("0.45","15") + "</td></tr>";
        reporte += "<tr><td>0.495</td><td>4</td><td>" + calculo_p_3.getResultado("0.495","4") + "</td></tr>";
        reporte += "</table>";
    }
        
    /**
     * Método que devuelve el reporte en forma de tabla html
     * @since incluido desde la version 1.0
    */
    public String getReporte()
    {
        return this.reporte;
    }
}