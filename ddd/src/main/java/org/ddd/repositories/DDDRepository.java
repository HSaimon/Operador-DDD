package org.ddd.repositories;

import org.ddd.entities.Ddd;

import java.util.ArrayList;

public class DDDRepository {
    private ArrayList<Ddd> ddds = new ArrayList<Ddd>();

    public void adicionar(Ddd ddd) {
        ddds.add(ddd);
    }

    public void remover(int id) {
        ddds.removeIf(ddd -> ddd.getCodigo() == id);
    }

    private Ddd filtrarProduto(int id) {
        return ddds.stream().filter(p -> p.getCodigo() == id).findFirst().get();
    }

    public Ddd buscarPorId(int id) {
        Ddd dddInDb = filtrarProduto(id);
        if(dddInDb == null){
            return null;
        }
        return dddInDb;
    }

    public ArrayList<Ddd> buscarTodos() {
        return ddds;
    }

    public void atualizarProduto(int id, Ddd ddd) {
        Ddd dddInDb = filtrarProduto(id);

        dddInDb.setEstado(ddd.getEstado());
        dddInDb.setImagemBandeira(ddd.getImagemBandeira());
    }
}
