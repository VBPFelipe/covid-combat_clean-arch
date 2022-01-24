package br.com.vbpfelipe.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoResponse {

    private Long id;
    private String latitude;
    private String longitude;
}
