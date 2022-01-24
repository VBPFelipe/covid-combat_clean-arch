package br.com.vbpfelipe.controller;


import br.com.vbpfelipe.ports.input.InputPort;
import br.com.vbpfelipe.request.HospitalRequest;
import br.com.vbpfelipe.request.InventarioRequest;
import br.com.vbpfelipe.request.ItemRequest;
import br.com.vbpfelipe.response.HospitalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final InputPort inputPort;

    public HospitalController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public HospitalResponse criarHospital(@RequestBody HospitalRequest request) {
       var response = this.inputPort.save(request.convertHospitalInputPort(request));
       return HospitalResponse.converteHospitalOutputPortHospitalResponse(response);
    }

    @GetMapping
    public List<HospitalResponse> getAll() {
        /*
        List<HospitalResponse> list = new ArrayList<>();
        for(HospitalOutputPort outputPort : this.inputPort.getAll()) {
            list.add(HospitalResponse.converteHospitalOutputPortHospitalResponse(outputPort));
        }
        return list;
         */

        return this.inputPort.
                getAll().
                stream().
                map(HospitalResponse::converteHospitalOutputPortHospitalResponse).
                collect(Collectors.toList());
    }

    @DeleteMapping
    public void removerHospital(@RequestParam Long id){
        this.inputPort.delete(id);
    }

    /*
    @PutMapping
    public HospitalResponse atualizarPercentualDeOcupacao(@RequestParam Long id, @RequestParam Float percentualOcupacao) {
        var response = this.inputPort.update(id, percentualOcupacao);
        return HospitalResponse.converteHospitalOutputPortHospitalResponse(response);
    }
     */

    @PutMapping("/atualizar-ocupacao/{id}")
    public void atualizaPercentualOcupacao(@PathVariable("id") Long id, @RequestParam("percentual") Float percentual) {
        this.inputPort.update(id, percentual);
    }
}
