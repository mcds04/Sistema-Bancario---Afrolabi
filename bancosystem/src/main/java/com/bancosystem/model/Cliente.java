package com.bancosystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private double rendaSalarial;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Conta> contas;
}
