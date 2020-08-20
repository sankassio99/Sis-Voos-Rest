# Sis-Voos-Rest
 Sistema REST de busca de voos em JAVA
 
 
## EndPoints Rest
1. consultar voos por origem e destino 
// Projeto-rest/consulta/id_origem/id_destino <br>
Ex: `` http://localhost:8080/Sis-Voos-Rest/api/voos/3032/977 ``
2. consultar voos por origem, destino e data de partida(ano-mês-dia)
// Projeto-rest/consulta/id_origem/id_destino/yy-mm-dd <br>
Ex: `` http://localhost:8080/Sis-Voos-Rest/api/voos/3032/977/2020-07-10 ``
 
3. consultar voos por origem, destino, data de partida e faixa de preço
// Projeto-rest/consulta/id_origem/id_destino/yy-mm-dd/precoMin/precoMax <br>
Ex: ``http://localhost:8080/Sis-Voos-Rest/api/voos/3032/977/2020-07-10/590.0/600.0``
4. cadastrar reserva do voo<br>
Ex: ``http://localhost:8080/Sis-Voos-Rest/api/voos/reserva``
5. alterar reserva do voo<br>
Ex: ``http://localhost:8080/Sis-Voos-Rest/api/voos/reserva``
6. excluir reserva do voo<br>
Ex: ``http://localhost:8080/Sis-Voos-Rest/api/voos/reserva/idDaReserva``


### Exemplo de Retorno
`` [
  {
    "id": 2,
    "data_partida": "jul 10, 2020",
    "data_chegada": "jul 10, 2020",
    "hora_partida": "15:15",
    "hora_chegada": "16:45",
    "preco": 590.9,
    "origem": {
      "id": 3032,
      "nome": "Palmas",
      "estado": {
        "id": 18,
        "nome": "Paraná",
        "uf": "PR"
      }
    },
    "destino": {
      "id": 977,
      "nome": "Goiânia",
      "estado": {
        "id": 9,
        "nome": "Goiás",
        "uf": "GO"
      }
    },
    "aeronave": {
      "id": 1,
      "nome": "Boing",
      "capacidade": 190
    },
    "companhia": {
      "id": 1,
      "nome": "Azul"
    },
    "piloto": {
      "id": 1,
      "nome": "Juan Francisco Junior"
    }
  }
]
``
