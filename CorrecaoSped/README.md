# CorrecaoSped
Pequena aplica��o pra corre��o de um problema de Contas Contabeis no Sped PisCofins

Com base em uma altera��o na Legisla��o em outubro de 2017, o Sped PIS/COFINS passou a obrigar que uma "Conta Anal�tica-Cont�bil"
fosse informada no "registro 0500" e nos campos dos Registros C170(para NFEs) e C175(para NFCs).

Como o sistema da empresa nao faz isso(até entao), eu criei um mini sisteminha para fazer essas pequenas alterações no arquivo,
alem de praticar programação em Java.

Este sistema pede que o arquivo Sped seja importado. 
Nas Tratativas, o proprio sistema busca um arquivo com parametros (que fica na pasta src/main/resources) para inserir os titulos relacionados às contas tributarias.

Ap�s isso, o sistema insere nos campos especificos (campo 37 do registro C175) o valor referente � conta contabil solicitada.



Sobre o sisteminha:
Utilizo um Bean para fazer uma espécie de ponte (ou gerenciamento) entre a tela de importacao do arquivo para a classe que executa o processo.

Utilizo Classes para fazer a leitura do Arquivo, e utilizo alguns arrays para ler e alterar o arquivo.
EX: seleciono a linha do registro C170. Quebro em array para localizar o campo correto para inserir o codigo da conta contabil(9000012)


Utilizo tambem Design Patterns "FACTORY METHOD" para executar as acoes, pois o processo é o mesmo, mas para empresas diferentes, logo as contas contabeis tambem são diferentes. Uma vez que cada empresa possui a sua propria conta contabil

E Finalizo imprimindo o arquivo em TXT no mesmo formato de um arquivo SPED, ja com os devidos dados inseridos

obrigado!!
