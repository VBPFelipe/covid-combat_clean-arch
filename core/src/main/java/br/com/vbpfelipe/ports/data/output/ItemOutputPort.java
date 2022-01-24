package br.com.vbpfelipe.ports.data.output;

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
public class ItemOutputPort {

    private Long id;
    private int quantidade;
    private String tipoDoItem;
}
