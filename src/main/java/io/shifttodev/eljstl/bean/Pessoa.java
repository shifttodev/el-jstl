package io.shifttodev.eljstl.bean;

import io.shifttodev.eljstl.service.GenerateID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    private Integer id;
    private String nome;
    private String cidade;
    private String profissao;

    public Pessoa(){
        this.id = GenerateID.get();
    }

    @Override
    public String toString(){
        return this.getNome();
    }
}
