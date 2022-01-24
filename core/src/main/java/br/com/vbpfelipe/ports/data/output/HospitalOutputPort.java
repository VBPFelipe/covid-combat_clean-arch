package br.com.vbpfelipe.ports.data.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalOutputPort {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private Float percentualDeOcupacao;
    private LocalizacaoOutputPort localizacaoOutputPort;
    private InventarioOutputPort inventarioOutputPort;

}
