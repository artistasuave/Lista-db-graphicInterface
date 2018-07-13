package bean;

/**
 * @author Michelle de Jesus Rogério
 */
public class AlunoBean {

    private int id;
    private double nota1, nota2, nota3;
    private String nome, cod_matricula;
    private byte frequencia;

public int getId(){
    return id;
}
    
    public void setId(int id){
    this.id = id;
}

    private double getNota1(){
    return nota1;
}

    public void setNota1(double nota1){
    this.nota1 = nota1;
}

    private double getNota2(){
    return nota2;
}

    public void setNota2(double nota2){
    this.nota2 = nota2;
}

    private double getNota3(){
    return nota3;
}

    public void setNota3(double nota3){
    this.nota3 = nota3;
}

    private String getNome(){
    return nome;
}

    public void setNome(String nome){
    this.nome = nome;
}

    private String getCod_matricula(){
    return cod_matricula;
}

    public void setCodMatricula(String cod_matricula){
    this.cod_matricula = cod_matricula;
}

    private byte getFrequencia(){
    return frequencia;
}

    public void setFrequencia(byte frequencia){
    this.frequencia = frequencia;
}
}