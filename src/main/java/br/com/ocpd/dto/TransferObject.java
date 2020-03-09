package br.com.ocpd.dto;

import org.json.JSONObject;

import java.io.Serializable;

public abstract class TransferObject implements Serializable {

    private Long id;
    private String label;

    public TransferObject() {
    }

    public TransferObject(JSONObject obj) {
        try {
            if (obj.getInt ("id") > 0) {
                setId(obj.getLong("id"));
            } else {
                setId(0L);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setId(0L);
        }
    }

    public TransferObject(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransferObject other = (TransferObject) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
