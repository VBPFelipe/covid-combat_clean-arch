package br.com.vbpfelipe.ports.data.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalInputPort {

    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoInputPort localizacao;
    private float percentualOcupacao;
    private InventarioInputPort inventario;

}