public class Paciente {
    private String nome;
    private String rg;
    private String cpf;
    private int data_nascimento;
    private char sexo;
    private Responsavel responsavel;

    public  Paciente() {

    }
    public Paciente(String nome, String rg, String cpf, int dataNascimento, char sexo) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        data_nascimento = dataNascimento;
        this.sexo = sexo;
    }
    public Paciente(String nome, String rg, String cpf, int dataNascimento, char sexo, Responsavel responsavel) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        data_nascimento = dataNascimento;
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
        return data_nascimento;
    }

    public void setData_nascimento(int data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
