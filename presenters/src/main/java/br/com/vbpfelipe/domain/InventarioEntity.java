package br.com.vbpfelipe.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventarioEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontosDoInventario = 0;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id")
    private List<ItemEntity> itens;

    public void calcularPontos() {
        if (this.itens == null) {
            this.pontosDoInventario = 0;
        }

        this.itens.forEach(itemEntity -> {
            this.pontosDoInventario = itemEntity.getTipoDoItem().calculaPontosDoItem(itemEntity);
        });
    }

    public void adicionarItens(List<ItemEntity> itens) {
        this.itens.addAll(itens);
    }

    public void adicionarItem(ItemEntity itemEntity) {
        this.itens.add(itemEntity);
    }
}
