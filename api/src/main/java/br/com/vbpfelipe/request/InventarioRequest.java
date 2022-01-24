package br.com.vbpfelipe.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioRequest {
    private Integer pontosDoInventario = 0;
    private List<ItemRequest> itens;
}
