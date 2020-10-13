# API Cadastro de Clientes 

Uma API simples para listagem, cadastro, edição e delete de Clientes e suas transações. 

Utiliza-se Spring Boot e MongoDB para o armazenamentos dos dados.

## Validação dos Dados

Essa API conta com a validação de campos obrigatórios e também sobre os dados optativos, pois manter a integridade da base de dados é algo fundamental dentro da aplicação. As validações realizadas não são apenas da existência dos parâmetros, indo além. Exemplos:

## Recursos da API

Todas as requisições foram feitas por meio do Cliente HTTP **Insomnia**.

### Listar Clientes [GET/clientes]


 
    {
        "id": "5f85d6bfd238f0049fdf5875",
        "name": "Angela Acerbi",
        "cpf": "90258558067"
    },
    {
    
        "id": "5f85d6bfd238f0049fdf5876",
        "name": "Maria Rossi",
        "cpf": "57370238008"
     },
     {
        "id": "5f85d6bfd238f0049fdf5877",
        "name": "Antonio Martini",
         "cpf": "90485609002"
      }


### Criar Cliente [POST/cliente]

+ Request (application/json)


       {
	        "name": "Vincenzo Pizzoli",
	        "cpf": "17001687030"
        }


### Atualizar informações do Cliente [PUT/cliente/:id]

+ Request (application/json)
  
  
    {
	
	      "name": "Umberto Caruso",
	      "cpf": "53728505072"
    }



### Deletar o Cliente [Delete/cliente/:id]


            
### Listar o Saldo e os valores transferidos, identificando quem fez a transferencia e a data  [Get/cliente/:id/AtualizarSaldo]


[
    {
         "id": "5f85d6bfd238f0049fdf5878",
         "date": "2020-10-09T00:00:00.000+00:00",
         "value": 4000.0,
         "owner": {
         "id": "5f85d6bfd238f0049fdf5877",
         "name": "Antonio Martini",
         "cpf": "90485609002"
    },
        "transfers": [
                        {
                            "value": 5000.0,
                            "date": "2020-10-09T00:00:00.000+00:00",
                             "owner": {
                                           "id": "5f85d6bfd238f0049fdf5876",
                                            "name": "Maria Rossi",
                                            "cpf": "57370238008"
                                       }
                        },
                       {
                              "value": 3000.0,
                               "date": "2020-10-07T00:00:00.000+00:00",
                                "owner": {
                                                "id": "5f85d6bfd238f0049fdf5876",
                                               "name": "Maria Rossi",
                                               "cpf": "57370238008"
                                           }
                      }
            ]
  }
]

