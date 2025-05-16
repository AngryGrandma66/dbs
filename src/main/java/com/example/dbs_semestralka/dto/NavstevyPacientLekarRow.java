// src/main/java/com/example/dbs_semestralka/dto/NavstevyPacientLekarRow.java
package com.example.dbs_semestralka.dto;

import java.time.OffsetDateTime;

public class NavstevyPacientLekarRow {
    private final Integer navstevaId;
    private final OffsetDateTime datumNavstevy;
    private final String pacientJmeno;
    private final String pacientPrijmeni;
    private final String lekarJmeno;
    private final String lekarPrijmeni;

    public NavstevyPacientLekarRow(Integer navstevaId,
                                   OffsetDateTime datumNavstevy,
                                   String pacientJmeno,
                                   String pacientPrijmeni,
                                   String lekarJmeno,
                                   String lekarPrijmeni) {
        this.navstevaId      = navstevaId;
        this.datumNavstevy   = datumNavstevy;
        this.pacientJmeno    = pacientJmeno;
        this.pacientPrijmeni = pacientPrijmeni;
        this.lekarJmeno      = lekarJmeno;
        this.lekarPrijmeni   = lekarPrijmeni;
    }

    public Integer getNavstevaId()       { return navstevaId; }
    public OffsetDateTime getDatumNavstevy() { return datumNavstevy; }
    public String getPacientJmeno()      { return pacientJmeno; }
    public String getPacientPrijmeni()   { return pacientPrijmeni; }
    public String getLekarJmeno()        { return lekarJmeno; }
    public String getLekarPrijmeni()     { return lekarPrijmeni; }
}
