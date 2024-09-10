package org.ddd.services;

import org.ddd.entities.Ddd;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class DDDService {
    private String caminhoDestino = "C:\\Users\\aluno\\Downloads\\DDD\\DDD\\src\\main\\resources\\images\\";

    public static String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "No extension" : fileName.substring(dotIndex + 1);
    }

    public boolean salvarImagem(Ddd ddd) {
        Path path = Paths.get(ddd.getImagemBandeira());

        Path pastaDestino = Paths.get(String.format("%s%d.%s", caminhoDestino, ddd.getCodigo(), getFileExtension(ddd.getImagemBandeira())));

        if (Files.exists(path)) {
            try {
                Files.copy(path, pastaDestino, StandardCopyOption.REPLACE_EXISTING);
                ddd.setImagemBandeira(pastaDestino.getFileName().toString());
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }

    private String buscarCaminhoArquivoPorId(int id) {
        File diretorio = new File(caminhoDestino);
        File[] matches = diretorio.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(String.valueOf(id));
            }
        });
        return Arrays.stream(matches).findFirst().get().getAbsolutePath();
    }

    public void removerImagem(int id) {
        Path path = Paths.get(buscarCaminhoArquivoPorId(id));

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarImagem(Ddd ddd) {
        removerImagem(ddd.getCodigo());
        salvarImagem(ddd);
    }
}
