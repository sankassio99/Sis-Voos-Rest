# Sis-Voos-Rest
 Sistema REST de busca de voos em JAVA
 
 
## EndPoints Rest
1. consultar voos por origem e destino 
// Projeto-rest/consulta/id_origem-id_destino <br>
Ex: `` http://localhost:8080/Sis-Voos-Rest/api/voos/3032-977 ``
2. consultar voos por origem, destino e data de partida(ano-mês-dia)
// Projeto-rest/consulta/id_origem-id_destino/yy-mm-dd <br>
Ex: `` http://localhost:8080/Sis-Voos-Rest/api/voos/3032-977/2020-07-10 ``
 
3. consultar voos por origem, destino, data de partida e faixa de preço
// Projeto-rest/consulta/id_origem-id_destino/yy-mm-dd/precoMin-precoMax <br>
Ex: ``http://localhost:8080/Sis-Voos-Rest/api/voos/3032-977/2020-07-10/590.0-600.0``
4. cadastrar reserva do voo
// Projeto-rest/cadastrar/codVoo
5. alterar reserva do voo
// Projeto-rest/alterar/codVoo
6. excluir reserva do voo
// Projeto-rest/delete/codVoo
