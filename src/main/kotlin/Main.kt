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

    override fun toString(): String {
        return "( nome: '$nome', idade: $idade, cpf: '$cpf', notaMedia: $notaMedia)"
    }


}

data class Professor(
    val nome: String,
    val cpf: String,
    val formacao : String
) {
    override fun toString(): String {
        return "( nome: '$nome', cpf: '$cpf', formaçao: '$formacao')"
    }
}

data class Curso (
    val nome : String,
    val nivel : Nivel
) {
    override fun toString(): String {
        return "( nome: '$nome', nivel: $nivel)"
    }
}

data class Turma(
    val professor : Professor,
    val curso : Curso,
    var alunos: ArrayList<Aluno>
) {

    fun addAluno(alunos : ArrayList<Aluno>, aluno: Aluno ){
             alunos.add(aluno)
        }

    override fun toString(): String {
        return "Turma(Professor responsável pelo curso: $professor \n" +
                " curso: $curso \n alunos matridulados: $alunos)"
    }


}



fun main() {

    val aluno1 = Aluno("Pelé", 18,"12345678910")
    val aluno2 = Aluno("Rian", 19, "55746278948")
    val aluno3 = Aluno("Pedro de Paula", 54, "88945671345")
    val aluno4 = Aluno("Louise Carla Oliveira", 32, "31963825918")
    val aluno5 = Aluno("Olivia Sophia Andrea Teixeira", 45, "17380650300")
    val aluno6 = Aluno("Emily Raquel Mendes", 25, "64324293074")
    val aluno7 = Aluno("Priscila Joana Vieira", 20, "94612083083")
    val aluno8 = Aluno("Juan Benedito da Silva", 23, "83794534506")


    val professor1 = Professor("Milton", "55741564878", "Mestrado em Engenharia da Computação")
    val professor2 = Professor("Carla", "44678512354", "Tecnólogo em Banco de Dados")
    val professor3 = Professor("Marinho", "88745612345", "Bacharelado em Sistemas para Internet")

    val curso1 = Curso("Programação Web", Nivel.BASICO)
    val curso2 = Curso("Banco de dados", Nivel.INTERMEDIARIO)
    val curso3 = Curso("Estrutura de dados", Nivel.DIFICIL)

    val turma1 = Turma(professor1, curso3, ArrayList())
    turma1.addAluno(turma1.alunos,aluno1)
    turma1.addAluno(turma1.alunos,aluno4)
    turma1.addAluno(turma1.alunos,aluno5)

    val turma2 = Turma(professor2, curso2, ArrayList())
    turma2.addAluno(turma2.alunos, aluno2)
    turma2.addAluno(turma2.alunos, aluno3)
    turma2.addAluno(turma2.alunos, aluno8)

    val turma3 = Turma(professor3, curso1, ArrayList())
    turma3.addAluno(turma3.alunos, aluno6)
    turma3.addAluno(turma3.alunos, aluno7)

    aluno1.calcularMedia(9.3, 9.0, 8.5)
    aluno2.calcularMedia(9.0, 9.5, 9.2)
    aluno3.calcularMedia(8.5, 7.5, 6.0)
    aluno4.calcularMedia(7.0, 0.0, 6.0)
    aluno5.calcularMedia(5.5, 6.7, 5.8)
    aluno6.calcularMedia(2.5, 8.0, 5.0)
    aluno7.calcularMedia(7.5, 8.0, 6.2)
    aluno8.calcularMedia(2.5, 5.5, 6.3)

    println(turma1)
    println("\n")
    println(turma2)
    println("\n")
    println(turma3)
    println("\n")

    for(aluno in turma3.alunos){
        if(aluno.notaMedia >= 8){
            println("Aluno(a) " + aluno.nome +" aprovado(a) para o próximo curso ")
        }else{
            println("Aluno(a) " + aluno.nome + " reprovado(a)")
        }
    }

    for(aluno in turma2.alunos){
        if(aluno.notaMedia >= 8){
            println("Aluno(a) " + aluno.nome +" aprovado(a) para o próximo curso ")
        }else{
            println("Aluno(a) " + aluno.nome + " reprovado(a)")
        }
    }

    for(aluno in turma1.alunos){
        if(aluno.notaMedia >= 8){
            println("Aluno(a) " + aluno.nome +" aprovado(a) em todos os cursos ")
        }else{
            println("Aluno(a) " + aluno.nome + " reprovado(a)")
        }
    }




}