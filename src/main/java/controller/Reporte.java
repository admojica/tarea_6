/* 
    Nombre del programa: Program_6
    Nombre: Andrés David Mojica Ospina
    Fecha: 06-04-2016
    Descripción: Clase que permite realizar el reporte
*/
package controller;

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
        
        reporte = "<table style='width:400px;border:1px solid black;'><tr><td>x</td><td>dof</td><td>p - expected</td><td>p - actual</td></tr>";
        reporte += "<tr><td>0 to x=1.1</td><td>9</td><td>0.35006</td><td>" + calculo_p_1.getResultado("0.2","6") + "</td></tr>";
        reporte += "<tr><td>0 to x=1.1812</td><td>10</td><td>0.36757</td><td>" + calculo_p_2.getResultado("0.45","15") + "</td></tr>";
        reporte += "<tr><td>0 to x=2.750</td><td>30</td><td>0.49500</td><td>" + calculo_p_3.getResultado("0.495","4") + "</td></tr>";
        reporte += "</table>";
    }
        
    /**
     * Método que devuelve el reporte
     * @since incluido desde la version 1.0
    */
    public String getReporte()
    {
        return this.reporte;
    }
}