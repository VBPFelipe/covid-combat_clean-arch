package br.com.vbpfelipe.request;

import br.com.vbpfelipe.ports.data.input.HospitalInputPort;
import br.com.vbpfelipe.ports.data.input.InventarioInputPort;
import br.com.vbpfelipe.ports.data.input.ItemInputPort;
import br.com.vbpfelipe.ports.data.input.LocalizacaoInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRequest {

    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoRequest localizacao;
    private float percentualOcupacao;
    private InventarioRequest inventario;

    public HospitalInputPort convertHospitalInputPort(HospitalRequest request) {
        LocalizacaoInputPort localizacaoInputPort = LocalizacaoInputPort.builder()
                .latitude(request.localizacao.getLatitude())
                .longitude(request.localizacao.getLongitude())
                .build();

        InventarioInputPort inventarioInputPort = InventarioInputPort.builder()
                .itens(ItemRequest.itemRequestToItemInputPort(request.getInventario().getItens()))
                .build();

        return HospitalInputPort.builder()
                .cnpj(request.cnpj)
                .nome(request.nome)
                .endereco(request.endereco)
                .localizacao(localizacaoInputPort)
                .percentualOcupacao(percentualOcupacao)
                .inventario(inventarioInputPort)
                .build();
    }
}
