package com.api.processosmservice.service;

import com.api.processosmservice.exception.ProcessoAlreadyExistsException;
import com.api.processosmservice.exception.ProcessoNotFoundException;
import com.api.processosmservice.model.Processo;
import com.api.processosmservice.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoService {

   @Autowired
   ProcessoRepository processoRepository;

    public List<Processo> findAll() {
        return this.processoRepository.findAll();
    }

    public List<Integer> findNumeros() {
        return this.processoRepository.findNumeros();
    }

    public Processo create(Processo processo) {
        if(this.processoRepository.existsById(processo.getNumero())) {
           throw new ProcessoAlreadyExistsException("Este número de processo já foi cadastrado");
        }
        return this.processoRepository.save(processo);
    }

    public void delete(Integer numero) {
        this.processoRepository.deleteById(numero);
    }

    public Processo addReu(Integer numero, String reu) {
        Processo processo = processoRepository.findById(numero).orElseThrow(ProcessoNotFoundException::new);

        processo.setReu(reu);
        return this.processoRepository.save(processo);
    }

}
