package com.apress.prospring3.ch10.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

@Entity
@Table(name = "contact_audit")
public class ContactAudit implements Auditable<String, Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    // @Temporal means we would like to map the data type from the Java
    // date type (java.util.Date) to the SQL data type (java.sql.Date).
    // So, we can access the attribute birthDate in Contact object using
    // java.util.Date as usual in our application.
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    // Audit fields
    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    // Fix: use org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime
    // instead of org.joda.time.contrib.hibernate.PersistentDateTime. For more
    // details see
    // http://stackoverflow.com/questions/14900875/java-lang-abstractmethoderror-org-joda-time-contrib-hibernate-persistentdatetim
    @Column(name = "LAST_MODIFIED_DATE")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastModifiedDate;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Transient
    @Override
    public boolean isNew() {
        return (id == null);
    }

    @Override
    public String toString() {
        return "ContactAudit [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName="
                + lastName + ", birthDate=" + birthDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
                + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
    }

}