enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// solução para validar média do aluno, caso seja maior que 8 passa de nível,
// caso esteja no último nível se forma

data class Aluno(
    val nome: String,
    val idade : Int,
    val cpf : String,
    var notaMedia: Double = 0.00
    ) {
    fun calcularMedia(nota1 : Double, nota2 : Double, nota3 : Double){
        this.notaMedia = (nota1 + nota2 + nota3)/3
    }
}

data class Professor(
    val nome: String,
    val cpf: String,
    val formacao : String
)

data class Curso (
    val nome : String,
    val nivel : Nivel
)

data class Turma(
    val professor : Professor,
    val curso : Curso,

) {
    lateinit var alunos: Any



    fun isInitia(){
        if(this::alunos.isInitialized) {
            println("Inicializada")
        }
    }
    fun addAluno(nome: String, idade : Int, cpf : String ){
            this.alunos = arrayOf(Aluno(nome, idade, cpf))

        }

}



fun main(args: Array<String>) {
    var aluno1 = Aluno("Pelé", 18,"12345678910", 0.00)
    var aluno2 = Aluno("Rian", 19, "55746278948")
    val aluno3 = Aluno("Pedro de Paula", 54, "88945671345")
    println(aluno1.nome)

    val professor1 = Professor("Milton", "55741564878", "Mestrado em Engenharia da Computação")
    val professor2 = Professor("Carla", "44678512354", "Tecnólogo em Banco de Dados")
    val professor3 = Professor("Marinho", "88745612345", "Bacharelado em Sistemas para Internet")

    val curso1 = Curso("Programação Web", Nivel.BASICO)
    val curso2 = Curso("Banco de dados", Nivel.INTERMEDIARIO)
    val curso3 = Curso("Estrutura de dados", Nivel.DIFICIL)

    var turma1 = Turma(professor1, curso3)

    turma1.isInitia()
    turma1.addAluno("aluno1.nome", aluno1.idade, "aluno1.cpf")
    // println(turma1.alunos.joinToString())
}