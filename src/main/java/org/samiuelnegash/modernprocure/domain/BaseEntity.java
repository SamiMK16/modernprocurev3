package org.samiuelnegash.modernprocure.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @GenericGenerator(name = "hibernateSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "increment_size",value = "50")})
    @Column(name = "web_id", unique = true, nullable = false)
    protected Long webId;

    @Version
    @Column(nullable = false, columnDefinition="integer default 0 ")
    protected Integer version;

    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateUpdated;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    @PrePersist
    @PreUpdate
    public void onUpdate()
    {
        if (dateCreated == null)
        {
            dateCreated = new Date();
        }
        this.setDateUpdated(new Date());
    }

    @Override
    public int hashCode()
    {
        if (webId == null)
        {
            return super.hashCode();
        }
        int hash = 1;
        hash = hash * 17 + this.getClass().hashCode();
        hash = hash * 31 + webId.hashCode();
        return hash;
    }
}
