package org.ddd.applications;

import org.ddd.entities.Ddd;
import org.ddd.repositories.DDDRepository;
import org.ddd.services.DDDService;

import java.util.ArrayList;

public class DDDApplication {
    private DDDRepository dddRepository;
    private DDDService dddService;

    public DDDApplication(DDDRepository dddRepository, DDDService dddService) {
        this.dddRepository = dddRepository;
        this.dddService = dddService;
    }

    public void adicionar(Ddd ddd) {
        this.dddRepository.adicionar(ddd);
        this.dddService.salvarImagem(ddd);
    }

    public void adicionarSoImagem(Ddd ddd) {
        this.dddService.salvarImagem(ddd);
    }

    public void remover(int id) {
        this.dddRepository.remover(id);
        this.dddService.removerImagem(id);
    }

    public Ddd buscarPorId(int id) {
        return this.dddRepository.buscarPorId(id);
    }

    public ArrayList<Ddd> buscarTodos() {
        return this.dddRepository.buscarTodos();
    }

    public void atualizarProduto(int id, Ddd produto) {
        this.dddRepository.atualizarProduto(id, produto);
        this.dddService.atualizarImagem(produto);
    }
}
