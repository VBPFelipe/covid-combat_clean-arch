package br.com.vbpfelipe.ports.data.input;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoInputPort {

    private String latitude;
    private String longitude;
}
