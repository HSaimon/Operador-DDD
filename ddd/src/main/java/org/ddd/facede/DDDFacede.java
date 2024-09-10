package org.ddd.facede;

import org.ddd.applications.DDDApplication;
import org.ddd.entities.Ddd;

import java.util.ArrayList;

public class DDDFacede {
    private DDDApplication dddApplication;

    public DDDFacede(DDDApplication dddApplication) {
        this.dddApplication = dddApplication;
    }

    public void adicionar(Ddd ddd) {
        this.dddApplication.adicionar(ddd);
    }

    public void remover(int codigo) {
        this.dddApplication.remover(codigo);
    }

    public Ddd buscarPorId(int codigo) {
        return this.dddApplication.buscarPorId(codigo);
    }

    public ArrayList<Ddd> buscarTodos() {
        return this.dddApplication.buscarTodos();
    }

    public void atualizarProduto(int codigo, Ddd ddd) {
        this.dddApplication.atualizarProduto(codigo, ddd);
    }
}
