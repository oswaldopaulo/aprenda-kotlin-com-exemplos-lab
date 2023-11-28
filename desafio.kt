enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val id: Long)

data class Conteudo(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<Conteudo>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado com sucesso!")
    }
}

fun main() {
    //ADICIONANDO CONTEUDO
    val listaDeConteudos: List<Conteudo> = listOf(
        Conteudo("Modulo 1 ", 60),
        Conteudo("Modulo 2", 90)
    )

    //ADICIONANDO OS USUARIO
    val aluno1 = Usuario("Oswaldo", 10)
    val aluno2 = Usuario("Paulo", 20)

    //ADICIONANDO AS FORMAÇÕES
    val formacao = Formacao("Curso 1", listaDeConteudos, Nivel.INTERMEDIARIO)
    formacao.matricular(aluno1)
    formacao.matricular(aluno2)


    //PRINTANDO NA TELA
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.map { it.nome }}. Nível: ${Nivel.INTERMEDIARIO}. Conteúdos : ${formacao.conteudos.map { it.nome}}.")


}