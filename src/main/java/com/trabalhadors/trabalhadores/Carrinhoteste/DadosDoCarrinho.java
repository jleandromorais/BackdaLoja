package com.trabalhadors.trabalhadores.Carrinhoteste;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.swing.plaf.basic.BasicIconFactory;
import java.math.BigDecimal;

public record DadosDoCarrinho(@NotBlank(message = "A função não pode estar em branco")String name,
                              @NotBlank(message = "A função não pode estar em branco")String imagem,
                              @NotNull(message = "A funcao n pode sero nula") Integer quantity,
                              @NotNull (message = "A funcao n pode sero nula") BigDecimal price,
                              Long id) {
    @Override
    public Long id() {
        return id;
    }

    public DadosDoCarrinho(Carrinhoteste carrinhoteste) {
        this(carrinhoteste.getName(),carrinhoteste.getImagem(),carrinhoteste.getQuantity(),carrinhoteste.getPrice(), carrinhoteste.getId());
    }


}
