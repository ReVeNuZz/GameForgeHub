package com.gameforge.gameforgehub.model;

import jakarta.persistence.*;

@Entity
public class FileResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String filePath;
    private String fileType;
}