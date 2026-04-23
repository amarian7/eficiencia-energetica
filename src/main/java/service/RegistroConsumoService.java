package com.fiap.eficiencia.energetica.service;

import com.fiap.eficiencia.energetica.model.RegistroConsumo;
import com.fiap.eficiencia.energetica.repository.RegistroConsumoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.math.BigDecimal;

@Service
public class RegistroConsumoService {

    private final RegistroConsumoRepository repository;

    public RegistroConsumoService(RegistroConsumoRepository repository) {
        this.repository = repository;
    }

    // POST: Cadastrar novo registro
    public RegistroConsumo criarRegistro(RegistroConsumo novoRegistro) {
        if (novoRegistro.getConsumoKwh() == null || novoRegistro.getConsumoKwh().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O consumo em KWh deve ser um valor positivo e válido.");
        }
        return repository.save(novoRegistro);
    }

    // GET: Buscar por ID
    public RegistroConsumo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro de consumo não encontrado: " + id));
    }

    // PUT: Atualizar um registro
    public RegistroConsumo atualizarRegistro(Long id, RegistroConsumo dadosAtualizados) {
        RegistroConsumo registroExistente = buscarPorId(id);

        registroExistente.setLocal(dadosAtualizados.getLocal());
        registroExistente.setEquipamento(dadosAtualizados.getEquipamento());
        registroExistente.setConsumoKwh(dadosAtualizados.getConsumoKwh());
        registroExistente.setLimiteAlerta(dadosAtualizados.getLimiteAlerta());

        return repository.save(registroExistente);
    }

    // DELETE: Deletar um registro
    public void deletarRegistro(Long id) {
        RegistroConsumo registroExistente = buscarPorId(id);
        repository.delete(registroExistente);
    }

    // LÓGICA ESG: Listar alertas (consumo acima do limite)
    public List<RegistroConsumo> listarAlertasDeConsumo() {
        return repository.findAll().stream()
                .filter(r -> r.getConsumoKwh().compareTo(r.getLimiteAlerta()) > 0)
                .toList();
    }

    // Extra: Listar todos
    public List<RegistroConsumo> buscarTodos() {
        return repository.findAll();
    }
}