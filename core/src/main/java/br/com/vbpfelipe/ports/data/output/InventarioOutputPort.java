package br.com.vbpfelipe.ports.data.output;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class InventarioOutputPort {

    private Long id;
    private Integer pontosDoInventario;
    private List<ItemOutputPort> itens;
}
