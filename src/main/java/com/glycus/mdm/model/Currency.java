/**
 *
 */
package com.glycus.mdm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author agarlapa
 *
 */
@Entity
@Table(name = "currency", schema = "mdm")
@XmlRootElement
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID", nullable = false)
    private Long id;

    @Column(name = "C_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "C_CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "C_STATUS", nullable = false)
    private String status;

    @Column(name = "C_CREATED_DATE_TIME", nullable = false)
    private Date createdDateTime;

    @Column(name = "C_MODIFIED_DATE_TIME", nullable = true)
    private Date modifiedDateTime;

    @Version
    @Column(name = "C_VERSION", nullable = false)
    private Long version;

    public Currency() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}