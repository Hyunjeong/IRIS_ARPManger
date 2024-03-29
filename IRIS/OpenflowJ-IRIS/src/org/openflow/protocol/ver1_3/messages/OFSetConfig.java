package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFSetConfig extends OFMessage implements org.openflow.protocol.interfaces.OFSetConfig {
    public static int MINIMUM_LENGTH = 12;
    public static int CORE_LENGTH = 4;

    short  flags;
	short  miss_send_length;

    public OFSetConfig() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)9));
    }
    
    public OFSetConfig(OFSetConfig other) {
    	super(other);
		this.flags = other.flags;
		this.miss_send_length = other.miss_send_length;
    }

	public short getFlags() {
		return this.flags;
	}
	
	public OFSetConfig setFlags(short flags) {
		this.flags = flags;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isFlagsSupported() {
		return true;
	}
			
	public short getMissSendLength() {
		return this.miss_send_length;
	}
	
	public OFSetConfig setMissSendLength(short miss_send_length) {
		this.miss_send_length = miss_send_length;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isMissSendLengthSupported() {
		return true;
	}
			
	
	
	
	public OFSetConfig dup() {
		return new OFSetConfig(this);
	}
	
    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.flags = data.getShort();
		this.miss_send_length = data.getShort();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putShort(this.flags);
		data.putShort(this.miss_send_length);
    }

    public String toString() {
        return super.toString() +  ":OFSetConfig-"+":flags=" + U16.f(flags) + 
		":miss_send_length=" + U16.f(miss_send_length);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
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
        		
		final int prime = 2377;
		int result = super.hashCode() * prime;
		result = prime * result + (int) flags;
		result = prime * result + (int) miss_send_length;
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
        if (!(obj instanceof OFSetConfig)) {
            return false;
        }
        OFSetConfig other = (OFSetConfig) obj;
		if ( flags != other.flags ) return false;
		if ( miss_send_length != other.miss_send_length ) return false;
        return true;
    }
}
