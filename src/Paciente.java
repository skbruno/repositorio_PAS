public class Paciente {
    private String nome;
    private String rg;
    private String cpf;
    private int idade;
    private String sexo;
    private Responsavel responsavel;

    public  Paciente() {

    }
    public Paciente(String nome, String rg, String cpf, int idade, String sexo) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }
    public Paciente(String nome, String rg, String cpf, int idade, String sexo, Responsavel responsavel) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getData_nascimento() {
        return idade;
    }

    public void setData_nascimento(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
