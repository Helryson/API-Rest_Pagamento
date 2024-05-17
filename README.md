***Instruções de uso***

O projeto ja conta com uma Configuração de teste, onde é preciso apenas fazer os requests de metodos GET e POST.

Utilizando o Postman, as seguintes requisições estarão disponíveis:

GET http://localhost:8080/validarUsuario/11111111111 (retorna true)

GET http://localhost:8080/validarUsuario/21111111112 (retorna true)

--Qualquer outro número para validação de usuário retorna falso pois não estão no banco de dados.


POST http://localhost:8080/transaction?quantia=20&CpfPagador=21111111112&CpfRecebedor=11111111111 (não há retorno, mas para que haja algum no /envio é preciso utilizar esse request


POST http://localhost:8080/envio Retorna JSON com email do recebedor e mensagem de confirmação da transação


A criação das tabelas no banco de dados H2 é feita de forma automática. O endpoint de acesso é localhost:8080/h2-console e a URL de conexão é dada no console de inicialização.
A url sempre é gerada aleatoriamente.

Um exemplo seria:  H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:526b54ef-5604-4dee-bafc-7ca1378ed2c4', onde jdbc:h2:mem:526b54ef-5604-4dee-bafc-7ca1378ed2c4 seria a URL.
