package com.jorgeyampara.model;

public class Revision {

    private String codigo;
    private String filtro;
    private String aceite;
    private String frenos;

    private Coche coche;

    public Revision(String codigo, String filtro, String aceite, String frenos, Coche coche) {
        this.setCodigo(codigo);
        this.setFiltro(filtro);
        this.setAceite(aceite);
        this.setFrenos(frenos);
        this.setCoche(coche);
    }

    public Revision() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getAceite() {
        return aceite;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    public String getFrenos() {
        return frenos;
    }

    public void setFrenos(String frenos) {
        this.frenos = frenos;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "codigo='" + codigo + '\'' +
                ", filtro='" + filtro + '\'' +
                ", aceite='" + aceite + '\'' +
                ", frenos='" + frenos + '\'' +
                ", coche=" + coche +
                '}';
    }
}
