package br.com.vbpfelipe.domain;

import br.com.vbpfelipe.ports.data.input.HospitalInputPort;
import br.com.vbpfelipe.ports.data.input.InventarioInputPort;
import br.com.vbpfelipe.ports.data.input.ItemInputPort;
import br.com.vbpfelipe.ports.data.output.HospitalOutputPort;
import br.com.vbpfelipe.ports.data.output.InventarioOutputPort;
import br.com.vbpfelipe.ports.data.output.LocalizacaoOutputPort;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String endereco;

    private float percentualOcupacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn ( name = "localizacao_ID" )
    private LocalizacaoEntity localizacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_ID")
    private InventarioEntity inventario;

    public float atualizaPercentualDeOcupacao(Float percentual){
        return this.percentualOcupacao = percentual;
    }

    public static HospitalEntity converteHospitalEntity(HospitalInputPort inputPort) {
        LocalizacaoEntity localizacaoEntity = LocalizacaoEntity.builder()
                .id(null)
                .latitude(inputPort.getLocalizacao().getLatitude())
                .longitude(inputPort.getLocalizacao().getLongitude())
                .build();

        List<ItemEntity> itens = ItemEntity.convertItemInputPortToItem(inputPort.getInventario().getItens());

        InventarioEntity inventarioEntity = InventarioEntity
                .builder()
                .itens(itens)
                .build();

        inventarioEntity.calcularPontos();

        return HospitalEntity.builder()
                .id(null)
                .nome(inputPort.getNome())
                .cnpj(inputPort.getCnpj())
                .endereco(inputPort.getEndereco())
                .localizacao(localizacaoEntity)
                .percentualOcupacao(inputPort.getPercentualOcupacao())
                .inventario(inventarioEntity)
                .build();
    }

    public static HospitalOutputPort converteHospitalOutputPort(HospitalEntity hospitalEntity) {
        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .id(hospitalEntity.id)
                .latitude(hospitalEntity.getLocalizacao().getLatitude())
                .longitude(hospitalEntity.getLocalizacao().getLongitude())
                .build();

        InventarioOutputPort inventarioOutputPort = InventarioOutputPort
                .builder()
                .id(hospitalEntity.getInventario().getId())
                .pontosDoInventario(hospitalEntity.getInventario().getPontosDoInventario())
                .itens(ItemEntity.convertItemToOutputPort(hospitalEntity.inventario.getItens()))
                .build();

        return HospitalOutputPort.builder()
                .id(hospitalEntity.id)
                .nome(hospitalEntity.getNome())
                .cnpj(hospitalEntity.getCnpj())
                .endereco(hospitalEntity.getEndereco())
                .localizacaoOutputPort(localizacaoOutputPort)
                .percentualDeOcupacao(hospitalEntity.percentualOcupacao)
                .inventarioOutputPort(inventarioOutputPort)
                .build();
    }
}