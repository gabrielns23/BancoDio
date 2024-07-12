package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;


}