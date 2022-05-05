package controlePiloto.Impl;

import controlePiloto.Pessoa;

public class Piloto extends Pessoa {
    

    public Piloto(String nome, int _numeroPilotos, String cpf) {
        super(nome, cpf);
        
    }


    @Override
    public String getTipo() {
        return "Piloto";
    }


}
