/* 
    Nombre del programa: Program_6
    Nombre: Andrés David Mojica Ospina
    Fecha: 06-04-2016
    Descripción: Permite obtener el valor de p de una distribucion t
*/
package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author David Mojica
 * @version 1.0 6 de Abril de 2016
 */
public class CalculoVariableP 
{
    double resultado;
    
    /**
     * Método que inicializa los objetos de la clase distribucion
     * @param x
     * @param dof
     * @return BigDecimal El resultado de la distribucion simpson
     * @since incluido desde la version 1.0
    */
    public BigDecimal obtenerDistribucion(double x, double dof)
    {
        Distribucion distribucion = new Distribucion(x, dof);
        BigDecimal resultado_distribucion = new BigDecimal(distribucion.getDistribucion());
        return resultado_distribucion;
    }
    
    /**
     * Método para validar el resultado y recalcular el valor de x hasta 
     * obtener el valor correcto de p
     * @param p
     * @param dof_calculo
     * @return BigDecimal del valor de x obtenido a partir de p y los grados de libertad
     * @since incluido desde la version 1.0
    */
    public BigDecimal validarResultado(BigDecimal p, BigDecimal dof_calculo)
    {
        BigDecimal inicio = new BigDecimal("1");
        BigDecimal resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
        BigDecimal error_obtenido = calcularError(p, resultado_p);
        
        while( (error_obtenido.compareTo(new BigDecimal("0")) != 0) || p.compareTo(resultado_p) == 1 )
        {
            
            if(error_obtenido.compareTo(new BigDecimal(10)) == 1)
            {
               inicio = inicio.subtract(new BigDecimal("0.5"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
            else if(error_obtenido.compareTo(new BigDecimal(1)) == 1)
            {
               inicio = inicio.subtract(new BigDecimal("0.05"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
            
            // Suma
            else if(error_obtenido.compareTo(new BigDecimal(-0.02)) == 1)
            {
               inicio = inicio.add(new BigDecimal("0.00001"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
            else if(error_obtenido.compareTo(new BigDecimal(-0.1)) == 1)
            {
               inicio = inicio.add(new BigDecimal("0.0001"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
            else if(error_obtenido.compareTo(new BigDecimal(-1)) == 1)
            {
               inicio = inicio.add(new BigDecimal("0.001"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
            else if(error_obtenido.compareTo(new BigDecimal(-10)) == 1)
            {
               inicio = inicio.add(new BigDecimal("0.01"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
            else if(error_obtenido.compareTo(new BigDecimal(-100)) == 1)
            {
               inicio = inicio.add(new BigDecimal("0.1"));
               resultado_p = new BigDecimal(String.valueOf(obtenerDistribucion(inicio.doubleValue(), dof_calculo.doubleValue())));
               error_obtenido = calcularError(p, resultado_p);
            }
        }        
        return inicio;
    }
    
    /**
     * Método que retorna el error entre dos variables
     * @param valor_esperado
     * @param valor_obtenido
     * @return BigDecimal del valor del error
     * @since incluido desde la version 1.0
    */
    public BigDecimal calcularError(BigDecimal valor_esperado, BigDecimal valor_obtenido)
    {
        //System.out.println("esp: " + valor_esperado + " obt: " + valor_obtenido);
        BigDecimal error = new BigDecimal("0");
        error = valor_obtenido.multiply(new BigDecimal("100"));
        error = error.divide(valor_esperado, 6, RoundingMode.HALF_EVEN);
        error = error.subtract(new BigDecimal(100));
        return error;
    }
    
    /**
     * Método que retorna el resultado de x de la distribución t
     * @param a
     * @param b
     * @return BigDecimal del valor de x
     * @since incluido desde la version 1.0
    */
    public BigDecimal getResultado(String a, String b)
    {
        BigDecimal variable_p = new BigDecimal(a);
        BigDecimal variable_dof = new BigDecimal(b);
        BigDecimal valor_x = validarResultado(variable_p, variable_dof);
        return valor_x;
    }    
}