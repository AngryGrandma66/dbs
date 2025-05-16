package com.example.dbs_semestralka.dto;

import java.time.OffsetDateTime;

public class ReceptLatestRow {
    private final Integer receptId;
    private final String nazevLeku;
    private final String davkovani;
    private final OffsetDateTime datumNavstevy;

    public ReceptLatestRow(Integer receptId, String nazevLeku, String davkovani, OffsetDateTime datumNavstevy) {
        this.receptId      = receptId;
        this.nazevLeku     = nazevLeku;
        this.davkovani     = davkovani;
        this.datumNavstevy = datumNavstevy;
    }

    public Integer getReceptId()           { return receptId; }
    public String  getNazevLeku()          { return nazevLeku; }
    public String  getDavkovani()          { return davkovani; }
    public OffsetDateTime getDatumNavstevy(){ return datumNavstevy; }
}
