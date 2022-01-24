package br.com.vbpfelipe.request;

import br.com.vbpfelipe.ports.data.input.ItemInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    private int quantidade;

    private String tipoDoItem;

    public static List<ItemInputPort> itemRequestToItemInputPort(List<ItemRequest> itemRequest) {
        List<ItemInputPort> listaDeItemComoInputPort = new LinkedList<>();
        itemRequest.forEach(item -> {
            var itemInputPort = ItemInputPort.builder()
                    .tipoDoItem(item.getTipoDoItem())
                    .quantidade(item.getQuantidade())
                    .build();
            listaDeItemComoInputPort.add(itemInputPort);
        });
        return listaDeItemComoInputPort;
    }
}
