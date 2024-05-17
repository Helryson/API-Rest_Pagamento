O projeto ja conta com uma Configuração de teste, onde é preciso apenas fazer os requests de metodos GET e POST.

Utilizando o Postman, as seguintes requisições estarão disponíveis:

GET http://localhost:8080/validarUsuario/11111111111 (retorna true)

GET http://localhost:8080/validarUsuario/21111111112 (retorna true)

--Qualquer outro número para validação de usuário retorna falso pois não estão no banco de dados.


POST http://localhost:8080/transaction?quantia=20&CpfPagador=21111111112&CpfRecebedor=11111111111 (não há retorno, mas para que haja algum no /envio é preciso utilizar esse request)
--Lança e


POST http://localhost:8080/envio(retorna JSON com email do recebedor e mensagem de confirmação da transação)
