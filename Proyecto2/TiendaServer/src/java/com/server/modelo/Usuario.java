package com.server.modelo;

import com.server.Idao.AdminObject;
import com.server.Idao.Comparador;

public class Usuario implements Comparador, AdminObject {

    private String nickname;
    private String password;

    public Usuario(String nickname, String password) {
        super();
        this.nickname = nickname;
        this.password = password;
    }

    public Usuario(String nickname) {
        super();
        this.nickname = nickname;
        this.password = null;
    }
    
    /*Parche pesos ponderados similares axy = yxa*/    
    private int compareTo(String raiz) { /*Cadena nueva es el nickname con el que se compara*/
        String auxiliar;
        if(raiz.length() < this.nickname.length())
            auxiliar = raiz;
        else
            auxiliar = this.nickname;
        
        
        char aux[] = auxiliar.toCharArray();
        char raizA[] = raiz.toCharArray();
        char local[] = nickname.toCharArray();
        
        for(int i = 0; i < aux.length; i++) {
            if((int)raizA[i] == (int)local[i])
                continue;
            if((int)raizA[i] > (int)local[i]) {
                return -1;
            } else {
                return 1;
            }            
        }
                        
        return 0;
    }

    
    private int claveToAscii(String clave) {
        char ch[] = clave.toCharArray();
        String buffer = "";
        int temporal = 0;
        for (int i = 0; i < ch.length; i++) {
            temporal += (int) ch[i];//se van sumando todos los valores ascii de la cadena
        }                
        System.out.println("Peso ponderado de: " + clave + " es: " + temporal);
        return temporal;
    }
    
    
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean esIgual(Object q) {
        // TODO Auto-generated method stub
        Usuario u = (Usuario) q;
        return (nickname.compareTo(u.getNickname()) == 0);
//        return claveToAscii(nickname) == claveToAscii(u.getNickname());
//        return compareTo(u.getNickname()) == 0;
    }

    @Override
    public boolean esMayor(Object q) {
        // TODO Auto-generated method stub
        Usuario u = (Usuario) q;
        return (nickname.compareTo(u.getNickname()) > 0);
//        return claveToAscii(nickname) > claveToAscii(u.getNickname());
//        return compareTo(u.getNickname()) == 1;
    }

    @Override
    public boolean esMenor(Object q) {
        // TODO Auto-generated method stub
        Usuario u = (Usuario) q;
        return (nickname.compareTo(u.getNickname()) < 0);
//        return claveToAscii(nickname) < claveToAscii(u.getNickname());
//        return compareTo(u.getNickname()) == -1;
    }

    @Override
    public boolean mayorIgual(Object q) {
        // TODO Auto-generated method stub
        Usuario u = (Usuario) q;
        return compareTo(u.getNickname()) == 1;
    }

    @Override
    public boolean menorIgual(Object q) {
        // TODO Auto-generated method stub
        Usuario u = (Usuario) q;
        return compareTo(u.getNickname()) == -1;
    }

    //AdminObject
    @Override
    public String escribirObjetoConsole() {
        // TODO Auto-generated method stub
        return "Nickname: " + nickname + " Password: " + password;
    }

    @Override
    public void modificarObjeto(Object q) {
        // TODO Auto-generated method stub
        Usuario u = (Usuario) q;
        nickname = u.getNickname();
        password = u.getPassword();
    }

    @Override
    public String escribirObjeto() {
        // TODO Auto-generated method stub
        return "Nickname: " + nickname + " \\nPassword: " + password;
    }

    @Override
    public String devolverClave() {
        // TODO Auto-generated method stub
        return nickname;
    }

}
