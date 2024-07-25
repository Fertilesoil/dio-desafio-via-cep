package desafio.via.cep.service.implementation;

import desafio.via.cep.model.Endereco;
import desafio.via.cep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoServiceImplementation {

    @Autowired
    private ViaCepService viaCep;

    public Endereco findAdress(String cep) {
        return viaCep.consultarCep(cep);
    }
}
