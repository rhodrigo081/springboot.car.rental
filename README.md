# Decola Tech 2025
API RESTful in Spring boot created for bootcamp Decola Tech 2025 in Digital Innovation One

## Class Diagram

```mermaid

classDiagram
    class Filial {
        +string CNPJ_Filial
        +string Telefone
        +string Email
    }

    class Veiculo {
        +string Placa
        +string Modelo
        +string Cor
    }

    class TipoVeiculo {
        +int Cd_Tipo
        +string Descricao
    }

    class NLV {
        +int Nr_NLV
        +string Data
        +float ValorLocacao
    }

    class Cliente {
        +int Cd_Cliente
        +string Telefone
        +string Email
        +Filial filial
    }

    class ClientePF {
        +string CPF_Cliente
        +string Sexo
        +string DtNascimento
    }

    class ClientePJ {
        +string CNPJ_Cliente
        +string Inscricao
        +string RazaoSocial
    }

    Filial "1" -- "*" Veiculo : possui
    Filial "1" -- "*" Cliente : possui
    Filial "1" -- "*" NLV : realiza
    Veiculo "1" -- "1" NLV : está registrado
    Cliente "1" -- "*" NLV : faz
    Veiculo "1" -- "1" TipoVeiculo : classificado como
    ClientePF --|> Cliente : herda
    ClientePJ --|> Cliente : herda
