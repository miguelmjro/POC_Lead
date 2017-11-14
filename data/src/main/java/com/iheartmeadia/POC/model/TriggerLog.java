/*
 * Created on 4 Oct 2017 ( Time 15:33:30 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.iheartmeadia.POC.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "_trigger_log"
 *
 */

@Entity
@Table(name="_trigger_log", schema="salesforcepoc" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TriggerLog.countAll", query="SELECT COUNT(x) FROM TriggerLog x" )
} )
public class TriggerLog implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    @Column(name="txid")
    private Long       txid         ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date       updatedAt    ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date       createdAt    ;


    @Column(name="sf_message", length=10485760)
    private String     sfMessage    ;


    @Column(name="values", length=10485760)
    private String     values       ;


    @Column(name="sfid", length=18)
    private String     sfid         ;


    @Column(name="action", length=7)
    private String     action       ;


    @Column(name="sf_result")
    private Integer    sfResult     ;


    @Column(name="record_id")
    private Integer    recordId     ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="processed_at")
    private Date       processedAt  ;


    @Column(name="table_name", length=128)
    private String     tableName    ;


    @Column(name="state", length=8)
    private String     state        ;


    @Column(name="processed_tx")
    private Long       processedTx  ;


    @Column(name="old", length=10485760)
    private String     old          ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TriggerLog()
    {
		super();
    }

    public TriggerLog update(TriggerLog a) {
		this.id = a.id;
        this.txid = a.txid;
        this.updatedAt = a.updatedAt;
        this.createdAt = a.createdAt;
        this.sfMessage = a.sfMessage;
        this.values = a.values;
        this.sfid = a.sfid;
        this.action = a.action;
        this.sfResult = a.sfResult;
        this.recordId = a.recordId;
        this.processedAt = a.processedAt;
        this.tableName = a.tableName;
        this.state = a.state;
        this.processedTx = a.processedTx;
        this.old = a.old;



		return a;
	}

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id )
    {
        this.id = id ;
    }
    public Integer getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : txid ( int8 ) 
    public void setTxid( Long txid )
    {
        this.txid = txid;
    }
    public Long getTxid()
    {
        return this.txid;
    }

    //--- DATABASE MAPPING : updated_at ( timestamptz ) 
    public void setUpdatedAt( Date updatedAt )
    {
        this.updatedAt = updatedAt;
    }
    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    //--- DATABASE MAPPING : created_at ( timestamptz ) 
    public void setCreatedAt( Date createdAt )
    {
        this.createdAt = createdAt;
    }
    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    //--- DATABASE MAPPING : sf_message ( text ) 
    public void setSfMessage( String sfMessage )
    {
        this.sfMessage = sfMessage;
    }
    public String getSfMessage()
    {
        return this.sfMessage;
    }

    //--- DATABASE MAPPING : values ( text ) 
    public void setValues( String values )
    {
        this.values = values;
    }
    public String getValues()
    {
        return this.values;
    }

    //--- DATABASE MAPPING : sfid ( varchar ) 
    public void setSfid( String sfid )
    {
        this.sfid = sfid;
    }
    public String getSfid()
    {
        return this.sfid;
    }

    //--- DATABASE MAPPING : action ( varchar ) 
    public void setAction( String action )
    {
        this.action = action;
    }
    public String getAction()
    {
        return this.action;
    }

    //--- DATABASE MAPPING : sf_result ( int4 ) 
    public void setSfResult( Integer sfResult )
    {
        this.sfResult = sfResult;
    }
    public Integer getSfResult()
    {
        return this.sfResult;
    }

    //--- DATABASE MAPPING : record_id ( int4 ) 
    public void setRecordId( Integer recordId )
    {
        this.recordId = recordId;
    }
    public Integer getRecordId()
    {
        return this.recordId;
    }

    //--- DATABASE MAPPING : processed_at ( timestamptz ) 
    public void setProcessedAt( Date processedAt )
    {
        this.processedAt = processedAt;
    }
    public Date getProcessedAt()
    {
        return this.processedAt;
    }

    //--- DATABASE MAPPING : table_name ( varchar ) 
    public void setTableName( String tableName )
    {
        this.tableName = tableName;
    }
    public String getTableName()
    {
        return this.tableName;
    }

    //--- DATABASE MAPPING : state ( varchar ) 
    public void setState( String state )
    {
        this.state = state;
    }
    public String getState()
    {
        return this.state;
    }

    //--- DATABASE MAPPING : processed_tx ( int8 ) 
    public void setProcessedTx( Long processedTx )
    {
        this.processedTx = processedTx;
    }
    public Long getProcessedTx()
    {
        return this.processedTx;
    }

    //--- DATABASE MAPPING : old ( text ) 
    public void setOld( String old )
    {
        this.old = old;
    }
    public String getOld()
    {
        return this.old;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(txid);
        sb.append("|");
        sb.append(updatedAt);
        sb.append("|");
        sb.append(createdAt);
        sb.append("|");
        sb.append(sfMessage);
        sb.append("|");
        sb.append(values);
        sb.append("|");
        sb.append(sfid);
        sb.append("|");
        sb.append(action);
        sb.append("|");
        sb.append(sfResult);
        sb.append("|");
        sb.append(recordId);
        sb.append("|");
        sb.append(processedAt);
        sb.append("|");
        sb.append(tableName);
        sb.append("|");
        sb.append(state);
        sb.append("|");
        sb.append(processedTx);
        sb.append("|");
        sb.append(old);
        return sb.toString(); 
    } 

}