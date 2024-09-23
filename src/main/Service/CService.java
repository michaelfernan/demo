package com.UltraC.demo.service;

import com.UltraC.demo.models.Cliente;
import com.UltraC.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(cliente.getNome());
                    clienteExistente.setCpf(cliente.getCpf());
                    return clienteRepository.save(clienteExistente);
                }).orElse(null);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
