package com.fiap.eficiencia.energetica.controller;

import com.fiap.eficiencia.energetica.model.RegistroConsumo;
import com.fiap.eficiencia.energetica.service.RegistroConsumoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consumos")
public class RegistroConsumoController {

    private final RegistroConsumoService service;

    public RegistroConsumoController(RegistroConsumoService service) {
        this.service = service;
    }

    // 1. POST /api/consumos: Cadastrar Novo Registro
    @PostMapping
    public ResponseEntity<RegistroConsumo> criarRegistro(@RequestBody RegistroConsumo registro) {
        RegistroConsumo novoRegistro = service.criarRegistro(registro);
        return new ResponseEntity<>(novoRegistro, HttpStatus.CREATED);
    }

    // 2. GET /api/consumos/alertas: Listar Alertas de Consumo
    @GetMapping("/alertas")
    public ResponseEntity<List<RegistroConsumo>> listarAlertas() {
        List<RegistroConsumo> alertas = service.listarAlertasDeConsumo();
        return ResponseEntity.ok(alertas);
    }

    // 3. PUT /api/consumos/{id}: Atualizar Registro
    @PutMapping("/{id}")
    public ResponseEntity<RegistroConsumo> atualizarRegistro(@PathVariable Long id, @RequestBody RegistroConsumo registro) {
        RegistroConsumo atualizado = service.atualizarRegistro(id, registro);
        return ResponseEntity.ok(atualizado);
    }

    // 4. DELETE /api/consumos/{id}: Deletar Registro
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarRegistro(@PathVariable Long id) {
        service.deletarRegistro(id);
    }

    // Extra: GET /api/consumos/{id}: Consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistroConsumo> buscarPorId(@PathVariable Long id) {
        RegistroConsumo registro = service.buscarPorId(id);
        return ResponseEntity.ok(registro);
    }

    // Extra: GET /api/consumos: Listar Todos
    @GetMapping
    public ResponseEntity<List<RegistroConsumo>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }
}