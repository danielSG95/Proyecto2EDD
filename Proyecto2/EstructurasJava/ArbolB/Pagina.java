/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB;

import Modelo.Estudiante;

/**
 *
 * @author Robert0
 */
public class Pagina <T>{
    protected Object estudiantes[];
    protected Pagina ramas[];
    protected int cuenta;//para que es esto?? :v 
    private final int m;

    public Pagina() {
        this.m = 5;
        this.estudiantes = new Object[5];//probar si esto funciona.
        this.ramas = new Pagina[5];
    }
    
    public boolean nodoLleno()
    {
        return cuenta == m-1;       
    }
    
    public boolean nodoSemiVacio()
    {
        return cuenta<m/2;        
    }
    
    public Object getClave(int posicion)
    {
        return estudiantes[posicion];
    }
    
    public void setClave(int posicion, T estudiante)
    {
        estudiantes[posicion] = estudiante;
    }
    
    public Pagina getRama(int posicion)
    {
        return ramas[posicion];
    }
    
    public void setRama(int posicion, Pagina pagina)
    {
        ramas[posicion] = pagina;
    }
    
    public int getCuenta()
    {
        return cuenta;
    }
    
    public void setCuenta(int valor)
    {
        cuenta = valor;
    }
}