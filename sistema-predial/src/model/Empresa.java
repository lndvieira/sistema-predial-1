package model;

public class Empresa {
	
	private int id;
	private int conjunto;
	private String razaoSocial;
	private String cnpj;
	private String temperatura;
	private Horario horaFuncionamento;
	private Horario horaArCondicionado;
	
	public Empresa() {}
	
	public Empresa(int conjunto, String razaoSocial, String cnpj, String temperatura, Horario horaFuncionamento, Horario horaArCondicionado) {
		setConjunto(conjunto);
		setRazaoSocial(razaoSocial);
		setCnpj(cnpj);
		setTemperatura(temperatura);
		setHoraFuncionamento(horaFuncionamento);
		setHoraArCondicionado(horaArCondicionado);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getConjunto() {
		return conjunto;
	}
	
	public void setConjunto(int conjunto) {
		this.conjunto = conjunto;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	
	public String getHoraFuncionamento() {
		return horaFuncionamento.toString();
	}
	
	public void setHoraFuncionamento(Horario horaFuncionamento) {
		this.horaFuncionamento = horaFuncionamento;
	}
	
	public String getHoraArCondicionado() {
		return horaArCondicionado.toString();
	}
	
	public void setHoraArCondicionado(Horario horaArCondicionado) {
		this.horaArCondicionado = horaArCondicionado;
	}
	
	@Override
	public String toString() {
		return "\nID: " + getId() + 
			   "\nRazão Social: " + getRazaoSocial() + 
			   "\nCNPJ: " + getCnpj() + 
			   "\nConjunto: " + getConjunto() + 
			   "\nTempreratura: " + getTemperatura() + 
			   "\nHorário de funcionamento: " + getHoraFuncionamento() + 
			   "\nHorário do Ar-Condicionado: " + getHoraArCondicionado();
	}
}
