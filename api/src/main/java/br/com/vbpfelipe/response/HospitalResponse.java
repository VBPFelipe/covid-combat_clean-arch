package br.com.vbpfelipe.response;

import br.com.vbpfelipe.ports.data.input.InventarioInputPort;
import br.com.vbpfelipe.ports.data.input.ItemInputPort;
import br.com.vbpfelipe.ports.data.output.HospitalOutputPort;
import br.com.vbpfelipe.ports.data.output.ItemOutputPort;
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
public class HospitalResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoResponse localizacao;
    private float percentualOcupacao;
    private InventarioResponse inventario;

    public static HospitalResponse converteHospitalOutputPortHospitalResponse(HospitalOutputPort hospitalOutputPort) {

        LocalizacaoResponse localizacaoResponse = LocalizacaoResponse.builder()
                .id(hospitalOutputPort.getLocalizacaoOutputPort().getId())
                .longitude(hospitalOutputPort.getLocalizacaoOutputPort().getLongitude())
                .latitude(hospitalOutputPort.getLocalizacaoOutputPort().getLatitude())
                .build();

        InventarioResponse inventarioResponse = InventarioResponse.builder()
                .id(hospitalOutputPort.getInventarioOutputPort().getId())
                .pontosDoInventario(hospitalOutputPort.getInventarioOutputPort().getPontosDoInventario())
                .itens(ItemResponse.convertItemOutputPortToResponse(hospitalOutputPort.getInventarioOutputPort().getItens()))
                .build();

        HospitalResponse hospitalResponse = HospitalResponse.builder()
                .id(hospitalOutputPort.getId())
                .nome(hospitalOutputPort.getNome())
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .localizacao(localizacaoResponse)
                .percentualOcupacao(hospitalOutputPort.getPercentualDeOcupacao())
                .inventario(inventarioResponse)
                .build();

        return hospitalResponse;
    }
}
