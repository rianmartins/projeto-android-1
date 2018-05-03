package com.rianmartins.android1_project;

import java.io.Serializable;

/**
 * Created by rianmartins on 17/04/18.
 */

public class PostoGasolina implements Serializable{

    public static final String POSTO_INFO = "POSTO_INFO";

    private String nome;
    private String endereco;
    private double lat;
    private double lng;
    private String telefoneContato;
    private double precoGasolina;
    private double precoGasolinaAditivada;
    private double precoAlcool;
    private double precoDiesel;
    private double precoDieselS10;
    private String bandeira;
    private int bandeiraLogo;

    public PostoGasolina(String nome, String endereco, String telefoneContato, String bandeira, int bandeiraLogo) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefoneContato = telefoneContato;
        this.bandeira = bandeira;
        this.bandeiraLogo = bandeiraLogo;

        this.precoAlcool = 0;
        this.precoDiesel = 0;
        this.precoDieselS10 = 0;
        this.precoGasolina = 0;
        this.precoGasolinaAditivada = 0;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public int getBandeiraLogo() {
        return bandeiraLogo;
    }

    public void setBandeiraLogo(int bandeiraLogo) {
        this.bandeiraLogo = bandeiraLogo;
    }

    public double getCombustivelPrioritario(){

        String combustivelPref = "gas";

        switch (combustivelPref){
            case "gas":
                return precoGasolina;
            case "gas-adt":
                return precoGasolinaAditivada;
            case "alc":
                return precoAlcool;
            case "die":
                return precoDiesel;
            case "die-s10":
                return precoDieselS10;
            default:
                return 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public double getPrecoGasolinaAditivada() {
        return precoGasolinaAditivada;
    }

    public void setPrecoGasolinaAditivada(double precoGasolinaAditivada) {
        this.precoGasolinaAditivada = precoGasolinaAditivada;
    }

    public double getPrecoAlcool() {
        return precoAlcool;
    }

    public void setPrecoAlcool(double precoAlcool) {
        this.precoAlcool = precoAlcool;
    }

    public double getPrecoDiesel() {
        return precoDiesel;
    }

    public void setPrecoDiesel(double precoDiesel) {
        this.precoDiesel = precoDiesel;
    }

    public double getPrecoDieselS10() {
        return precoDieselS10;
    }

    public void setPrecoDieselS10(double precoDieselS10) {
        this.precoDieselS10 = precoDieselS10;
    }
}
