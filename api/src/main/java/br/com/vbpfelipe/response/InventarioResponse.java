package br.com.vbpfelipe.response;

import br.com.vbpfelipe.ports.data.output.InventarioOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioResponse {

    private Long id;
    private Integer pontosDoInventario;
    private List<ItemResponse> itens;
}
