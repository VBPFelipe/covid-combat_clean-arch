package br.com.vbpfelipe.domain;

import br.com.vbpfelipe.ports.data.input.ItemInputPort;
import br.com.vbpfelipe.ports.data.output.ItemOutputPort;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private TipoDoItem tipoDoItem;

    public static List<ItemEntity> convertItemInputPortToItem(List<ItemInputPort> itensInputPort) {
        List<ItemEntity> itens = new LinkedList<>();
            itensInputPort.forEach(itemOutputPort -> {
                var item = ItemEntity
                        .builder()
                        .tipoDoItem(TipoDoItem.valueOf(itemOutputPort.getTipoDoItem()))
                        .quantidade(itemOutputPort.getQuantidade())
                        .build();
                itens.add(item);

            });
        return itens;
    }

    public static List<ItemOutputPort> convertItemToOutputPort(List<ItemEntity> itens ){
        List<ItemOutputPort> itensOutputPort = new LinkedList<ItemOutputPort>();
        itens.forEach(item -> {
            ItemOutputPort itemOutputPort = ItemOutputPort.builder()
                    .quantidade(item.getQuantidade())
                    .tipoDoItem(item.tipoDoItem.getDescricao())
                    .id(item.getId())
                    .build();
            itensOutputPort.add(itemOutputPort);
        });
        return itensOutputPort;
    }
}
