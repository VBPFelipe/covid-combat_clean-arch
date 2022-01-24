package br.com.vbpfelipe.ports.input;

import br.com.vbpfelipe.ports.data.input.HospitalInputPort;
import br.com.vbpfelipe.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface InputPort {
    HospitalOutputPort save(HospitalInputPort hospitalInputPort);
    List<HospitalOutputPort> getAll();
    void delete(Long id);
//    HospitalOutputPort update(Long id, Float percentualOcupacao);
    void update(Long id, Float percentualOcupacao);
}
