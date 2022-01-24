package br.com.vbpfelipe.ports.output;

import br.com.vbpfelipe.ports.data.input.HospitalInputPort;
import br.com.vbpfelipe.ports.data.output.HospitalOutputPort;

import java.util.List;

public interface OutputPort {
    HospitalOutputPort save(HospitalInputPort hospitalInputPort);
    List<HospitalOutputPort> getAll();
    void delete(Long id);
//    HospitalOutputPort update(Long id, Float percentual);
    void update(Long id, Float percentual);
}
