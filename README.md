<h1>RPA API</h1> </br>


<p> O projeto consiste em um API Java construida com SpringBoot e organizada em camdas.  Controllers, reposáveis por receber as requisições HTTP. Os Services responsáveis por implementar as regras de negócio e receber dados dos controllers e repositories. Por fim os Repositorio reponsaveis se comunicar com o BD e trrafegar dados entre aplicação e BD.
 </p>

<h2>Build</h2>
<p>O projeto está configurado com Docer e Docker-Compose. </p>
<p>Para dar run no projeto basta. </p>


```
docker-compose up --build -d
 
```

<h2>Tecnologias</h2>
<ul> 
  <li> Java 1.8 </li>
  <li> Spring Boot - framework difundido na comunidade java. </li> 
  <li> Flyway - ferramenta de versionamento do Banco de dados.</li>
  <li> Lombok - produtividade e diminuir verbosidade do codigo. </li>
  <li> JPA - ORM </li>
  <li> Mokito - ferramneta para criar mocks e auxiliar na criação de testes. </li>
  <li> Junit 5 - ferramenta de teste. </li>
</ul>

<p> PS: as ferramentas de teste já vêm integradas junto com Spring Boot </p>

</br>
<h2>Sugestões e melhorias </h2>
<p> 1 - retirar o ORM para garantir maior performance.  <p/>
<p> 2 -  criar testes para os controllers que não foram cobertos </p>
<p> 3 -  documentar o código com swagger ou alguma ferramenta do genero </P>




