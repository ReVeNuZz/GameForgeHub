package com.gameforge.gameforgehub.controller;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/files")
public class FileController {

    private final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) return "Por favor, selecciona un archivo.";

        try {
            // Crea la carpeta si no existe
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            return "Archivo subido exitosamente: " + file.getOriginalFilename();
        } catch (IOException e) {
            return "Error al subir el archivo: " + e.getMessage();
        }
    }
}