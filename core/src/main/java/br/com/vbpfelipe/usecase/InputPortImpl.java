package br.com.vbpfelipe.usecase;

import br.com.vbpfelipe.ports.data.input.HospitalInputPort;
import br.com.vbpfelipe.ports.data.output.HospitalOutputPort;
import br.com.vbpfelipe.ports.input.InputPort;
import br.com.vbpfelipe.ports.output.OutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputPortImpl implements InputPort {

    private final OutputPort outputPort;

    public InputPortImpl(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public HospitalOutputPort save(HospitalInputPort hospitalInputPort) {
        return this.outputPort.save(hospitalInputPort);
    }

    @Override
    public List<HospitalOutputPort> getAll() {
        return this.outputPort.getAll();
    }

    @Override
    public void delete(Long id) {
        this.outputPort.delete(id);
    }

    /*
    @Override
    public HospitalOutputPort update(Long id, Float percentual) {
        return this.outputPort.update(id, percentual);
    }
     */

    @Override
    public void update(Long hospitalId, Float percentual) {
        this.outputPort.update(hospitalId,percentual);
    }


}
