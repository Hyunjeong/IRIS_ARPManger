package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;
import java.util.LinkedList;
import java.util.List;

public class OFStatisticsPortReply extends OFStatisticsReply implements org.openflow.protocol.interfaces.OFStatisticsPortReply {
    public static int MINIMUM_LENGTH = 12;
    public static int CORE_LENGTH = 0;

    List<org.openflow.protocol.interfaces.OFPortStatsEntry>  entries;

    public OFStatisticsPortReply() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)17));
		setStatisticsType(OFStatisticsType.valueOf((short)4, this.type));
    }
    
    public OFStatisticsPortReply(OFStatisticsPortReply other) {
    	super(other);
		this.entries = (other.entries == null)? null: new LinkedList<org.openflow.protocol.interfaces.OFPortStatsEntry>();
		for ( org.openflow.protocol.interfaces.OFPortStatsEntry i : other.entries ) { this.entries.add( i.dup() ); }
    }

	public List<org.openflow.protocol.interfaces.OFPortStatsEntry> getEntries() {
		return this.entries;
	}
	
	public OFStatisticsPortReply setEntries(List<org.openflow.protocol.interfaces.OFPortStatsEntry> entries) {
		this.entries = entries;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isEntriesSupported() {
		return true;
	}
			
	
	
	
	public OFStatisticsPortReply dup() {
		return new OFStatisticsPortReply(this);
	}
	
    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		super.readFrom(data);
		if (this.entries == null) this.entries = new LinkedList<org.openflow.protocol.interfaces.OFPortStatsEntry>();
		int __cnt = ((int)getLength() - (data.position() - mark));
		while (__cnt > 0) { OFPortStatsEntry t = new OFPortStatsEntry(); t.readFrom(data); this.entries.add(t); __cnt -= OFPortStatsEntry.MINIMUM_LENGTH; }
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        if (this.entries != null ) for (org.openflow.protocol.interfaces.OFPortStatsEntry t: this.entries) { t.writeTo(data); }
    }

    public String toString() {
        return super.toString() +  ":OFStatisticsPortReply-"+":entries=" + entries;
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
		if ( this.entries != null ) for ( org.openflow.protocol.interfaces.OFPortStatsEntry i : this.entries ) { len += i.computeLength(); }
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req) {
    	return (short)((total + (req-1))/req*req - total);
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	short total = computeLength();
    	return (short)(total - (short)MINIMUM_LENGTH + alignment(total, 0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 2551;
		int result = super.hashCode() * prime;
		result = prime * result + ((entries == null)?0:entries.hashCode());
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFStatisticsPortReply)) {
            return false;
        }
        OFStatisticsPortReply other = (OFStatisticsPortReply) obj;
		if ( entries == null && other.entries != null ) { return false; }
		else if ( !entries.equals(other.entries) ) { return false; }
        return true;
    }
}
