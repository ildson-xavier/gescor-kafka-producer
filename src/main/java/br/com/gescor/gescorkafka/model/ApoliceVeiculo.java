package br.com.gescor.gescorkafka.model;

import java.util.Date;

public class ApoliceVeiculo {

	public Integer codigoSegurado; // SegCod.APO
	
	public Integer codigoApolice; // ApoSeq.APO = IAF
	public Integer apoliceAno; // ApoAno.APO    = IAF
	
	public String seguradora; // PlfDes.PLF    APO.SgaCod = PLF.PlfCod
	
	public String apolice; // ApoNumApoEnd.APO
	public String situacao; // ApoSit.APO [R, A]
	public Date apoliceDateInicio; // ApoDatIni.APO
	public Date apoliceDateFim; // ApoDatFin.APO
	
	public String segurado; // IafPflNom.IAF
	public String tipoVeiculo; // IafVeiTpo
	public String placa; // IafVeiPla
	public String cor; // IafVeiCor
	public String renavan; // IafVeiRen
	
	public Integer getCodigoSegurado() {
		return codigoSegurado;
	}
	public void setCodigoSegurado(Integer codigoSegurado) {
		this.codigoSegurado = codigoSegurado;
	}
	public Integer getCodigoApolice() {
		return codigoApolice;
	}
	public void setCodigoApolice(Integer codigoApolice) {
		this.codigoApolice = codigoApolice;
	}
	public Integer getApoliceAno() {
		return apoliceAno;
	}
	public void setApoliceAno(Integer apoliceAno) {
		this.apoliceAno = apoliceAno;
	}
	public String getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(String seguradora) {
		this.seguradora = seguradora;
	}
	public String getApolice() {
		return apolice;
	}
	public void setApolice(String apolice) {
		this.apolice = apolice;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getApoliceDateInicio() {
		return apoliceDateInicio;
	}
	public void setApoliceDateInicio(Date apoliceDateInicio) {
		this.apoliceDateInicio = apoliceDateInicio;
	}
	public Date getApoliceDateFim() {
		return apoliceDateFim;
	}
	public void setApoliceDateFim(Date apoliceDateFim) {
		this.apoliceDateFim = apoliceDateFim;
	}
	public String getSegurado() {
		return segurado;
	}
	public void setSegurado(String segurado) {
		this.segurado = segurado;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getRenavan() {
		return renavan;
	}
	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}
	
	
	
}
