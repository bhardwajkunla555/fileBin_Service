package com.fileBin.spring.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "file_table")
public class UniqueKey {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private String id;
    @Column(name = "file_name")
    @JsonProperty(value = "file_name")
    private String file_name ;
    @Column(name = "unique_key")
    @JsonProperty(value = "unique_key")
    private String unique_key ;
    @Column(name = "created_ts")
    @JsonProperty(value = "created_ts")
    private LocalDateTime created_ts;
    @Column(name = "updated_ts")
    @JsonProperty(value = "updated_ts")
    private LocalDateTime updated_ts;
    @Column(name = "created_by")
    @JsonProperty(value = "created_by")
    private String created_by;
    @Column(name = "updated_by")
    @JsonProperty(value = "updated_by")
    private String updated_by;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }

    public LocalDateTime getCreated_ts() {
        return created_ts;
    }

    public void setCreated_ts(LocalDateTime created_ts) {
        this.created_ts = created_ts;
    }

    public LocalDateTime getUpdate_ts() {
        return updated_ts;
    }

    public void setUpdate_ts(LocalDateTime update_ts) {
        this.updated_ts = update_ts;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    @Override
    public String toString() {
        return "UniqueKey{" +
                "id='" + id + '\'' +
                ", file_name='" + file_name + '\'' +
                ", unique_key='" + unique_key + '\'' +
                ", created_ts=" + created_ts +
                ", updated_ts=" + updated_ts +
                ", created_by='" + created_by + '\'' +
                ", updated_by='" + updated_by + '\'' +
                '}';
    }
}
