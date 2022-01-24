package br.com.vbpfelipe.domain;

import br.com.vbpfelipe.helper.GerenciaItem;
import lombok.Getter;

@Getter
public enum TipoDoItem implements GerenciaItem {

    MEDICO(3, "Médico") ,
    ENFERMEIRO(3, "Enfermeiro") ,
    RESPIRADOR(5, "Respirador") ,
    AMBULANCIA(10, "Ambulância") ,
    TOMOGRAFO(12, "Tomógrafo") ;

    @Override
    public Integer calculaPontosDoItem(ItemEntity item) {
        return item.getQuantidade() * this.getValor();
    }

    public Integer valor;
    public String descricao;

    TipoDoItem(Integer valor, String descricao){
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getValor(){
        return this.valor;
    }
}
