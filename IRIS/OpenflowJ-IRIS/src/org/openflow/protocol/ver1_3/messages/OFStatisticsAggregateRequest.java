package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;
import org.openflow.protocol.OFPort;

public class OFStatisticsAggregateRequest extends OFStatisticsRequest implements org.openflow.protocol.interfaces.OFStatisticsAggregateRequest {
    public static int MINIMUM_LENGTH = 52;
    public static int CORE_LENGTH = 36;

    byte  table_id;
	short pad_1th;
	byte pad_2th;
	int  out_port;
	int  out_group;
	int pad_3th;
	long  cookie;
	long  cookie_mask;
	org.openflow.protocol.interfaces.OFMatchOxm  match;

    public OFStatisticsAggregateRequest() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)18));
		setStatisticsType(OFStatisticsType.valueOf((short)2, this.type));
    }
    
    public OFStatisticsAggregateRequest(OFStatisticsAggregateRequest other) {
    	super(other);
		this.table_id = other.table_id;
		this.out_port = other.out_port;
		this.out_group = other.out_group;
		this.cookie = other.cookie;
		this.cookie_mask = other.cookie_mask;
		this.match = new OFMatchOxm((OFMatchOxm)other.match);
    }

	public byte getTableId() {
		return this.table_id;
	}
	
	public OFStatisticsAggregateRequest setTableId(byte table_id) {
		this.table_id = table_id;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isTableIdSupported() {
		return true;
	}
			
	public OFPort getOutPort() {
		return OFPort.of(this.out_port);
	}
	
	public OFStatisticsAggregateRequest setOutPort(OFPort port) {
		this.out_port = (int) port.get();
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isOutPortSupported() {
		return true;
	}
	
	public int getOutGroup() {
		return this.out_group;
	}
	
	public OFStatisticsAggregateRequest setOutGroup(int out_group) {
		this.out_group = out_group;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isOutGroupSupported() {
		return true;
	}
			
	public long getCookie() {
		return this.cookie;
	}
	
	public OFStatisticsAggregateRequest setCookie(long cookie) {
		this.cookie = cookie;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isCookieSupported() {
		return true;
	}
			
	public long getCookieMask() {
		return this.cookie_mask;
	}
	
	public OFStatisticsAggregateRequest setCookieMask(long cookie_mask) {
		this.cookie_mask = cookie_mask;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isCookieMaskSupported() {
		return true;
	}
			
	public org.openflow.protocol.interfaces.OFMatch getMatch() {
		return this.match;
	}
	
	public OFStatisticsAggregateRequest setMatch(org.openflow.protocol.interfaces.OFMatch match) {
		this.match = (OFMatchOxm) match;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isMatchSupported() {
		return true;
	}
			
	
	
	
	public OFStatisticsAggregateRequest dup() {
		return new OFStatisticsAggregateRequest(this);
	}
	
    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.table_id = data.get();
		this.pad_1th = data.getShort();
		this.pad_2th = data.get();
		this.out_port = data.getInt();
		this.out_group = data.getInt();
		this.pad_3th = data.getInt();
		this.cookie = data.getLong();
		this.cookie_mask = data.getLong();
		if (this.match == null) this.match = new OFMatchOxm();
		this.match.readFrom(data);
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.put(this.table_id);
		data.putShort(this.pad_1th);
		data.put(this.pad_2th);
		data.putInt(this.out_port);
		data.putInt(this.out_group);
		data.putInt(this.pad_3th);
		data.putLong(this.cookie);
		data.putLong(this.cookie_mask);
		match.writeTo(data);
    }

    public String toString() {
        return super.toString() +  ":OFStatisticsAggregateRequest-"+":table_id=" + U8.f(table_id) + 
		":out_port=" + U32.f(out_port) + 
		":out_group=" + U32.f(out_group) + 
		":cookie=" + U64.f(cookie) + 
		":cookie_mask=" + U64.f(cookie_mask) + 
		":match=" + match;
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
		len += match.lengthDiff();
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
        		
		final int prime = 1847;
		int result = super.hashCode() * prime;
		result = prime * result + (int) table_id;
		result = prime * result + (int) out_port;
		result = prime * result + (int) out_group;
		result = prime * result + (int) cookie;
		result = prime * result + (int) cookie_mask;
		result = prime * result + ((match == null)?0:match.hashCode());
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
        if (!(obj instanceof OFStatisticsAggregateRequest)) {
            return false;
        }
        OFStatisticsAggregateRequest other = (OFStatisticsAggregateRequest) obj;
		if ( table_id != other.table_id ) return false;
		if ( out_port != other.out_port ) return false;
		if ( out_group != other.out_group ) return false;
		if ( cookie != other.cookie ) return false;
		if ( cookie_mask != other.cookie_mask ) return false;
		if ( match == null && other.match != null ) { return false; }
		else if ( !match.equals(other.match) ) { return false; }
        return true;
    }
}
