package com.example.dbs_semestralka.dto;

public class DiagnostikaPacientKardiologieRow {
    private final String pacientJmeno;
    private final String pacientPrijmeni;
    private final String kod;
    private final String popis;
    private final String lekarJmeno;
    private final String lekarPrijmeni;

    public DiagnostikaPacientKardiologieRow(
            String pacientJmeno,
            String pacientPrijmeni,
            String kod,
            String popis,
            String lekarJmeno,
            String lekarPrijmeni
    ) {
        this.pacientJmeno    = pacientJmeno;
        this.pacientPrijmeni = pacientPrijmeni;
        this.kod             = kod;
        this.popis           = popis;
        this.lekarJmeno      = lekarJmeno;
        this.lekarPrijmeni   = lekarPrijmeni;
    }

    public String getPacientJmeno()    { return pacientJmeno; }
    public String getPacientPrijmeni() { return pacientPrijmeni; }
    public String getKod()             { return kod; }
    public String getPopis()           { return popis; }
    public String getLekarJmeno()      { return lekarJmeno; }
    public String getLekarPrijmeni()   { return lekarPrijmeni; }
}
