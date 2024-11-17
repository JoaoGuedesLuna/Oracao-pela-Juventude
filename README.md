<h1>Oração pela Juventude 🙏</h1>
<p align="justify">
    Eu e meus amigos somos um grupo de cristãos evangélicos e, todas as segundas-feiras, nos reunimos para estudar a Bíblia. Ao fim da chamada de vídeo, costumamos orar por alguns assuntos, e uma das práticas que adotamos durante a oração é orar uns pelos outros. Cada pessoa ora pela vida de um participante específico, até que todos tenham sido orados e orado por alguém.
</p>
<p align="justify">
    Este algoritmo foi desenvolvido em Java ☕ utilizando a IDE IntelliJ. No entanto, sua lógica pode ser aplicada em qualquer linguagem de programação orientada a objetos (POO). O propósito deste algoritmo é realizar sorteios dentro de um grupo de pessoas para determinar quem orará por quem. Embora simples, ele resolve um problema cotidiano de maneira eficaz e exemplifica como a programação pode ser uma ferramenta valiosa para resolver desafios diários por meio do pensamento computacional.
</p>
<p align="center">
    <img src="https://i.imgur.com/lbmY4Xv.png" width="600" alt="Imagem do algoritmo em execução">
</p>
<h2>▶ Executando a Aplicação</h2>
<h3>1. Execução via Arquivo .bat</h3>
<p align="justify">
    Uma maneira de executar o programa é através do arquivo <code>.bat</code>, localizado no diretório <b>/dist</b>. Ao executar este arquivo, o programa solicitará que você insira os nomes dos participantes, que devem ser passados <b>separados por vírgula</b> e <b>sem aspas</b>.
</p>
<p align="justify">
    Exemplo de entrada:
</p>
<pre>
    Marcelo Luna, Solange Guedes, Maria Eduarda, João Guedes
</pre>
<p align="center">
    <img src="https://i.imgur.com/zIhMhrl.png" width="600">
</p>
<h3>2. Execução via IDE</h3>
<p align="justify">
    Se você preferir executar o programa diretamente em uma IDE, como IntelliJ, os parâmetros devem ser configurados nas opções de execução. Ao passar os nomes dos participantes para a aplicação, <b>todos os nomes devem estar envolvidos por aspas</b> e <b>separados por vírgula</b>.
</p>
<p align="justify">
    Exemplo de entrada:
</p>
<pre>
    "Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay"
</pre>
<p align="center">
    <img src="https://i.imgur.com/If5bwYc.png" width="600">
</p>
<h3>3. Mensagens de Erro</h3>
<p align="justify">
    A aplicação possui duas exceções customizadas para garantir que os parâmetros sejam passados corretamente:
</p>
<h4>3.1. <code>NoArgumentsException</code></h4>
<p align="justify">
    Lançada quando nenhum argumento (ou lista de nomes) é fornecido, ou quando a formatação está incorreta ao executar via <code>.bat</code>. Se estiver executando via CLI, a lista de nomes deve estar entre aspas, como no exemplo:
</p>
<pre>
    "Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay"
</pre>
<p align="justify">
    Ao executar via arquivo <code>.bat</code>, <b>não use aspas</b>, apenas separe os nomes por vírgula:
</p>
<pre>
    Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay
</pre>
<h4>3.2. <code>InvalidArgumentException</code></h4>
<p align="justify">
    Lançada quando os parâmetros fornecidos estão em um formato inválido, como quando os nomes não estão todos entre aspas ao executar via CLI. A entrada correta seria:
</p>
<pre>
    "Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay"
</pre>
<p align="justify">
    Não utilize as aspas separando os nomes individualmente, como neste formato incorreto:
</p>
<pre>
    "Alexsandra", "Cassiane", "Ely"
</pre>